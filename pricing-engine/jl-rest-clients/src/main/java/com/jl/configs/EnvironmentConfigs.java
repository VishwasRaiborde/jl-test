package com.jl.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jl.property.EnvironmetProperties;

@Configuration
public class EnvironmentConfigs {
	

	@Bean
	public void buildPropertiesOnload() {
		// we dont want to bring down the serive in case the end point url changes , hence a configuration that can dynamically change the url with the application is hot and running 
		// other stratergy is using property files but wont allow us a hot change
		//TODO test and ensure the properties are changing 
		//TODO code clean up 
		EnvironmetProperties.addProperty(EnvironmetProperties.REST_URL_PRODUCTS_CATALOGUE, "https://jl-nonprod-syst.apigee.net/v1/categories/600001506/products?key=2ALHCAAs6ikGRBoy6eTHA58RaG097Fma1");
	}

}
