package com.jl.rest.clients;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jl.configs.RestClientApp;
import com.jl.rest.exception.ClientCommunicationException;
import com.jl.rest.exception.NoDataFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestClientApp.class)
public class ProductCatalogueClientTest {

	@Autowired
	private ProductCatalogueClient productCatalogueClient;

	@Test
	public void testProductProductLoadFail() throws NoDataFoundException, ClientCommunicationException {
		productCatalogueClient.getProducts();
	}
	
	@Test
	public void testProductProductSuccessfull() throws NoDataFoundException, ClientCommunicationException {
		assertTrue(Boolean.FALSE); 
	}
	
	@Test
	public void testProductProductLoadWithDynamicPropertyChange() throws NoDataFoundException, ClientCommunicationException {
		assertTrue(Boolean.FALSE); 
	}
	
	@Test
	public void testProductProductDecoratioAndSorting() throws NoDataFoundException, ClientCommunicationException {
		assertTrue(Boolean.FALSE); 
	}

}
