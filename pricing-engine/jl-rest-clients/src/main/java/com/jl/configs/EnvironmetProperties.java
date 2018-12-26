package com.jl.configs;

import java.util.HashMap;
import java.util.Map;

public class EnvironmetProperties {

	private EnvironmetProperties() {
		
	}
	
	public static final String REST_URL_PRODUCTS_CATALOGUE = "rest.url";
	
	public static final Map<String,String> propertyMap= new HashMap<String,String>();
	
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
