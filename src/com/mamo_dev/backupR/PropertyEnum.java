package com.mamo_dev.backupR;

import java.awt.GraphicsEnvironment;
import java.io.File;

public enum PropertyEnum {

	FROM("from", new File(System.getProperty("user.home")).getPath()),
	TO("to", new File(new File(PropertyEnum.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParentFile(), "Backup").getPath()),
	ADVANCED_ENABLED("advancedEnabled", false),
	COPY_ONLY_NEWER_FILES("copyOnlyNewerFiles", true),
	OVERRIDE_IF_NECESSARY("overrideIfNecessary", true),
	MIRROR_PURGE("mirrorPurge", true),
	WINDOW_WIDTH("window.width", 640),
	WINDOW_HEIGHT("window.height", 480),
	WINDOW_X("window.x", (GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth() - (Integer) WINDOW_WIDTH.defaultValue()) / 2),
	WINDOW_Y("window.y", (GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight() - (Integer) WINDOW_HEIGHT.defaultValue()) / 2),
	WINDOW_MAXIMIZED("window.maximized", false),
	AUTOMATIC_UPDATE_CHECK("automaticUpdateCheck", true),
	AUTOMATIC_UPDATE_INSTALLATION("automaticUpdateInstallation", false);

	private final String keyName;
	private final Object defaultValue;

	PropertyEnum(String keyName, Object defaultValue) {
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
