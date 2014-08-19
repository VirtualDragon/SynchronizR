package mamo.utils;

import java.util.Locale;
import java.util.ResourceBundle;

public class Lang {

	private final String resourceBundle;
	private ResourceBundle lang;

	public Lang(String resourceBundle) {
		this(resourceBundle, Locale.getDefault());
	}

	public Lang(String resourceBundle, Locale locale) {
		this.resourceBundle = resourceBundle;
		lang = ResourceBundle.getBundle(resourceBundle, locale);
	}

	public String get(String arg, Object... args) {
		return String.format(lang.getString(arg), args);
	}

	public void setLocale(Locale locale) {
		lang = ResourceBundle.getBundle(resourceBundle, locale);
	}

	public Locale getLocale() {
		return lang.getLocale();
	}
}
