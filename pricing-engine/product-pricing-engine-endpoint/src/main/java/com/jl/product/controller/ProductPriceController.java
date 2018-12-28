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

import com.jl.product.exception.ClientCommunicationException;
import com.jl.product.exception.NoAppropraiteDataFilterProvidedException;
import com.jl.product.exception.NoDataFoundException;
import com.jl.product.filer.ProductDataFilter;
import com.jl.product.filer.ProductDataFilter.PriceLableType;
import com.jl.product.filer.ProductDataFilter.ProductSortBy;
import com.jl.product.service.IProductService;
import com.jl.product.vo.ProductVO;

@RestController
@RequestMapping("/api/v1/")
public class ProductPriceController {

	@Autowired
	IProductService productService;

	@GetMapping(value = "/products/{sortOrder}/prices/{labelType}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<ProductVO>> priceReducdedProducts(@PathVariable("labelType") PriceLableType labelType,
			@PathVariable("sortOrder") ProductSortBy sortBy) {

		List<ProductVO> productPVOs;
		List<ProductVO> response;
		try {
			productPVOs = productService.getProducts();
			ProductDataFilter filter = new ProductDataFilter(productPVOs, labelType, sortBy);
			response = productService.getProducedsWithWithFilter(filter);
			return new ResponseEntity<List<ProductVO>>(response, HttpStatus.OK);
		} catch (NoDataFoundException e) {
			e.printStackTrace();
			return new ResponseEntity(null, HttpStatus.METHOD_FAILURE);
		} catch (ClientCommunicationException e) {
			e.printStackTrace();
			return new ResponseEntity(null, HttpStatus.METHOD_FAILURE);
		} catch (NoAppropraiteDataFilterProvidedException e) {
			e.printStackTrace();
			return new ResponseEntity(null, HttpStatus.METHOD_FAILURE);
		}

	}

	@GetMapping(value = "/products/prices", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<ProductVO>> priceReducdedProducts1() {
		List<ProductVO> response;
		try {
			response = productService.getProducts();
			return new ResponseEntity<List<ProductVO>>(response, HttpStatus.OK);
		} catch (NoDataFoundException | ClientCommunicationException e) {
			e.printStackTrace();
			return new ResponseEntity(null, HttpStatus.METHOD_FAILURE);
		}
	}

}
