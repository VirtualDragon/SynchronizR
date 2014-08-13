package mamo.backupR;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

public class Settings {

	private final java.util.Properties properties = new java.util.Properties();
	private final File propertiesFile;

	private boolean autoSave;

	private Map<String, Object> defaultValues;

	public Settings(File propertiesFile) throws IOException {
		this.propertiesFile = propertiesFile;
		if (propertiesFile.exists()) {
			FileInputStream in = new FileInputStream(propertiesFile);
			properties.load(in);
			in.close();
		}
	}

	public Byte getByte(String property) {
		try {
			return Byte.parseByte(getString(property));
		} catch (NumberFormatException e) {
			return null;
		} catch (NullPointerException e) {
			return null;
		}
	}

	public Short getShort(String property) {
		try {
			return Short.parseShort(getString(property));
		} catch (NumberFormatException e) {
			return null;
		} catch (NullPointerException e) {
			return null;
		}
	}

	public Integer getInt(String property) {
		try {
			return Integer.parseInt(getString(property));
		} catch (NumberFormatException e) {
			return null;
		} catch (NullPointerException e) {
			return null;
		}
	}

	public Long getLong(String property) {
		try {
			return Long.parseLong(getString(property));
		} catch (NumberFormatException e) {
			return null;
		} catch (NullPointerException e) {
			return null;
		}
	}

	public Float getFloat(String property) {
		try {
			return Float.parseFloat(getString(property));
		} catch (NumberFormatException e) {
			return null;
		} catch (NullPointerException e) {
			return null;
		}
	}

	public Double getDouble(String property) {
		try {
			return Double.parseDouble(getString(property));
		} catch (NumberFormatException e) {
			return null;
		} catch (NullPointerException e) {
			return null;
		}
	}

	public Boolean getBoolean(String property) {
		return Boolean.parseBoolean(getString(property));
	}

	public String getString(String property) {
		return properties.getProperty(property);
	}

	public boolean contains(String property) {
		return properties.containsKey(property);
	}

	public void set(String property, Object value) throws IOException {
		properties.setProperty(property, value.toString());
		if (autoSave) {
			save();
		}
	}

	public void save() throws IOException {
		FileOutputStream out = new FileOutputStream(propertiesFile);
		properties.store(out, null);
		out.flush();
	}

	public Map<String, Object> getDefaultValues() {
		return defaultValues;
	}

	public void setDefaultValues(Map<String, Object> defaultValues) throws IOException {
		this.defaultValues = defaultValues;
		for (String property : defaultValues.keySet()) {
			if (!contains(property)) {
				set(property, defaultValues.get(property));
			}
		}
	}

	public boolean isAutoSaveEnabled() {
		return autoSave;
	}

	public void setAutoSaveEnabled(boolean autoSaveEnabled) {
		autoSave = autoSaveEnabled;
	}
}
