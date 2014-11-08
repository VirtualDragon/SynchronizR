/*
 BackupR
 Copyright (C) 2014 Matteo Morena

 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.
 */
package com.mamoslab.synchronizR;

import com.mamoslab.utils.Lang;
import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;

public class TreeCopier {

	private static final CopyOption[] COPY_OPTIONS = {StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING, LinkOption.NOFOLLOW_LINKS};

	private Lang lang;
	private Path from, to, relative;
	private EnumSet<TreeCopyOption> options = EnumSet.noneOf(TreeCopyOption.class);
	private ArrayList<TreeCopyEventListener> listeners = new ArrayList<TreeCopyEventListener>();

	private long bytes, bytesProcessed;
	private boolean isCancelled = false;

	public TreeCopier(Lang lang, File from, File to, File relative, TreeCopyOption... options) {
		this.lang = lang;
		this.from = from.toPath();
		this.to = to.toPath();
		this.relative = relative.toPath();
		this.options.addAll(Arrays.asList(options));

		try {
			Files.walkFileTree(this.from, new FileVisitor<Path>() {
				@Override
				public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
					bytes += file.toFile().length();
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult visitFileFailed(Path file, IOException exc) {
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
					return FileVisitResult.CONTINUE;
				}
			});
		} catch (IOException ex) {
		}
	}

	public boolean addTreeCopyEventListener(TreeCopyEventListener listener) {
		return listeners.add(listener);
	}

	public boolean removeTreeCopyEventListener(TreeCopyEventListener listener) {
		return listeners.remove(listener);
	}

	public ArrayList<TreeCopyEventListener> getTreeCopyEventListeners() {
		return (ArrayList<TreeCopyEventListener>) listeners.clone();
	}

	public void copyTree() {
		new File(to.toFile(), relative.relativize(from).toString()).mkdirs();

		try {
			Files.walkFileTree(from, new FileVisitor<Path>() {
				@Override
				public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
					if (isCancelled) {
						return FileVisitResult.TERMINATE;
					}
					File currentTo = new File(to.toFile(), relative.relativize(dir).toString());
					if (!currentTo.exists() || options.contains(TreeCopyOption.OVERRIDE_IF_NECESSARY)) {
						boolean log = !currentTo.exists() || !currentTo.isDirectory();
						if (log) {
							log(lang.get("creatingDirectoryX", currentTo.getPath()), false);
						}
						try {
							Files.copy(dir, currentTo.toPath(), COPY_OPTIONS);
							if (log) {
								log(lang.get("ok"), true);
							}
						} catch (IOException ex) {
							if (log) {
								log(lang.get("fail"), true);
							}
						}
					}
					if (options.contains(TreeCopyOption.MIRROR_PURGE)) {
						for (File currentToChild : currentTo.listFiles()) {
							if (isCancelled) {
								return FileVisitResult.TERMINATE;
							}
							boolean contains = false;
							for (File currentDirChild : dir.toFile().listFiles()) {
								if (currentDirChild.getName().equals(currentToChild.getName())) {
									contains = true;
									break;
								}
							}
							if (!contains) {
								if (!currentToChild.isDirectory()) {
									log(lang.get("deletingX", currentToChild.getPath()), false);
									if (currentToChild.delete()) {
										log(lang.get("ok"), true);
									} else {
										log(lang.get("fail"), true);
									}
								} else {
									try {
										Files.walkFileTree(currentToChild.toPath(), new FileVisitor<Path>() {

											@Override
											public FileVisitResult preVisitDirectory(Path file, BasicFileAttributes attrs) throws IOException {
												return FileVisitResult.CONTINUE;
											}

											@Override
											public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
												if (isCancelled) {
													return FileVisitResult.TERMINATE;
												}
												log(lang.get("deletingX", file), false);
												if (file.toFile().delete()) {
													log(lang.get("ok"), true);
												} else {
													log(lang.get("fail"), true);
												}
												return FileVisitResult.CONTINUE;
											}

											@Override
											public FileVisitResult visitFileFailed(Path file, IOException e) throws IOException {
												return FileVisitResult.CONTINUE;
											}

											@Override
											public FileVisitResult postVisitDirectory(Path file, IOException e) throws IOException {
												if (isCancelled) {
													return FileVisitResult.TERMINATE;
												}
												log(lang.get("deletingX", file), false);
												if (file.toFile().delete()) {
													log(lang.get("ok"), true);
												} else {
													log(lang.get("fail"), true);
												}
												return FileVisitResult.CONTINUE;
											}
										});
									} catch (IOException ex) {
									}
								}
							}
						}
					}
					log();
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
					if (isCancelled) {
						return FileVisitResult.TERMINATE;
					}
					File currentTo = new File(to.toFile(), relative.relativize(file).toString());
					boolean alreadyExists = currentTo.exists();
					if (!alreadyExists) {
						try {
							currentTo.createNewFile();
							currentTo.setLastModified(0);
						} catch (IOException ex) {
						}
					}
					boolean newer = currentTo.lastModified() < file.toFile().lastModified();
					if (!options.contains(TreeCopyOption.COPY_ONLY_NEWER_FILES) || newer) {
						if (!alreadyExists || options.contains(TreeCopyOption.OVERRIDE_IF_NECESSARY)) {
							if (newer && alreadyExists) {
								log(lang.get("updatingX", file.toString()), false);
							} else if (alreadyExists) {
								log(lang.get("recopyingX", file.toString()), false);
							} else {
								log(lang.get("copyingX", file.toString()), false);
							}
							try {
								Files.copy(file, currentTo.toPath(), COPY_OPTIONS);
								log(lang.get("ok"), true);
							} catch (IOException ex) {
								log(lang.get("fail"), true);
							}
						}
					}
					bytesProcessed += file.toFile().length();
					log();
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult visitFileFailed(Path file, IOException exc) {
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
					new File(to.toFile(), relative.relativize(dir).toString()).setLastModified(dir.toFile().lastModified());
					return FileVisitResult.CONTINUE;
				}
			});
		} catch (IOException ex) {
		}

