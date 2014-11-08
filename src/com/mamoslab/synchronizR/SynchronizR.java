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

import com.mamoslab.utils.Updater;
import com.mamoslab.utils.Lang;
import com.mamoslab.utils.Settings;
import com.mamoslab.synchronizR.gui.Gui;
import com.mamoslab.utils.GuiUtils;
import com.mamoslab.utils.LicenseGui;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SynchronizR {

	public static final String VERSION = "1.9.1";
	public static final long releaseDate = 201411081222L;

	private static Settings settings;
	private static final Lang lang = new Lang("lang");
	private static boolean showUpdateMessage;

	public static void main(final String[] args) throws IOException, URISyntaxException {
		for (String arg : args) {
			if (arg.toLowerCase().startsWith("locale:")) {
				getLang().setLocale(new Locale(arg.substring("locale:".length())));
			}
			if (arg.equalsIgnoreCase("showUpdateMessage")) {
				showUpdateMessage = true;
			}
		}

		if (Integer.parseInt(System.getProperty("java.version").split("\\.")[1]) < 7) {
			JOptionPane.showOptionDialog(null, getLang().get("wrongJavaVersion", getLang().getLocale().getLanguage()), "SynchronizR", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[]{getLang().get("ok2")}, null);
			return;
		}

		settings = new Settings(new File(new File(SynchronizR.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile(), "settings.properties"));

		HashMap<String, Object> defaultValues = new HashMap<String, Object>();
		for (SettingsEnum preference : SettingsEnum.values()) {
			defaultValues.put(preference.toString(), preference.defaultValue());
		}
		getSettings().setDefaultValues(defaultValues);

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException ex) {
				} catch (InstantiationException ex) {
				} catch (IllegalAccessException ex) {
				} catch (UnsupportedLookAndFeelException ex) {
				}
				ToolTipManager.sharedInstance().setDismissDelay(Integer.MAX_VALUE);

				final JFrame window = new JFrame("SynchronizR v. " + VERSION);
				window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				final Gui gui = new Gui();
				GuiUtils.setEverythingEnabled(gui, false);
				gui.getProgressBar().setIndeterminate(true);
				window.setContentPane(gui);
				window.pack();
				window.setMinimumSize(window.getSize());
				window.setSize(getSettings().getInt(SettingsEnum.WINDOW_WIDTH.toString()), getSettings().getInt(SettingsEnum.WINDOW_HEIGHT.toString()));
				window.setVisible(true);
				if (getSettings().getInt(SettingsEnum.WINDOW_X.toString()) == Integer.MIN_VALUE || getSettings().getInt(SettingsEnum.WINDOW_Y.toString()) == Integer.MIN_VALUE) {
					window.setLocationRelativeTo(null);
				} else {
					window.setLocation(getSettings().getInt(SettingsEnum.WINDOW_X.toString()), getSettings().getInt(SettingsEnum.WINDOW_Y.toString()));
				}
				if (getSettings().getBoolean(SettingsEnum.WINDOW_MAXIMIZED.toString())) {
					window.setExtendedState(Frame.MAXIMIZED_BOTH);
				}

				if (!getSettings().getBoolean(SettingsEnum.ACCEPTED_LICENSE_2.toString())) {
					gui.getProgressBar().setIndeterminate(false);
					LicenseGui licenseGui = null;
					try {
						licenseGui = new LicenseGui(window, true, SynchronizR.class.getResource("/license.txt"));
					} catch (IOException ex) {
					}
					licenseGui.setTitle("SynchronizR");
					licenseGui.setMinimumSize(licenseGui.getMinimumSize());
					licenseGui.setSize(640, 480);
					licenseGui.setLocationRelativeTo(null);
					licenseGui.setVisible(true);
					if (licenseGui.getReturnStatus() == 1) {
						try {
							getSettings().set(SettingsEnum.ACCEPTED_LICENSE_2.toString(), true);
						} catch (IOException ex) {
						}
					} else {
						System.exit(0);
					}
					gui.getProgressBar().setIndeterminate(true);
				}

				try {
					getSettings().save();
				} catch (IOException ex) {
				}
				getSettings().setAutoSaveEnabled(true);

				window.addComponentListener(new ComponentListener() {
					@Override
					public void componentResized(ComponentEvent e) {
						try {
							if ((((JFrame) e.getComponent()).getExtendedState() & Frame.MAXIMIZED_BOTH) != Frame.MAXIMIZED_BOTH) {
								getSettings().set(SettingsEnum.WINDOW_WIDTH.toString(), (int) e.getComponent().getSize().getWidth());
								getSettings().set(SettingsEnum.WINDOW_HEIGHT.toString(), (int) e.getComponent().getSize().getHeight());
								getSettings().set(SettingsEnum.WINDOW_MAXIMIZED.toString(), false);
							} else {
								getSettings().set(SettingsEnum.WINDOW_MAXIMIZED.toString(), true);
							}
						} catch (IOException ex) {
						}
					}

					@Override
					public void componentMoved(ComponentEvent e) {
						try {
							if ((((JFrame) e.getComponent()).getExtendedState() & Frame.MAXIMIZED_BOTH) != Frame.MAXIMIZED_BOTH) {
								getSettings().set(SettingsEnum.WINDOW_X.toString(), (int) e.getComponent().getLocation().getX());
								getSettings().set(SettingsEnum.WINDOW_Y.toString(), (int) e.getComponent().getLocation().getY());
								getSettings().set(SettingsEnum.WINDOW_MAXIMIZED.toString(), false);
							} else {
								getSettings().set(SettingsEnum.WINDOW_MAXIMIZED.toString(), true);
							}
						} catch (IOException ex) {
						}
					}

					@Override
					public void componentShown(ComponentEvent e) {
					}

					@Override
					public void componentHidden(ComponentEvent e) {
					}
				});

				window.addWindowListener(new WindowListener() {

					@Override
					public void windowOpened(WindowEvent e) {
					}

					@Override
					public void windowClosing(WindowEvent e) {
						if (!gui.getSyncGui().isBackingUp()) {
							window.dispose();
						} else {
							JOptionPane.showOptionDialog(window, getLang().get("cantCloseWhileSync"), "SynchronizR", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[]{getLang().get("ok2")}, null);
						}
					}

					@Override
					public void windowClosed(WindowEvent e) {
					}

					@Override
					public void windowIconified(WindowEvent e) {
					}

					@Override
					public void windowDeiconified(WindowEvent e) {
					}

					@Override
					public void windowActivated(WindowEvent e) {
					}

					@Override
					public void windowDeactivated(WindowEvent e) {
					}
				});

				if (SynchronizR.showUpdateMessage) {
					gui.getProgressBar().setIndeterminate(false);
					JOptionPane.showOptionDialog(window, SynchronizR.getLang().get("updated"), "SynchronizR", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{SynchronizR.getLang().get("ok2")}, null);
				}

				if (getSettings().getBoolean(SettingsEnum.AUTOMATIC_UPDATE_CHECK.toString())) {
					new Thread(new Runnable() {
						@Override
						public void run() {
							try {
								Updater updater = new Updater(new URL("https://raw.githubusercontent.com/MamosLab/SynchronizR/master/versions.xml"), releaseDate);
								updater.checkForUpdates();
								gui.getProgressBar().setIndeterminate(false);
								if (updater.areUpdatesAvaiable() && (getSettings().getBoolean(SettingsEnum.AUTOMATIC_UPDATE_INSTALLATION.toString()) || JOptionPane.showOptionDialog(window, getLang().get("updateFound"), "SynchronizR", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{getLang().get("yes"), getLang().get("no")}, null) == 0)) {
									gui.getProgressBar().setIndeterminate(true);
									updater.update();
									String jrePath = System.getProperty("java.home") + File.separator + "bin" + File.separator;
									if (System.getProperty("os.name").toLowerCase().contains("win")) {
										jrePath += "java.exe";
									} else {
										jrePath += "java";
									}
									try {
										ArrayList<String> args_ = new ArrayList<String>();
										args_.add(jrePath);
										args_.add("-jar");
										args_.add(new File(SynchronizR.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getAbsolutePath());
										args_.addAll(Arrays.asList(args));
										args_.remove("showUpdateMessage");
										if (!getSettings().getBoolean(SettingsEnum.AUTOMATIC_UPDATE_INSTALLATION.toString())) {
											args_.add("showUpdateMessage");
										}
										Runtime.getRuntime().exec(args_.toArray(new String[args_.size()]));
									} catch (URISyntaxException ex) {
									}
									System.exit(0);
								} else {
									GuiUtils.setEverythingEnabled(gui, true);
								}
							} catch (MalformedURLException ex) {
							} catch (IOException ex) {
							}
						}
					}).start();
				} else {
					GuiUtils.setEverythingEnabled(gui, true);
					gui.getProgressBar().setIndeterminate(false);
				}
			}
		});
	}

	public static Settings getSettings() {
		return settings;
	}

	public static Lang getLang() {
		return lang;
	}
}
