package com.jl.rest.clients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import com.jl.product.catalogue.vo.ProductCatalogue;
import com.jl.product.response.ResponseStatus.ClientResponseStatus;
import com.jl.product.response.RestResponse;
import com.jl.rest.exception.NoDataFoundException;

public class ProductCatalogueClient {

	@Autowired
	RestTemplate restTemplate;

	private static final Logger log = LoggerFactory.getLogger(ProductCatalogueClient.class);

	static final String URL_PRODUCTS = "https://jl-nonprod-syst.apigee.net/v1/categories/600001506/products?key=2ALHCAAs6ikGRBoy6eTHA58RaG097Fma";

	public static void main(String[] args) {

	}

	public RestResponse<ProductCatalogue> getProducts() throws NoDataFoundException {

		RestTemplate restTemplate = new RestTemplate();
		RestResponse<ProductCatalogue> response = new RestResponse<ProductCatalogue>();
		ProductCatalogue productCatalogueAsResponse = restTemplate.getForObject(URL_PRODUCTS, ProductCatalogue.class);

		if (productCatalogueAsResponse != null) {

			if (log.isDebugEnabled()) {
				log.debug(productCatalogueAsResponse.toString());
			}
			response.setResponse(productCatalogueAsResponse);
			response.setIsSuccessfull(Boolean.TRUE);
			response.setResponseCode(ClientResponseStatus.SUCESSFULL);
			return response;
		} else if (ObjectUtils.isEmpty(productCatalogueAsResponse)) {
			throw new NoDataFoundException();
		}
		return response;
	}

}
