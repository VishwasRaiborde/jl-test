package com.jl.product.clients.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.jl.configs.EnvironmetProperties;
import com.jl.product.exception.ClientCommunicationException;
import com.jl.product.exception.NoDataFoundException;
import com.jl.product.response.ResponseStatus.ClientResponseStatus;
import com.jl.product.response.RestResponse;
import com.jl.product.vo.json.ProductCatalogue;

@Service
public class ProductCatalogueClient {
	// TODO code clean up 
	@Autowired
	RestTemplate restTemplate;
	private static final Logger log = LoggerFactory.getLogger(ProductCatalogueClient.class);

	public RestResponse<ProductCatalogue> getProducts() throws NoDataFoundException, ClientCommunicationException {

		ProductCatalogue productCatalogueAsResponse;
		RestResponse<ProductCatalogue> restResponse = new RestResponse<ProductCatalogue>();
		restResponse.setResponse(null);
		restResponse.setAsSuccessfull(Boolean.FALSE);
		restResponse.setResponseCode(ClientResponseStatus.RESQUEST_PREPARED_AND_UNFULFILLED);

		try {
			productCatalogueAsResponse = restTemplate.getForObject(EnvironmetProperties.getProperty(EnvironmetProperties.REST_URL_PRODUCTS_CATALOGUE),	ProductCatalogue.class);
			if (productCatalogueAsResponse != null) {
				if (log.isDebugEnabled()) {
					log.debug(productCatalogueAsResponse.toString());
				}
				restResponse.setResponse(productCatalogueAsResponse);
				restResponse.setAsSuccessfull(Boolean.TRUE);
				restResponse.setResponseCode(ClientResponseStatus.SUCESSFULL);
				return restResponse;
			} else {
				if (log.isDebugEnabled()) {
					log.debug("No Data Received from Provided!");
				}
				restResponse.setResponse(null);
				restResponse.setAsSuccessfull(Boolean.FALSE);
				restResponse.setResponseCode(ClientResponseStatus.SUCESSFULL);
				throw new NoDataFoundException();
			}

		} catch (HttpClientErrorException e) {

			if (log.isDebugEnabled()) {
				log.debug("No Data Received from Provided, Potential Authorization Error Rest Url issue");
			}

			restResponse.setResponse(null);
			restResponse.setAsSuccessfull(Boolean.FALSE);
			restResponse.setResponseCode(ClientResponseStatus.COMMS_ERROS);
			throw new ClientCommunicationException();
		}

		
	}

}
