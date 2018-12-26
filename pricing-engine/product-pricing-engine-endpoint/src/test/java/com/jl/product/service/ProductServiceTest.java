package com.jl.product.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jl.configs.RestClientApp;
import com.jl.product.exception.NoAppropraiteDataFilterProvidedException;
import com.jl.product.filer.ProductDataFilter;
import com.jl.product.filer.ProductDataFilter.PriceLableType;
import com.jl.product.filer.ProductDataFilter.ProductSortBy;
import com.jl.product.vo.ProductVO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestClientApp.class)
public class ProductServiceTest {

	@Autowired
	private ProductService productService;

	@Test
	public void testGetProducts() {
		List<ProductVO> productPVOs = productService.getProducts();
	}

	@Test(expected = NoAppropraiteDataFilterProvidedException.class)
	public void testGetProducedsWithWithNullFilter() {
		
		List<ProductVO> decoreatedProductVOs = productService.getProducedsWithWithFilter(null);
		for (ProductVO productVO : decoreatedProductVOs) {
			System.out.println(productVO.toString());
		}
	}

	@Test
	public void testGetProducedsWithWithFilter() {
		List<ProductVO> productPVOs = productService.getProducts();
		ProductDataFilter filter = new ProductDataFilter(productPVOs, PriceLableType.SHOW_WAS_THEN_NOW,	ProductSortBy.PRODUCT_PRICE_REDUCTION_DESC);
		List<ProductVO> decoreatedProductVOs = productService.getProducedsWithWithFilter(filter);
		for (ProductVO productVO : decoreatedProductVOs) {
			System.out.println(productVO.toString());
		}
	}

}
