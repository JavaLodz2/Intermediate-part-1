package sda.code.intermediate.part1.exercises.patterns;

import java.util.Properties;

import sda.code.intermediate.FileUtils;

public enum Settings {
	CONFIG;

	private final Properties props;

	private Settings() {
		props = new FileUtils().loadDefaultProperties();
	}

	public String getString(String name) {
		String value = props.getProperty(name);
		if (value == null) {
			throw new SettingMissing(name);
		} else {
			return value;
		}
		// throw new UnsupportedOperationException("Not implemented yet");
	}

	public int getInteger(String name){
		String value = props.getProperty(name);
		if (value == null) {
			throw new SettingMissing(name);
		} else {
			return Integer.parseInt(value);
		}
		// throw new UnsupportedOperationException("Not implemented yet");
	}

	public boolean getBoolean(String name) {
		String value = props.getProperty(name);
		if (value == null) {
			throw new SettingMissing(name);
		} else {
			return Boolean.parseBoolean(value);
		}
		// throw new UnsupportedOperationException("Not implemented yet");
	}

	public String getString(String name, String defaultValue) {
		// props.getProperty(name, defaultValue);
		return (props.containsKey(name)) ? getString(name) : defaultValue;
	}

	public int getInteger(String name, int defaultValue) {
		if (props.containsKey(name)) {
			try {
				int value = getInteger(name);
				return value;
			} catch (NumberFormatException e) {
				//Rzuc exceptiona do testow ale normalnie zwroc defaultValue
				throw new NumberFormatException();
			}
		}
		return defaultValue;
		// return (props.containsKey(name)) ? getInteger(name) : defaultValue;
	}

	public boolean getBoolean(String name, boolean defaultValue) {
		return (props.containsKey(name)) ? getBoolean(name) : defaultValue;
	}
}
