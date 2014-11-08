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

public enum SettingsEnum {

	ACCEPTED_LICENSE_2("acceptedLicense2", false),
	FROM("from", ""),
	TO("to", ""),
	ADVANCED_ENABLED("advancedEnabled", false),
	COPY_WHOLE_DIRECTORY_TREE("copyWholeDirectoryTree", false),
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
