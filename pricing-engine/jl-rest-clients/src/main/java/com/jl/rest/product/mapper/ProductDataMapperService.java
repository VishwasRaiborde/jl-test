package com.jl.rest.product.mapper;

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
public class ProductDataMapperService extends BaseMapper {

	
/*	public List<ProductPVO> getFilteredProducts(List<Product> products) {
		List<ProductPVO> productPVOsList = new ArrayList<ProductPVO>();
		ProductPVO productPVO;
		PricePVO pricePVO;

		for (Product product : products) {
			Price price = product.getPrice();
			productPVO = new ProductPVO();
			pricePVO = new PricePVO();
			productPVO.setPrice(pricePVO);

			BeanUtils.copyProperties(product, productPVO);
			copyPriceAttributes(price, pricePVO);

			boolean hasPriceReduced = PriceComputor.calculatePriceDrop(productPVO.getPrice());
			if (hasPriceReduced) {
				productPVOsList.add(productPVO);
			}
		}

		return productPVOsList;
	}
*/

	public List<ProductPVO> copyFromJsonToVo(List<Product> products) {
		
		List<ProductPVO> productPVOsList = new ArrayList<ProductPVO>();
		ProductPVO targetProductPVO;
		PricePVO targetPricePVO;

		for (Product sourceProduct : products) {
			
			Price sourcePrice = sourceProduct.getPrice();
			targetProductPVO = new ProductPVO();
			targetPricePVO = new PricePVO();
			targetProductPVO.setPrice(targetPricePVO);
		   // only the bear minimum needed for presentation can be controller at mappers in this case only product and price are required
		    copyProductAttributes(sourceProduct, targetProductPVO);
			copyPriceAttributes(sourcePrice, targetPricePVO);
			
			productPVOsList.add(targetProductPVO);
		}

		return productPVOsList;
	}
	
	public void copyProductAttributes(Product sourceProduct, ProductPVO targetProductPVO) {
		BeanUtils.copyProperties(sourceProduct, targetProductPVO);
		BeanUtils.copyProperties(sourceProduct.getColorSwatches(), targetProductPVO);
	}
	
	public void copyPriceAttributes(Price sourcePrice, PricePVO targetPricePVO) {
		targetPricePVO.setCurrency(sourcePrice.getCurrency());
		targetPricePVO.setUom(sourcePrice.getUom());
		targetPricePVO.setWas(StringUtils.isNotBlank(sourcePrice.getWas()) ? Double.parseDouble(sourcePrice.getWas()) : new Double(0.0));
		targetPricePVO.setThen1(StringUtils.isNotBlank(sourcePrice.getThen1()) ? Double.parseDouble(sourcePrice.getThen1()) : new Double(0.0));
		targetPricePVO.setThen2(StringUtils.isNotBlank(sourcePrice.getThen2()) ? Double.parseDouble(sourcePrice.getThen2()) : new Double(0.0));
		targetPricePVO.setNow(processComplexTypeAttributes(sourcePrice.getNow()));
	}

}
