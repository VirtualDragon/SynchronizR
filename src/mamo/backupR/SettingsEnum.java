package mamo.backupR;

import java.awt.GraphicsEnvironment;
import java.io.File;
import java.net.URISyntaxException;

public enum SettingsEnum {

	ACCEPTED_LICENSE("acceptedLicense", false),
	FROM("from", new File(System.getProperty("user.home")).getPath()),
	TO("to", to().getPath()),
	ADVANCED_ENABLED("advancedEnabled", false),
	COPY_ONLY_NEWER_FILES("copyOnlyNewerFiles", true),
	OVERRIDE_IF_NECESSARY("overrideIfNecessary", true),
	MIRROR_PURGE("mirrorPurge", true),
	WINDOW_WIDTH("window.width", 640),
	WINDOW_HEIGHT("window.height", 480),
	WINDOW_X("window.x", Integer.MIN_VALUE),
	WINDOW_Y("window.y", Integer.MIN_VALUE),
	WINDOW_MAXIMIZED("window.maximized", false),
	AUTOMATIC_UPDATE_CHECK("automaticUpdateCheck", true),
	AUTOMATIC_UPDATE_INSTALLATION("automaticUpdateInstallation", false);

	private static File to() {
		try {
			return new File(new File(SettingsEnum.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile(), "Backup");
		} catch (URISyntaxException ex) {
		}
		return null;
	}

	private final String keyName;
	private final Object defaultValue;

	SettingsEnum(String keyName, Object defaultValue) {
		this.keyName = keyName;
		this.defaultValue = defaultValue;
	}

	public Object defaultValue() {
		return defaultValue;
	}

	@Override
	public String toString() {
		return keyName;
	}
}
