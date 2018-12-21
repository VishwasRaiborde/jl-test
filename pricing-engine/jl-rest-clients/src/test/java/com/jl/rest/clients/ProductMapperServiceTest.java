package com.jl.rest.clients;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jl.configs.RestClientApp;
import com.jl.product.catalogue.json.vo.Product;
import com.jl.product.catalogue.json.vo.ProductCatalogue;
import com.jl.product.catalogue.presentation.vo.ProductPVO;
import com.jl.product.response.RestResponse;
import com.jl.property.EnvironmetProperties;
import com.jl.rest.exception.ClientCommunicationException;
import com.jl.rest.exception.NoDataFoundException;
import com.jl.rest.product.service.ProductMapperService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestClientApp.class)
public class ProductMapperServiceTest {
	private final static String VALID_REST_URL_PRODUCTS_CATALOGUE = "https://jl-nonprod-syst.apigee.net/v1/categories/600001506/products?key=2ALHCAAs6ikGRBoy6eTHA58RaG097Fma";

	@Autowired
	private ProductCatalogueClient productCatalogueClient;

	@Autowired
	ProductMapperService productMapperService;

	@Test
	public void testProductProductLoadFail() throws NoDataFoundException, ClientCommunicationException {

		EnvironmetProperties.clearAllConfigs();
		EnvironmetProperties.addProperty(EnvironmetProperties.REST_URL_PRODUCTS_CATALOGUE,VALID_REST_URL_PRODUCTS_CATALOGUE);
		RestResponse<ProductCatalogue> restResponse = productCatalogueClient.getProducts();
		assertTrue(restResponse.isSuccessfull());

		List<ProductPVO> productPVOs = productMapperService.getFilteredProducts(restResponse.getResponse().getProducts());
		
		for (ProductPVO product : productPVOs) {
			System.out.println(product.toString());
		}
		
	}
	
	@Test
	public void testPriceReductionforNowPrice() throws NoDataFoundException, ClientCommunicationException {

		assertTrue(Boolean.FALSE);
		
	}

}
