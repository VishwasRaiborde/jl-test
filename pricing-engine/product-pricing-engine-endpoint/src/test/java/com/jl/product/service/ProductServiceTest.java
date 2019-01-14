package com.jl.product.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jl.configs.RestClientApp;
import com.jl.product.exception.ClientCommunicationException;
import com.jl.product.exception.NoAppropraiteDataFilterProvidedException;
import com.jl.product.exception.NoDataFoundException;
import com.jl.product.filter.ProductDataFilter;
import com.jl.product.filter.ProductDataFilter.PriceLableType;
import com.jl.product.filter.ProductDataFilter.ProductSortBy;
import com.jl.product.vo.ProductVO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestClientApp.class)
public class ProductServiceTest {

	@Autowired
	private ProductService productService;

	@Test
	public void testGetProducts() throws NoDataFoundException, ClientCommunicationException {
		List<ProductVO> productPVOs = productService.getProducts();
		assertNotNull(productPVOs);
	}

	@Test(expected = NoAppropraiteDataFilterProvidedException.class)
	public void testGetProducedsWithWithNullFilter()
			throws NoAppropraiteDataFilterProvidedException, NoDataFoundException, ClientCommunicationException {

		List<ProductVO> decoreatedProductVOs = productService.getFilteredProducts(null);
		/*
		 * for (ProductVO productVO : decoreatedProductVOs) {
		 * System.out.println(productVO.toString()); }
		 */
	}

	@Test
	public void testGetProducedsWithWithFilter()
			throws NoDataFoundException, ClientCommunicationException, NoAppropraiteDataFilterProvidedException {
		List<ProductVO> productPVOs = productService.getProducts();
		ProductDataFilter filter = new ProductDataFilter(productPVOs, PriceLableType.SHOW_WAS_THEN_NOW,
				ProductSortBy.PRODUCT_PRICE_REDUCTION_DESC);
		List<ProductVO> decoreatedProductVOs = productService.getFilteredProducts(filter);
		/*
		 * for (ProductVO productVO : decoreatedProductVOs) {
		 * System.out.println(productVO.toString()); }
		 */
		assertNotNull(decoreatedProductVOs); 
	}

}
