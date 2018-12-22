package com.jl.configs;

import java.util.HashMap;
import java.util.Map;

public class EnvironmetProperties {
	// TODO code clean up 
	private EnvironmetProperties() {
		
	}
	
	public static final String REST_URL_PRODUCTS_CATALOGUE = "rest.url";
	
	public static Map<String,String> propertMap= new HashMap<String,String>();
	
	public static void clearAllConfigs() {
		propertMap.clear();
	}
	
	public static void addProperty(String propertyKey , String propertyValue) {
		propertMap.put(propertyKey,propertyValue);
	}
	
	public static String getProperty(String propertyKey ) {
		return propertMap.get(propertyKey);
	}

}
