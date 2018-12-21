package com.jl.configs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestClientApp {

	private static final Logger log = LoggerFactory.getLogger(RestClientApp.class);

	public static void main(String args[]) {
		SpringApplication.run(RestClientApp.class);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	/*@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			ProductCatalogue productCatalogueJSON = restTemplate.getForObject("https://jl-nonprod-syst.apigee.net/v1/categories/600001506/products?key=2ALHCAAs6ikGRBoy6eTHA58RaG097Fma", ProductCatalogue.class);
			log.info(productCatalogueJSON.toString());
		};
	}*/
}
