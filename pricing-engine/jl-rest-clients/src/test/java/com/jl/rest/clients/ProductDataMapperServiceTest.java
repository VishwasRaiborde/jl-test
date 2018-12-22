package com.jl.rest.clients;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jl.configs.RestClientApp;
import com.jl.product.catalogue.json.vo.Price;
import com.jl.product.catalogue.json.vo.Product;
import com.jl.product.catalogue.json.vo.ProductCatalogue;
import com.jl.product.catalogue.presentation.vo.NowPricePVO;
import com.jl.product.catalogue.presentation.vo.ProductPVO;
import com.jl.product.response.RestResponse;
import com.jl.property.EnvironmetProperties;
import com.jl.rest.exception.ClientCommunicationException;
import com.jl.rest.exception.NoDataFoundException;
import com.jl.rest.product.service.DataMapperService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestClientApp.class)
public class ProductDataMapperServiceTest {
	private final static String VALID_REST_URL_PRODUCTS_CATALOGUE = "https://jl-nonprod-syst.apigee.net/v1/categories/600001506/products?key=2ALHCAAs6ikGRBoy6eTHA58RaG097Fma";

	@Autowired
	private ProductCatalogueClient productCatalogueClient;

	@Autowired
	DataMapperService dataMapperService;

	@Test
	public void testProductProductLoadFail() throws NoDataFoundException, ClientCommunicationException {

		EnvironmetProperties.clearAllConfigs();
		EnvironmetProperties.addProperty(EnvironmetProperties.REST_URL_PRODUCTS_CATALOGUE,VALID_REST_URL_PRODUCTS_CATALOGUE);
		RestResponse<ProductCatalogue> restResponse = productCatalogueClient.getProducts();
		assertTrue(restResponse.isSuccessfull());
		List<ProductPVO> productPVOs = dataMapperService.getFilteredProducts(restResponse.getResponse().getProducts());
		for (ProductPVO product : productPVOs) {
			System.out.println(product.toString());
		}

	}

	@Test
	public void testPriceReductionforNowPrice() throws NoDataFoundException, ClientCommunicationException {
		
		List<Product> productPVOs = new ArrayList<Product>();
		 
		Product productWithSimplePriceData  = new Product();
		Price price = new Price();
		price.setCurrency("GBP");
		price.setNow("99.00");
		productWithSimplePriceData.setPrice(price);

		Product productWithComplexPriceData  = new Product();
		Price price2 = new Price();
		price2.setCurrency("GBP");
		NowPricePVO nowPricePVO = new NowPricePVO();
		nowPricePVO.setFrom(59.00);
		nowPricePVO.setTo(68.00);
		price2.setNow(nowPricePVO);
		productWithComplexPriceData.setPrice(price2);
		
		productPVOs.add(productWithSimplePriceData);
		productPVOs.add(productWithComplexPriceData);
		
		List<ProductPVO> productsWithReducedPrice = dataMapperService.getFilteredProducts(productPVOs);
		for (ProductPVO product : productsWithReducedPrice) {
			System.out.println(product.toString());
		}

		assertEquals(productsWithReducedPrice.get(1).getNowPrice() ,nowPricePVO);

	}

}
