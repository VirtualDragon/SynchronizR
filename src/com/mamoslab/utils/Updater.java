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

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Updater {

	private final long releaseTime;
	private Document xml = null;
	private URL update;

	public Updater(URL url, long releaseDate) {
		try {
			URLConnection connection = url.openConnection();
			connection.setConnectTimeout(3000);
			connection.setReadTimeout(3000);
			BufferedInputStream in = new BufferedInputStream(connection.getInputStream());
			xml = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(in);
			in.close();
			xml.getDocumentElement().normalize();
		} catch (ParserConfigurationException ex) {
		} catch (SAXException ex) {
		} catch (IOException ex) {
		}
		this.releaseTime = releaseDate;
	}

	public boolean update() {
		if (areUpdatesAvaiable()) {
			try {
				BufferedOutputStream out = null;
				try {
					out = new BufferedOutputStream(new FileOutputStream(new File(Updater.class.getProtectionDomain().getCodeSource().getLocation().toURI()), false));
				} catch (URISyntaxException ex) {
				}
				BufferedInputStream in = new BufferedInputStream(update.openStream());
				int b;
				while ((b = in.read()) != -1) {
					out.write(b);
				}
				out.flush();
				out.close();
				in.close();
				return true;
			} catch (IOException ex) {
				return false;
			}
		} else {
			return false;
		}
	}

	public void checkForUpdates() {
		if (xml == null) {
			return;
		}

		NodeList versions = xml.getElementsByTagName("version");
		long lastestTime = 0L;
		Element lastest = null;
		for (int i = 0; i < versions.getLength(); i++) {
			Element version = (Element) versions.item(i);
			long time = 0L;
			try {
				time = Long.parseLong(version.getElementsByTagName("release-time").item(0).getTextContent());
			} catch (NumberFormatException e) {
			}
			if (time > lastestTime) {
				lastestTime = time;
				lastest = version;
			}
		}
		if (lastestTime > releaseTime && lastest != null) {
			try {
				update = new URL(lastest.getElementsByTagName("download-link").item(0).getTextContent());
			} catch (MalformedURLException ex) {
			}
		}
	}

	public boolean areUpdatesAvaiable() {
		return update != null;
	}
}