		if (!isCancelled) {
			log(lang.get("done"), false);
		} else {
			log(lang.get("syncCancelled"), false);
		}
	}

	public long getBytes() {
		return bytes;
	}

	public long getBytesProcessed() {
		return bytesProcessed;
	}

	private void log() {
		for (TreeCopyEventListener listener : listeners) {
			listener.onEvent(new TreeCopyEvent(this));
		}
	}

	private void log(String string, boolean append) {
		for (TreeCopyEventListener listener : listeners) {
			listener.onEvent(new TreeCopyLogEvent(this, string, append));
		}
	}

	public void cancel() {
		isCancelled = true;
	}

	public enum TreeCopyOption {

		COPY_ONLY_NEWER_FILES, OVERRIDE_IF_NECESSARY, MIRROR_PURGE;
	}

	public interface TreeCopyEventListener {

		void onEvent(TreeCopyEvent event);
	}

	public class TreeCopyEvent {

		private long bytes, filesProcessed, directoriesProcessed;

		TreeCopyEvent(TreeCopier copier) {
			bytes = copier.bytes;
			filesProcessed = copier.bytesProcessed;
		}

		public long getFiles() {
			return bytes;
		}

		public long getFilesProcessed() {
			return filesProcessed;
		}

		public long getDirectoriesProcessed() {
			return directoriesProcessed;
		}
	}

	public class TreeCopyLogEvent extends TreeCopyEvent {

		private long files, directories, filesProcessed, directoriesProcessed;
		private String log;
		private boolean append;

		public TreeCopyLogEvent(TreeCopier copier, String log, boolean append) {
			this(copier);
			this.log = log;
			this.append = append;
		}

		private TreeCopyLogEvent(TreeCopier copier) {
			super(copier);
		}

		public String getLog() {
			return log;
		}

		public boolean isLogAppended() {
			return append;
		}
	}
}
