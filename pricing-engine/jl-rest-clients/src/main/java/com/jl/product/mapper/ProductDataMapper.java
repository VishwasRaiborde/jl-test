package com.jl.product.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.jl.product.vo.PriceVO;
import com.jl.product.vo.ProductVO;
import com.jl.product.vo.json.Price;
import com.jl.product.vo.json.Product;

@Service
public class ProductDataMapper extends BaseMapper {

	
	public List<ProductVO> copyFromJsonToVo(List<Product> products) {
		
		List<ProductVO> productPVOsList = new ArrayList<ProductVO>();
		ProductVO targetProductPVO;
		PriceVO targetPricePVO;

		for (Product sourceProduct : products) {
			Price sourcePrice = sourceProduct.getPrice();
			targetProductPVO = new ProductVO();
			targetPricePVO = new PriceVO();
			targetProductPVO.setPrice(targetPricePVO);
	
			copyProductAttributes(sourceProduct, targetProductPVO);
			copyPriceAttributes(sourcePrice, targetPricePVO);
			
			productPVOsList.add(targetProductPVO);
		}

		return productPVOsList;
	}
	
	public void copyProductAttributes(Product sourceProduct, ProductVO targetProductPVO) {
		BeanUtils.copyProperties(sourceProduct, targetProductPVO);
		BeanUtils.copyProperties(sourceProduct.getColorSwatches(), targetProductPVO);
	}
	
	public void copyPriceAttributes(Price sourcePrice, PriceVO targetPricePVO) {
		targetPricePVO.setCurrency(sourcePrice.getCurrency());
		targetPricePVO.setUom(sourcePrice.getUom());
		targetPricePVO.setWas(StringUtils.isNotBlank(sourcePrice.getWas()) ? Double.parseDouble(sourcePrice.getWas()) : 0);
		targetPricePVO.setThen1(StringUtils.isNotBlank(sourcePrice.getThen1()) ? Double.parseDouble(sourcePrice.getThen1()) : 0);
		targetPricePVO.setThen2(StringUtils.isNotBlank(sourcePrice.getThen2()) ? Double.parseDouble(sourcePrice.getThen2()) : 0);
		targetPricePVO.setNow(processComplexTypeAttributes(sourcePrice.getNow()));
	}

}
