package com.mamo_dev.backupR;

import java.util.Locale;
import java.util.ResourceBundle;

public class Lang {

	private static ResourceBundle lang = ResourceBundle.getBundle("lang");

	public static String get(String arg, Object... args) {
		return String.format(lang.getString(arg), args);
	}

	public static void changeLocale(Locale locale) {
		lang = ResourceBundle.getBundle("lang", locale);
	}
}
