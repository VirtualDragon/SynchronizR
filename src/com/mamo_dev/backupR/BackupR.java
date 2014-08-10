package com.mamo_dev.backupR;

import com.mamo_dev.backupR.gui.Gui;
import com.mamo_dev.backupR.gui.LicenseGui;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class BackupR {

	public static final String VERSION = "1.4.9";
	public static final long releaseDate = 201408102103L;

	private static Properties settings;
	private static final Lang lang = new Lang("lang");

	public static void main(String[] args) throws IOException, URISyntaxException {
		for (String arg : args) {
			if (arg.toLowerCase().startsWith("locale:")) {
				getLang().changeLocale(new Locale(arg.substring("locale:".length())));
			}
		}
		
		final File settingsFile = new File(new File(BackupR.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile(), "settings.properties");
		settings = new Properties(settingsFile);

		HashMap<String, Object> defaultValues = new HashMap<>();
		for (PropertyEnum preference : PropertyEnum.values()) {
			defaultValues.put(preference.toString(), preference.defaultValue());
		}
		getSettings().setDefaultValues(defaultValues);
		getSettings().setAutoSaveEnabled(true);

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
				}

				final JFrame window = new JFrame("BackupR v. " + VERSION);
				window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				final Gui gui = new Gui();
				gui.setEverythingEnabled(false);
				gui.getProgressBar().setIndeterminate(true);
				window.setContentPane(gui);
				window.pack();
				window.setMinimumSize(window.getSize());
				window.setSize(getSettings().getInt(PropertyEnum.WINDOW_WIDTH.toString()), getSettings().getInt(PropertyEnum.WINDOW_HEIGHT.toString()));
				window.setVisible(true);
				if (getSettings().getInt(PropertyEnum.WINDOW_X.toString()) == Integer.MIN_VALUE || getSettings().getInt(PropertyEnum.WINDOW_Y.toString()) == Integer.MIN_VALUE) {
					window.setLocationRelativeTo(null);
				} else {
					window.setLocation(getSettings().getInt(PropertyEnum.WINDOW_X.toString()), getSettings().getInt(PropertyEnum.WINDOW_Y.toString()));
				}
				if (getSettings().getBoolean(PropertyEnum.WINDOW_MAXIMIZED.toString())) {
					window.setExtendedState(Frame.MAXIMIZED_BOTH);
				}

				if (!getSettings().getBoolean("acceptedLicense")) {
					gui.getProgressBar().setIndeterminate(false);
					LicenseGui licenseGui = new LicenseGui(window, true);
					licenseGui.setTitle("BackupR");
					licenseGui.setSize(640, 480);
					licenseGui.setLocationRelativeTo(null);
					licenseGui.setVisible(true);
					if (licenseGui.getReturnStatus() == 1) {
						try {
							getSettings().set(PropertyEnum.ACCEPTED_LICENSE.toString(), true);
						} catch (IOException ex) {
						}
					} else {
						settingsFile.delete();
						System.exit(0);
					}
					gui.getProgressBar().setIndeterminate(true);
				}

				window.addComponentListener(new ComponentListener() {
					@Override
					public void componentResized(ComponentEvent e) {
						try {
							if ((((JFrame) e.getComponent()).getExtendedState() & Frame.MAXIMIZED_BOTH) != Frame.MAXIMIZED_BOTH) {
								getSettings().set(PropertyEnum.WINDOW_WIDTH.toString(), (int) e.getComponent().getSize().getWidth());
								getSettings().set(PropertyEnum.WINDOW_HEIGHT.toString(), (int) e.getComponent().getSize().getHeight());
								getSettings().set(PropertyEnum.WINDOW_MAXIMIZED.toString(), false);
							} else {
								getSettings().set(PropertyEnum.WINDOW_MAXIMIZED.toString(), true);
							}
						} catch (IOException ex) {
						}
					}

					@Override
					public void componentMoved(ComponentEvent e) {
						try {
							if ((((JFrame) e.getComponent()).getExtendedState() & Frame.MAXIMIZED_BOTH) != Frame.MAXIMIZED_BOTH) {
								getSettings().set(PropertyEnum.WINDOW_X.toString(), (int) e.getComponent().getLocation().getX());
								getSettings().set(PropertyEnum.WINDOW_Y.toString(), (int) e.getComponent().getLocation().getY());
								getSettings().set(PropertyEnum.WINDOW_MAXIMIZED.toString(), false);
							} else {
								getSettings().set(PropertyEnum.WINDOW_MAXIMIZED.toString(), true);
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

				if (getSettings().getBoolean(PropertyEnum.AUTOMATIC_UPDATE_CHECK.toString())) {
					new Thread(new Runnable() {
						@Override
						public void run() {
							try {
								Updater updater = new Updater(new URL("https://sites.google.com/site/mamoswebsite/backupr/versions.xml"), releaseDate);
								updater.checkForUpdates();
								gui.getProgressBar().setIndeterminate(false);
								if (updater.areUpdatesAvaiable() && (getSettings().getBoolean(PropertyEnum.AUTOMATIC_UPDATE_INSTALLATION.toString()) || JOptionPane.showOptionDialog(window, getLang().get("updateFound"), "BackupR", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{getLang().get("yes"), getLang().get("no")}, null) == 0)) {
									gui.getProgressBar().setIndeterminate(true);
									updater.update();
									gui.getProgressBar().setIndeterminate(false);
									String jrePath = System.getProperty("java.home") + File.separator + "bin" + File.separator;
									if (System.getProperty("os.name").toLowerCase().contains("windows")) {
										jrePath += "java.exe";
									} else {
										jrePath += "java";
									}
									Runtime.getRuntime().exec(new String[]{jrePath, "-jar", new File(BackupR.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getPath()});
									System.exit(0);
								}
								gui.setEverythingEnabled(true);
							} catch (MalformedURLException ex) {
							} catch (IOException ex) {
							}
						}
					}).start();
				} else {
					gui.setEverythingEnabled(true);
					gui.getProgressBar().setIndeterminate(false);
				}
			}
		});
	}

	public static Properties getSettings() {
		return settings;
	}

	public static Lang getLang() {
		return lang;
	}
}
