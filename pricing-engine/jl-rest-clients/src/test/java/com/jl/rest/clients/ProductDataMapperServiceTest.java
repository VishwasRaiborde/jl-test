package com.jl.rest.clients;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jl.app.cache.AppCache;
import com.jl.configs.RestClientApp;
import com.jl.product.exception.ClientCommunicationException;
import com.jl.product.exception.NoDataFoundException;
import com.jl.product.mapper.ProductDataMapper;
import com.jl.product.response.RestResponse;
import com.jl.product.service.ProductCatalogueService;
import com.jl.product.vo.NowPriceRangeVO;
import com.jl.product.vo.ProductVO;
import com.jl.product.vo.json.Price;
import com.jl.product.vo.json.Product;
import com.jl.product.vo.json.ProductCatalogue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestClientApp.class)
public class ProductDataMapperServiceTest {
	private final static String VALID_REST_URL_PRODUCTS_CATALOGUE = "https://jl-nonprod-syst.apigee.net/v1/categories/600001506/products?key=2ALHCAAs6ikGRBoy6eTHA58RaG097Fma";

	@Autowired
	private ProductCatalogueService productCatalogueClient;

	@Autowired
	ProductDataMapper productDataMapperService;

	@Before
	public void before() {
		AppCache.clearEnvConfigs();
		AppCache.addEnvProperty(AppCache.REST_URL_PRODUCTS_CATALOGUE_KEY,VALID_REST_URL_PRODUCTS_CATALOGUE);
	}

	@Test
	public void testProductLoad() throws NoDataFoundException, ClientCommunicationException {
		RestResponse<ProductCatalogue> restResponse = productCatalogueClient.getProducts();
		assertTrue(restResponse.isSuccessfull());
		List<ProductVO> productPVOs = productDataMapperService.process(restResponse.getResponse().getProducts());
		for (ProductVO product : productPVOs) {
			System.out.println(product.toString());
		}
		assertNotNull(productPVOs);

	}

	@Test
	public void testProductPriceCopy() throws NoDataFoundException, ClientCommunicationException {

		List<Product> productPVOs = new ArrayList<Product>();

		Product productWithSimplePriceData = new Product();
		
		productWithSimplePriceData.setProductId("100000");
		productWithSimplePriceData.setTitle("TEST PRODUCT");
		productWithSimplePriceData.setDefaultSkuId("121212");
		
		Price price = new Price();
		price.setCurrency("GBP");
		price.setNow("99.00");
		productWithSimplePriceData.setPrice(price);

		Product productWithComplexPriceData = new Product();
		productWithComplexPriceData.setProductId("100000");
		productWithComplexPriceData.setTitle("TEST PRODUCT");
		productWithComplexPriceData.setDefaultSkuId("121212");
		
		Price price2 = new Price();
		price2.setCurrency("GBP");
			NowPriceRangeVO nowPricePVO = new NowPriceRangeVO();
			nowPricePVO.setFrom(59.00);
			nowPricePVO.setTo(68.00);
		price2.setNow(nowPricePVO);
		productWithComplexPriceData.setPrice(price2);

		productPVOs.add(productWithSimplePriceData);
		productPVOs.add(productWithComplexPriceData);

		List<ProductVO> products = productDataMapperService.process(productPVOs);
		assertNotNull(products);
		for (ProductVO product : products) {
			System.out.println("All Products" + product.toString());
			assertNotNull(product.getPrice().getNow());
		}
		
	}

	@Test
	public void testDataMapperProcess() throws NoDataFoundException, ClientCommunicationException {

		RestResponse<ProductCatalogue> restResponse = productCatalogueClient.getProducts();
		List<ProductVO> products = productDataMapperService.process(restResponse.getResponse().getProducts());

		for (ProductVO product : products) {
			System.out.println("Products " + product.toString());
		}
		
		assertNotNull(products);

	}

}
