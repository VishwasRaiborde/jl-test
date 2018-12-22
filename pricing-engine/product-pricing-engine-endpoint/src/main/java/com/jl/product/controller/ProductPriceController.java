package com.jl.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jl.product.service.IProductService;
import com.jl.product.vo.ProductVO;

@RestController
@RequestMapping("/api/v1/")
public class ProductPriceController {
	
	@Autowired
	IProductService productService;

	@GetMapping(value="/products/{labelType}/prices",produces={MediaType.APPLICATION_JSON_VALUE})
	public  ResponseEntity<List<ProductVO>> priceReducdedProducts(@PathVariable("labelType") String labelType) {
		List<ProductVO>  response =  productService.getProducedsWithPriceReduction();
		return new ResponseEntity<List<ProductVO>>(response,HttpStatus.OK);
	}
	
	@GetMapping(value="/products/prices",produces={ MediaType.APPLICATION_JSON_VALUE})
	public  ResponseEntity<List<ProductVO>> priceReducdedProducts1() {
		List<ProductVO>  response =  productService.getProducedsWithPriceReduction();
		return new ResponseEntity<List<ProductVO>>(response,HttpStatus.OK);
	}

}
