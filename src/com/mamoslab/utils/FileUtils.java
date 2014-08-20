package com.mamoslab.utils;

import java.io.File;

public class FileUtils {

	public static boolean dirContainsFile(File dir, File file) {
		if (dir.isDirectory()) {
			while ((file = file.getParentFile()) != null) {
				if (file.equals(dir)) {
					return true;
				}
			}
		}

		return false;
	}
}
