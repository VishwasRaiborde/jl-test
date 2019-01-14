package com.jl.product.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger log = LoggerFactory.getLogger(ProductPriceController.class);
	@Autowired
	IProductService productService;

	@GetMapping(value = "/products/{sortOrder}/prices/{labelType}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<ProductVO>> priceReducdedProducts(@PathVariable("labelType") PriceLableType labelType,
			@PathVariable("sortOrder") ProductSortBy sortBy) {

		List<ProductVO> productPVOs;
		List<ProductVO> listOfproducts;
		try {
			productPVOs = productService.getProducts();
			ProductDataFilter filter = new ProductDataFilter(productPVOs, labelType, sortBy);
			listOfproducts = productService.getFilteredProducts(filter);
			
			return new ResponseEntity<List<ProductVO>>(listOfproducts, HttpStatus.OK);
		} catch (NoDataFoundException e) {
			if(log.isDebugEnabled()) {
				log.debug(e.getMessage());
			}
			return new ResponseEntity(new ArrayList(), HttpStatus.NO_CONTENT);
		} catch (ClientCommunicationException e) {
			if(log.isDebugEnabled()) {
				log.debug(e.getMessage());
			}
			return new ResponseEntity(new ArrayList(), HttpStatus.NO_CONTENT);
		} catch (NoAppropraiteDataFilterProvidedException e) {
			if(log.isDebugEnabled()) {
				log.debug(e.getMessage());
			}
			return new ResponseEntity(new ArrayList(), HttpStatus.NO_CONTENT);
		}

	}



}
