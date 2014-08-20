package com.mamoslab.backupR;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
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
import java.util.logging.Level;
import java.util.logging.Logger;

public class TreeCopier {

	private static final CopyOption[] COPY_OPTIONS = {StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING, LinkOption.NOFOLLOW_LINKS};

	private Path from, to, relative;
	private EnumSet<TreeCopyOption> options = EnumSet.noneOf(TreeCopyOption.class);
	private ArrayList<TreeCopyEventListener> listeners = new ArrayList<TreeCopyEventListener>();
	private File root;
	
	private long files, directories, filesProcessed, directoriesProcessed;
	private boolean isCancelled = false;

	public TreeCopier(File from, File to, File relative, TreeCopyOption... options) {
		this.from = from.toPath();
		this.to = to.toPath();
		this.relative = relative.toPath();
		this.options.addAll(Arrays.asList(options));

		try {
			Files.walkFileTree(this.from, new FileVisitor<Path>() {
				@Override
				public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
					directories++;
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
					files++;
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
		root = null;
		try {
			String computerName = InetAddress.getLocalHost().getHostName();
			root = new File(computerName, from.getRoot().toString().replace(":", ""));
		} catch (UnknownHostException ex) {
			root = new File(from.getRoot().toString().replace(":", ""));
		}
		new File(to.toFile(), new File(root, relative.relativize(from).toString()).toString()).mkdirs();
		
		try {
			Files.walkFileTree(from, new FileVisitor<Path>() {
				@Override
				public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
					if (isCancelled) {
						return FileVisitResult.TERMINATE;
					}
					File currentTo = new File(to.toFile(), new File(root, relative.relativize(dir).toString()).toString());
					if (!currentTo.exists() || options.contains(TreeCopyOption.OVERRIDE_IF_NECESSARY)) {
						boolean log = !currentTo.exists() || !currentTo.isDirectory();
						if (log) {
							log(BackupR.getLang().get("creatingDirectoryX", currentTo.getAbsolutePath()), false);
						}
						try {
							Files.copy(dir, currentTo.toPath(), COPY_OPTIONS);
							if (log) {
								log(BackupR.getLang().get("ok"), true);
							}
						} catch (IOException ex) {
							if (log) {
								log(BackupR.getLang().get("fail"), true);
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
									log(BackupR.getLang().get("deletingX", currentToChild.getAbsolutePath()), false);
									if (currentToChild.delete()) {
										log(BackupR.getLang().get("ok"), true);
									} else {
										log(BackupR.getLang().get("fail"), true);
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
												log(BackupR.getLang().get("deletingX", file), false);
												if (file.toFile().delete()) {
													log(BackupR.getLang().get("ok"), true);
												} else {
													log(BackupR.getLang().get("fail"), true);
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
												log(BackupR.getLang().get("deletingX", file), false);
												if (file.toFile().delete()) {
													log(BackupR.getLang().get("ok"), true);
												} else {
													log(BackupR.getLang().get("fail"), true);
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
					directoriesProcessed++;
					log();
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
					if (isCancelled) {
						return FileVisitResult.TERMINATE;
					}
					File currentTo = new File(to.toFile(), new File(root, relative.relativize(file).toString()).toString());
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
								log(BackupR.getLang().get("updatingX", file.toString()), false);
							} else if (alreadyExists) {
								log(BackupR.getLang().get("recopyingX", file.toString()), false);
							} else {
								log(BackupR.getLang().get("copyingX", file.toString()), false);
							}
							try {
								Files.copy(file, currentTo.toPath(), COPY_OPTIONS);
								log(BackupR.getLang().get("ok"), true);
							} catch (IOException ex) {
								log(BackupR.getLang().get("fail"), true);
							}
						}
					}
					filesProcessed++;
					log();
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult visitFileFailed(Path file, IOException exc) {
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
					new File(to.toFile(), new File(root, relative.relativize(dir).toString()).toString()).setLastModified(dir.toFile().lastModified());
					return FileVisitResult.CONTINUE;
				}
			});
		} catch (IOException ex) {
		}

		if (!isCancelled) {
			log(BackupR.getLang().get("done"), false);
		} else {
			log(BackupR.getLang().get("backupCancelled"), false);
		}
	}

	public long getFiles() {
		return files;
	}

	public long getDirectories() {
		return directories;
	}

	public long getFilesProcessed() {
		return filesProcessed;
	}

	public long getDirectoriesProcessed() {
		return directoriesProcessed;
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

		private long files, directories, filesProcessed, directoriesProcessed;

		TreeCopyEvent(TreeCopier copier) {
			files = copier.files;
			directories = copier.directories;
			filesProcessed = copier.filesProcessed;
			directoriesProcessed = copier.directoriesProcessed;
		}

		public long getFiles() {
			return files;
		}

		public long getDirectories() {
			return directories;
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
