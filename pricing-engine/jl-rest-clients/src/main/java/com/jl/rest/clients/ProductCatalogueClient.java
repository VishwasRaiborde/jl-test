package com.jl.rest.clients;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.jl.product.catalogue.vo.ProductCatalogue;
import com.jl.product.response.ResponseStatus.ClientResponseStatus;
import com.jl.property.EnvironmetProperties;
import com.jl.product.response.RestResponse;
import com.jl.rest.exception.ClientCommunicationException;
import com.jl.rest.exception.NoDataFoundException;



@Service
public class ProductCatalogueClient {

	@Autowired
	RestTemplate restTemplate;
	private static final Logger log = LoggerFactory.getLogger(ProductCatalogueClient.class);
	//this should come from environment configs or some configuration management cache as subjective to change 
	//TODO , will move this to some property file
    //static final String URL_PRODUCTS = "https://jl-nonprod-syst.apigee.net/v1/categories/600001506/products?key=2ALHCAAs6ikGRBoy6eTHA58RaG097Fma1";



	public static RestResponse<ProductCatalogue> getProducts()
			throws NoDataFoundException, ClientCommunicationException {

		ProductCatalogue productCatalogueAsResponse;
		RestResponse<ProductCatalogue> restResponse = new RestResponse<ProductCatalogue>();
		restResponse.setResponse(null);
		restResponse.setIsSuccessfull(Boolean.FALSE);
		restResponse.setResponseCode(ClientResponseStatus.RESQUEST_PREPARED_AND_UNFULFILLED);

		RestTemplate restTemplate = new RestTemplate();
		try {
			productCatalogueAsResponse = restTemplate.getForObject(EnvironmetProperties.getProperty(EnvironmetProperties.REST_URL_PRODUCTS_CATALOGUE), ProductCatalogue.class);
			if (productCatalogueAsResponse != null) {

				if (log.isDebugEnabled()) {
					log.debug(productCatalogueAsResponse.toString());
				}
				restResponse.setResponse(productCatalogueAsResponse);
				restResponse.setIsSuccessfull(Boolean.TRUE);
				restResponse.setResponseCode(ClientResponseStatus.SUCESSFULL);
				return restResponse;
			} else if (ObjectUtils.isEmpty(productCatalogueAsResponse)) {
				throw new NoDataFoundException();
			}

		} catch (HttpClientErrorException e) {
			restResponse.setResponse(null);
			restResponse.setIsSuccessfull(Boolean.FALSE);
			restResponse.setResponseCode(ClientResponseStatus.COMMS_ERROS);

			// TODO revisit will decide after further tests if I should keep throwing exception or send a graceful response hence the above code
			throw new ClientCommunicationException();
		}
		return restResponse;
	}

}
