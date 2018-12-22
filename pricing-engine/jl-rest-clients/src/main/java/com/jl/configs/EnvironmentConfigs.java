package com.jl.configs;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnvironmentConfigs {
	

	@Bean
	public Map buildPropertiesOnload() {
		EnvironmetProperties.addProperty(EnvironmetProperties.REST_URL_PRODUCTS_CATALOGUE, "https://jl-nonprod-syst.apigee.net/v1/categories/600001506/products?key=2ALHCAAs6ikGRBoy6eTHA58RaG097Fma1");
		return EnvironmetProperties.propertMap;
	}

}
