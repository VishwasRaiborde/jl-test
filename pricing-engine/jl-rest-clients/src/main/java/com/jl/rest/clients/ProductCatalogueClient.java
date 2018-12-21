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

	public RestResponse<ProductCatalogue> getProducts() throws NoDataFoundException, ClientCommunicationException {

		ProductCatalogue productCatalogueAsResponse;
		RestResponse<ProductCatalogue> restResponse = new RestResponse<ProductCatalogue>();
		restResponse.setResponse(null);
		restResponse.setAsSuccessfull(Boolean.FALSE);
		restResponse.setResponseCode(ClientResponseStatus.RESQUEST_PREPARED_AND_UNFULFILLED);

		RestTemplate restTemplate = new RestTemplate();
		try {
			productCatalogueAsResponse = restTemplate.getForObject(
					EnvironmetProperties.getProperty(EnvironmetProperties.REST_URL_PRODUCTS_CATALOGUE),
					ProductCatalogue.class);
			if (productCatalogueAsResponse != null) {
				if (log.isDebugEnabled()) {
					log.debug(productCatalogueAsResponse.toString());
				}
				restResponse.setResponse(productCatalogueAsResponse);
				restResponse.setAsSuccessfull(Boolean.TRUE);
				restResponse.setResponseCode(ClientResponseStatus.SUCESSFULL);
				return restResponse;
			} else if (ObjectUtils.isEmpty(productCatalogueAsResponse)) {
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
			// TODO revisit will decide after further tests if I should keep throwing
			// exception or send a graceful response hence the above code
			throw new ClientCommunicationException();
		}

		if (log.isDebugEnabled()) {
			log.debug("End of Rest Call");
		}

		return restResponse;
	}

}
