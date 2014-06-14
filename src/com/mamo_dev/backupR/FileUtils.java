package com.mamo_dev.backupR;

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
