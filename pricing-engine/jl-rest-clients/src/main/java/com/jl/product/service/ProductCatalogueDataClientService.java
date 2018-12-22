package com.jl.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jl.product.clients.rest.ProductCatalogueClient;
import com.jl.product.exception.ClientCommunicationException;
import com.jl.product.exception.NoDataFoundException;
import com.jl.product.mapper.ProductDataMapper;
import com.jl.product.response.RestResponse;
import com.jl.product.utils.PriceComputorUtils;
import com.jl.product.vo.ProductVO;
import com.jl.product.vo.json.ProductCatalogue;

@Service
public class ProductCatalogueDataClientService {
	
	@Autowired
	private ProductCatalogueClient productCatalogueClient;

	@Autowired
	ProductDataMapper productDataMapperService;
	

 public List<ProductVO>  getProductsHavingPriceReductionCatalogue() throws NoDataFoundException, ClientCommunicationException {
		
		List<ProductVO> productsWithPriceReduction = new ArrayList<ProductVO>();
		RestResponse<ProductCatalogue> restResponse = productCatalogueClient.getProducts();
		List<ProductVO> products = productDataMapperService.copyFromJsonToVo(restResponse.getResponse().getProducts());
		
		for (ProductVO product : products) {
			boolean hasPriceReduced = PriceComputorUtils.calculatePriceDrop(product.getPrice());
			if(hasPriceReduced) {
				productsWithPriceReduction.add(product);
			}
		}
		return productsWithPriceReduction;
	}

}
