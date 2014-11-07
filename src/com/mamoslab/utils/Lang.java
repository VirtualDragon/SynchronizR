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
package com.mamoslab.utils;

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
