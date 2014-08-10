package com.mamo_dev.backupR;

import java.util.Locale;
import java.util.ResourceBundle;

public class Lang {

	private ResourceBundle lang;

	public Lang(String resourceBundle) {
		lang = ResourceBundle.getBundle(resourceBundle);
	}

	public String get(String arg, Object... args) {
		return String.format(lang.getString(arg), args);
	}

	public void changeLocale(Locale locale) {
		lang = ResourceBundle.getBundle("lang", locale);
	}
}
