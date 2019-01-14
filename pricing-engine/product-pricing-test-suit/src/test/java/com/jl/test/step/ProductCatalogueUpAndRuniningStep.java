package com.jl.test.step;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jl.product.exception.ClientCommunicationException;
import com.jl.product.exception.NoAppropraiteDataFilterProvidedException;
import com.jl.product.exception.NoDataFoundException;
import com.jl.product.filter.ProductDataFilter;
import com.jl.product.filter.ProductDataFilter.PriceLableType;
import com.jl.product.filter.ProductDataFilter.ProductSortBy;
import com.jl.product.mapper.ProductDataMapper;
import com.jl.product.response.RestResponse;
import com.jl.product.service.ProductCatalogueService;
import com.jl.product.service.ProductDataFilterService;
import com.jl.product.vo.ProductVO;
import com.jl.product.vo.json.Product;
import com.jl.product.vo.json.ProductCatalogue;

@Component
public class ProductCatalogueUpAndRuniningStep {

	

	@Autowired
	private ProductCatalogueService productCatalogueClient;
	
	@Autowired
	private ProductDataFilterService productDataFilterService;
	
	@Autowired
	ProductDataMapper productDataMapperService;
	

	@Given("a rest url for product catalog is given $url")
	public void givenARestUrlForProductCatalogIsGiven(@Named("url") String url) {
		DataStoreSteps.cachedMap.put("url", url);
	}

	@When("a connection request is made to product catalog rest url")
	public void whenAConnectionRequestIsMadeToProductCatalogRestUrl() {
		RestResponse<ProductCatalogue> productCatalogue;
		try {
			productCatalogue = productCatalogueClient.getProducts();
			DataStoreSteps.cachedMap.put(DataStoreSteps.PRODUCT_KEY, productCatalogue.getResponse().getProducts());
			
		} catch (NoDataFoundException | ClientCommunicationException e) {
		}
	}

	@Then("a json array of product should be provided and confirm  end point are up and running")
	public void thenAJsonArrayOfProductShouldBeProvidedAndConfirmEndPointAreUpAndRunning() {
		List<Product> products = (List<Product>) DataStoreSteps.cachedMap.get(DataStoreSteps.PRODUCT_KEY);
		assertTrue(products != null); 
	}
	
	@When("filter on catalog data is ShowWasNow and sort order is highest reducing first")
	public void whenFilterOnCatalogDataIsShowWasNowAndSortOrderIsHighestReducingFirst() throws NoAppropraiteDataFilterProvidedException {
		
		List<Product> products = (List<Product>) DataStoreSteps.cachedMap.get(DataStoreSteps.PRODUCT_KEY);
		List<ProductVO> productPVOs = productDataMapperService.process(products);
		ProductDataFilter filter = new ProductDataFilter(productPVOs, PriceLableType.SHOW_WAS_NOW,ProductSortBy.PRODUCT_PRICE_REDUCTION_DESC);
		List<ProductVO> productVOsWithShowNowFilter = productDataFilterService.applyProductfilter(filter);
		DataStoreSteps.cachedMap.put(DataStoreSteps.FILTERED_PRODUCT_WITH_LABEL_WAS_NOW_KEY, productVOsWithShowNowFilter);
	}

	@Then("an  array of product should be provided as per the given condition")
	public void thenAnArrayOfProductShouldBeProvidedAsPerTheGivenCondition() {
		List<ProductVO> filteredProductVOs = (List<ProductVO>) DataStoreSteps.cachedMap.get(DataStoreSteps.FILTERED_PRODUCT_WITH_LABEL_WAS_NOW_KEY);
		for (ProductVO productVO : filteredProductVOs) {
			System.out.println("Filtered Records - " + productVO.getNowPrice());
		}
	}
	
	
	@When("filter on catalog data is ShowWasThenNow and sort order is highest reducing first")
	public void whenFilterOnCatalogDataIsShowWasThenNowAndSortOrderIsHighestReducingFirst() throws NoAppropraiteDataFilterProvidedException {
		
		List<Product> products = (List<Product>) DataStoreSteps.cachedMap.get(DataStoreSteps.PRODUCT_KEY);
		List<ProductVO> productPVOs = productDataMapperService.process(products);
		ProductDataFilter filter = new ProductDataFilter(productPVOs, PriceLableType.SHOW_WAS_THEN_NOW,ProductSortBy.PRODUCT_PRICE_REDUCTION_DESC);
		List<ProductVO> productVOsWithShowNowFilter = productDataFilterService.applyProductfilter(filter);
		DataStoreSteps.cachedMap.put(DataStoreSteps.FILTERED_PRODUCT_WITH_LABEL_WAS_NOW_KEY, productVOsWithShowNowFilter);
	}
	
	@When("filter on catalog data is ShowPercDscount and sort order is highest reducing first")
	public void whenFilterOnCatalogDataIsShowPercDscountAndSortOrderIsHighestReducingFirst() throws NoAppropraiteDataFilterProvidedException {
		
		List<Product> products = (List<Product>) DataStoreSteps.cachedMap.get(DataStoreSteps.PRODUCT_KEY);
		List<ProductVO> productPVOs = productDataMapperService.process(products);
		ProductDataFilter filter = new ProductDataFilter(productPVOs, PriceLableType.SHOW_PER_DISCOUNT,ProductSortBy.PRODUCT_PRICE_REDUCTION_DESC);
		List<ProductVO> productVOsWithShowNowFilter = productDataFilterService.applyProductfilter(filter);
		DataStoreSteps.cachedMap.put(DataStoreSteps.FILTERED_PRODUCT_WITH_LABEL_WAS_NOW_KEY, productVOsWithShowNowFilter);
	}



}
