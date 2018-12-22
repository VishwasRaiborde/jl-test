package com.jl.rest.clients;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jl.configs.EnvironmetProperties;
import com.jl.configs.RestClientApp;
import com.jl.product.clients.rest.ProductCatalogueClient;
import com.jl.product.exception.ClientCommunicationException;
import com.jl.product.exception.NoDataFoundException;
import com.jl.product.response.RestResponse;
import com.jl.product.vo.json.Product;
import com.jl.product.vo.json.ProductCatalogue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestClientApp.class)
public class ProductCatalogueClientTest {

	@Autowired
	private ProductCatalogueClient productCatalogueClient;
	
	private final static String VALID_REST_URL_PRODUCTS_CATALOGUE ="https://jl-nonprod-syst.apigee.net/v1/categories/600001506/products?key=2ALHCAAs6ikGRBoy6eTHA58RaG097Fma";
	private final static String INVALID_REST_URL_PRODUCTS_CATALOGUE ="https://jl-nonprod-syst.apigee.net/v1/categories/600001506/products?key=2ALHCAAs6ikGRBoy6eTHA58RaG097Fma_INVALIDATED";

	@Test
	public void testProductProductLoadFail() throws NoDataFoundException, ClientCommunicationException {

		EnvironmetProperties.clearAllConfigs();
		EnvironmetProperties.addProperty(EnvironmetProperties.REST_URL_PRODUCTS_CATALOGUE, VALID_REST_URL_PRODUCTS_CATALOGUE);
		RestResponse<ProductCatalogue> restResponse = productCatalogueClient.getProducts();
		assertTrue(restResponse.isSuccessfull());
	}
	
	@Test(expected=ClientCommunicationException.class)
	public void testProductProductSuccessfull() throws NoDataFoundException, ClientCommunicationException {
		EnvironmetProperties.clearAllConfigs();
		EnvironmetProperties.addProperty(EnvironmetProperties.REST_URL_PRODUCTS_CATALOGUE, INVALID_REST_URL_PRODUCTS_CATALOGUE);
		RestResponse<ProductCatalogue> restResponse = productCatalogueClient.getProducts();
		assertTrue(restResponse.isSuccessfull());
	}
	
	@Test
	public void testProductExtractedSucessfully() throws NoDataFoundException, ClientCommunicationException {
		EnvironmetProperties.clearAllConfigs();
		EnvironmetProperties.addProperty(EnvironmetProperties.REST_URL_PRODUCTS_CATALOGUE, VALID_REST_URL_PRODUCTS_CATALOGUE);
		RestResponse<ProductCatalogue> restResponse = productCatalogueClient.getProducts();
		
		assertTrue(restResponse.isSuccessfull());
		
		List<Product>  products = restResponse.getResponse().getProducts();
		for(Product product:products) {
			System.out.println(product.toString());
		}
		assertNotNull(products);
	}
	
	@Test
	@Ignore
	public void testProductProductDecoratioAndSorting() throws NoDataFoundException, ClientCommunicationException {
		assertTrue(Boolean.FALSE); 
	}

}
