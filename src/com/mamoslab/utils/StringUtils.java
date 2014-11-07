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

public class StringUtils {

	public static String autoReturn(String string, int len) {
		String string_ = "";
		int i = 0;

		do {
			String currentString = string.substring(i, (i + len) > string.length() ? string.length() : i + len);
			int lastSpaceIndex = 0;
			if (currentString.length() >= len) {
				lastSpaceIndex = currentString.lastIndexOf(" ");
				if (lastSpaceIndex != -1) {
					currentString = currentString.substring(0, lastSpaceIndex);
				}
			}
			i += currentString.length() + (lastSpaceIndex != -1 ? 1 : 0);
			string_ += currentString + "\n";
		} while (i < string.length());

		string_ = string_.substring(0, string_.length() - 1);
		return string_;
	}
}
