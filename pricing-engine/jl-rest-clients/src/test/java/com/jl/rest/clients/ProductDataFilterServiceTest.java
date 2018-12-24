package com.jl.rest.clients;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
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
import com.jl.product.filer.ProductDataFilter;
import com.jl.product.filer.ProductDataFilter.PriceLableType;
import com.jl.product.filer.ProductDataFilterService;
import com.jl.product.mapper.ProductDataMapper;
import com.jl.product.response.RestResponse;
import com.jl.product.vo.ProductVO;
import com.jl.product.vo.json.ProductCatalogue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestClientApp.class)
public class ProductDataFilterServiceTest {


	@Autowired
	private ProductCatalogueClient productCatalogueClient;

	@Autowired
	ProductDataMapper productDataMapperService;
	@Autowired
	private ProductDataFilterService productDataFilterService;
	

	private final static String VALID_REST_URL_PRODUCTS_CATALOGUE = "https://jl-nonprod-syst.apigee.net/v1/categories/600001506/products?key=2ALHCAAs6ikGRBoy6eTHA58RaG097Fma";

	@Before
	public void before() {
		EnvironmetProperties.clearAllConfigs();
		EnvironmetProperties.addProperty(EnvironmetProperties.REST_URL_PRODUCTS_CATALOGUE,
				VALID_REST_URL_PRODUCTS_CATALOGUE);
	}

	@Test
	public void testProductProductLoadFail() throws NoDataFoundException, ClientCommunicationException {
		
		RestResponse<ProductCatalogue> restResponse = productCatalogueClient.getProducts();
		assertTrue(restResponse.isSuccessfull());
		List<ProductVO> productPVOs = productDataMapperService.process(restResponse.getResponse().getProducts());
		
		ProductDataFilter filter = new ProductDataFilter(productPVOs,PriceLableType.ShowWasThenNow);
		List<ProductVO> vos = productDataFilterService.getProcductAfterFilter(filter);
		
		for(ProductVO productVO :vos) {
			System.out.println(productVO.toString());
		}
		
	}

}
