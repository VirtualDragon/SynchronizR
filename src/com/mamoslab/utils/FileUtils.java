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
