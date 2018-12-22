package com.product.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductPriceController {
	
	

	@GetMapping(value="/v1/products/{labelType}/prices",produces={ MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public  ResponseEntity priceReducdedProducts(   @RequestParam(value ="labelType", required =false) String labelType) {
		return null;
		
	}

}
