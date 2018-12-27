package com.jl.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jl.product.clients.rest.ProductCatalogueClient;
import com.jl.product.exception.ClientCommunicationException;
import com.jl.product.exception.NoAppropraiteDataFilterProvidedException;
import com.jl.product.exception.NoDataFoundException;
import com.jl.product.filer.ProductDataFilter;
import com.jl.product.filer.ProductDataFilterService;
import com.jl.product.mapper.ProductDataMapper;
import com.jl.product.response.RestResponse;
import com.jl.product.vo.ProductVO;
import com.jl.product.vo.json.ProductCatalogue;

@Service
public class ProductService implements IProductService {

	@Autowired
	private ProductCatalogueClient productCatalogueClient;

	@Autowired
	ProductDataMapper productDataMapperService;
	@Autowired
	private ProductDataFilterService productDataFilterService;

	public List<ProductVO> getProducts() {
		try {

			RestResponse<ProductCatalogue> restResponse = productCatalogueClient.getProducts();
			return productDataMapperService.process(restResponse.getResponse().getProducts());

		} catch (NoDataFoundException e) {

		} catch (ClientCommunicationException e) {

		}
		//bad idea
		return null;
	}

	public List<ProductVO> getProducedsWithWithFilter(ProductDataFilter filter) {
		try {

			RestResponse<ProductCatalogue> restResponse = productCatalogueClient.getProducts();
			productDataMapperService.process(restResponse.getResponse().getProducts());
			return productDataFilterService.getProcductAfterFilter(filter);

		} catch (NoDataFoundException e) {
			
		} catch (ClientCommunicationException e) {
			
		} catch (NoAppropraiteDataFilterProvidedException e) {
			
		}
		//bad idea
		return null;
	}

}
