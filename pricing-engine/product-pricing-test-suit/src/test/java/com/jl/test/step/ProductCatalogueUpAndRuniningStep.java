package com.jl.test.step;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jl.configs.EnvironmetProperties;
import com.jl.product.clients.rest.ProductCatalogueClient;
import com.jl.product.exception.ClientCommunicationException;
import com.jl.product.exception.NoDataFoundException;
import com.jl.product.response.RestResponse;
import com.jl.product.vo.json.ProductCatalogue;

@Component
public class ProductCatalogueUpAndRuniningStep {

	static Map cachedMap = new HashMap<>();

	@Autowired
	private ProductCatalogueClient productCatalogueClient;

	@Given("a rest url for product catalog is given $url")
	public void givenARestUrlForProductCatalogIsGivenHttpsjlnonprodsystapigeenetv1categories600001506productskey2ALHCAAs6ikGRBoy6eTHA58RaG097Fma(
			@Named("url") String url) {
		cachedMap.put("url", url);
	}

	@When("a connection request is made to product catalog rest url")
	public void whenAConnectionRequestIsMadeToProductCatalogRestUrl() {
		EnvironmetProperties.clearAllConfigs();
		EnvironmetProperties.addProperty(EnvironmetProperties.REST_URL_PRODUCTS_CATALOGUE,
				cachedMap.get("url").toString());
		RestResponse<ProductCatalogue> productCatalogue;
		try {
			productCatalogue = productCatalogueClient.getProducts();
			cachedMap.put("productCatalogue", productCatalogue);
		} catch (NoDataFoundException | ClientCommunicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("a json array of product should be provided and confirm  end point are up and running")
	public void thenAJsonArrayOfProductShouldBeProvidedAndConfirmEndPointAreUpAndRunning() {
		RestResponse<ProductCatalogue> productCatalogue = (RestResponse<ProductCatalogue>) cachedMap
				.get("productCatalogue");
		assertTrue(productCatalogue != null);
	}

}
