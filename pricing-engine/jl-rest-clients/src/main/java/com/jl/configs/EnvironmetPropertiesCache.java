package com.jl.configs;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class EnvironmetPropertiesCache {
	
	public static final Hashtable<String, String> colorCache = new Hashtable<String, String>();
	public static final Map<String,String> propertyMap= new HashMap<String,String>();
	

	private EnvironmetPropertiesCache() {
		
	}
	
	public static final String REST_URL_PRODUCTS_CATALOGUE = "rest.url";
	

	
	public static void clearAllConfigs() {
		propertyMap.clear();
	}
	
	public static void addProperty(String propertyKey , String propertyValue) {
		propertyMap.put(propertyKey,propertyValue);
	}
	
	public static String getProperty(String propertyKey ) {
		return propertyMap.get(propertyKey);
	}

}
