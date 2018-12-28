package com.jl.test.step;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jl.product.clients.rest.ProductCatalogueClient;
import com.jl.product.exception.ClientCommunicationException;
import com.jl.product.exception.NoAppropraiteDataFilterProvidedException;
import com.jl.product.exception.NoDataFoundException;
import com.jl.product.filer.ProductDataFilter;
import com.jl.product.response.RestResponse;
import com.jl.product.service.IProductService;
import com.jl.product.vo.ProductVO;
import com.jl.product.vo.json.Product;
import com.jl.product.vo.json.ProductCatalogue;

@Component
public class ProductCatalogueUpAndRuniningStep {

	

	@Autowired
	private ProductCatalogueClient productCatalogueClient;
	
	@Autowired
	IProductService productService;

	@Given("a rest url for product catalog is given $url")
	public void givenARestUrlForProductCatalogIsGiven(@Named("url") String url) {
		DataStore.cachedMap.put("url", url);
	}

	@When("a connection request is made to product catalog rest url")
	public void whenAConnectionRequestIsMadeToProductCatalogRestUrl() {
		RestResponse<ProductCatalogue> productCatalogue;
		try {
			productCatalogue = productCatalogueClient.getProducts();
			DataStore.cachedMap.put(DataStore.PRODUCT_KEY, productCatalogue.getResponse().getProducts());
			
		} catch (NoDataFoundException | ClientCommunicationException e) {
		}
	}

	@Then("a json array of product should be provided and confirm  end point are up and running")
	public void thenAJsonArrayOfProductShouldBeProvidedAndConfirmEndPointAreUpAndRunning() {
		List<Product> products = (List<Product>) DataStore.cachedMap.get(DataStore.PRODUCT_KEY);
		
	/*	for (Product productVO : products) {
			System.out.println(productVO.toString());
		}*/
		
		assertTrue(products != null); 
	}
	
	
	@When("filter on catalog data is ShowWasNow and sort order is highest reducing first")
	public void whenFilterOnCatalogDataIsShowWasNowAndSortOrderIsHighestReducingFirst() {
		List<ProductVO> productVOs = (List<ProductVO>) DataStore.cachedMap.get(DataStore.PRODUCT_KEY);
		ProductDataFilter filer = new ProductDataFilter(productVOs, ProductDataFilter.PriceLableType.SHOW_WAS_NOW,ProductDataFilter.ProductSortBy.PRODUCT_PRICE_REDUCTION_DESC);
		List<ProductVO> filteredProductVOs;
		try {
			filteredProductVOs = productService.getProducedsWithWithFilter(filer);
			DataStore.cachedMap.put(DataStore.FILTERED_PRODUCT_WITH_LABEL_WAS_NOW_KEY, filteredProductVOs);
		} catch (NoAppropraiteDataFilterProvidedException | NoDataFoundException | ClientCommunicationException e) {
			e.printStackTrace();
		}
	}

	@Then("an  array of product should be provided as per the given condition")
	public void thenAnArrayOfProductShouldBeProvidedAsPerTheGivenCondition() {
		List<ProductVO> filteredProductVOs = (List<ProductVO>) DataStore.cachedMap.get(DataStore.FILTERED_PRODUCT_WITH_LABEL_WAS_NOW_KEY);
		for (ProductVO productVO : filteredProductVOs) {
			System.out.println(productVO.getNowPrice());
		}
	}

}
