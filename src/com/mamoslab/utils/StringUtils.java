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
