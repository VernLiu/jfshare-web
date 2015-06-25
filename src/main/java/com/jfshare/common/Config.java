package com.jfshare.common;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class Config {

	private static final String APPLICATION_PROPERTIES_FILE = "properties" + File.separator + "application.properties"; 
	private static final String USER_PROPERTIES_FILE = "properties" + File.separator + "user.properties"; 
	
	private static final Map<String, Object> AppConfig;
	private static final Map<String, Object> UserConfig;

	static {
		AppConfig = loadProperties(APPLICATION_PROPERTIES_FILE);
		UserConfig = loadProperties(USER_PROPERTIES_FILE);
	}
	
	private static HashMap<String, Object> loadProperties(String filePath) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		InputStream is = Config.class.getClassLoader().getResourceAsStream(filePath);
		Properties props = new Properties();
		try {
			try{
				props.load(is);
			} finally {
				if(is != null)
					is.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Set<Entry<Object, Object>> entry = props.entrySet();
		for(Iterator<Entry<Object, Object>> it = entry.iterator(); it.hasNext();) {
			Entry<Object, Object> ele = it.next();
			result.put((String)ele.getKey(), ele.getValue());
		}
		return result;
	}
	
	public static String getAppStringValue(String key, String defaultValue) {
		return getStringValue(AppConfig, key, defaultValue);
	}
	
	public static List<String> getUserKeys() {
		return getKeys(UserConfig);
	}
	
	public static String getUserStringValue(String key, String defaultValue) {
		return getStringValue(UserConfig, key, defaultValue);
	}
	
	private static String getStringValue(Map<String, Object> config, String key, String defaultValue) {
		String value = (String)config.get(key);
		return value != null ? value : defaultValue;
	}
	
	private static List<String> getKeys(Map<String, Object> config) {
		return new ArrayList<String>(config.keySet());
	}
}
