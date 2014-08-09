package com.mamo_dev.backupR;

import java.util.ResourceBundle;

public class Lang {
	private static ResourceBundle lang = ResourceBundle.getBundle("lang");
	
	public static String get(String arg, Object... args) {
		return String.format(lang.getString(arg), args);
	}
}