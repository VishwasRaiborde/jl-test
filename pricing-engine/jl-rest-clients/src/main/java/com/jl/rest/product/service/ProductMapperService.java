package com.jl.rest.product.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.jl.product.catalogue.json.vo.Price;
import com.jl.product.catalogue.json.vo.Product;
import com.jl.product.catalogue.presentation.vo.PricePVO;
import com.jl.product.catalogue.presentation.vo.ProductPVO;

@Service
public class ProductMapperService {

	public List<ProductPVO> getFilteredProducts(List<Product> products) {
		List<ProductPVO> productPVOsList = new ArrayList<ProductPVO>();
		ProductPVO productPVO;
		PricePVO pricePVO;

		for (Product product : products) {
			Price price = product.getPrice();

			productPVO = new ProductPVO();
			pricePVO = new PricePVO();
			productPVO.setPrice(pricePVO);

			BeanUtils.copyProperties(product, productPVO);
			// BeanUtils.copyProperties(product.getPrice(), productPVO.getPrice());
			copyPrice(price, pricePVO);

			// now this is a tricky algo goin out here . i got a loop and a computation in
			// it
			boolean hasPriceReduced =PriceComputor.calculatePriceDrop(productPVO.getPrice());
			if(hasPriceReduced) {
				productPVOsList.add(productPVO);
			}
			
		}

		return productPVOsList;
	}

	static void copyPrice(Price price, PricePVO pricePVO) {
		System.out.println(price.toString());
		
		pricePVO.setCurrency(price.getCurrency());
		pricePVO.setUom(price.getUom());
		
		pricePVO.setWas( StringUtils.isNotBlank(price.getWas()) ? Double.parseDouble(price.getWas()):new Double(0.0));
		pricePVO.setThen1( StringUtils.isNotBlank(price.getThen1())?Double.parseDouble(price.getThen1()):new Double(0.0));
		pricePVO.setThen2( StringUtils.isNotBlank(price.getThen2())?Double.parseDouble(price.getThen2()):new Double(0.0));
		pricePVO.setNow( StringUtils.isNotBlank(price.getNow() + "")?Double.parseDouble(price.getNow().toString()):new Double(0.0));

	}
}