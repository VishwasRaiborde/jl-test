package com.jl.product.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.jl.product.vo.ColorSwatchVO;
import com.jl.product.vo.PriceVO;
import com.jl.product.vo.ProductVO;
import com.jl.product.vo.json.ColorSwatch;
import com.jl.product.vo.json.Price;
import com.jl.product.vo.json.Product;

@Service
public class ProductDataMapper extends BaseMapper {

	public List<ProductVO> process(List<Product> products) {

		List<ProductVO> productPVOsList = new ArrayList<ProductVO>();
		for (Product sourceProduct : products) {

			ProductVO targetProductVO = copyProductAttributes(sourceProduct);
			targetProductVO.setPrice(copyPriceAttributes(sourceProduct.getPrice()));
			targetProductVO.setColorSwatches(copyColorSwatchAttributes(sourceProduct.getColorSwatches()));
			productPVOsList.add(targetProductVO);
		}

		return productPVOsList;
	}

	public ProductVO copyProductAttributes(Product sourceProduct) {
		ProductVO targetProductPVO = new ProductVO();
		targetProductPVO.setProductId(Integer.parseInt(sourceProduct.getProductId()));
		targetProductPVO.setTitle(sourceProduct.getTitle());
		targetProductPVO.setDefaultSkuId(sourceProduct.getDefaultSkuId());
		return targetProductPVO;
	}

	public PriceVO copyPriceAttributes(Price sourcePrice) {
		PriceVO targetPricePVO = new PriceVO();
		targetPricePVO.setCurrency(sourcePrice.getCurrency());
		targetPricePVO.setUom(sourcePrice.getUom());
		targetPricePVO.setWas(StringUtils.isNotBlank(sourcePrice.getWas()) ? Double.parseDouble(sourcePrice.getWas()) : 0);
		targetPricePVO.setThen1(StringUtils.isNotBlank(sourcePrice.getThen1()) ? Double.parseDouble(sourcePrice.getThen1()) : 0);
		targetPricePVO.setThen2(StringUtils.isNotBlank(sourcePrice.getThen2()) ? Double.parseDouble(sourcePrice.getThen2()) : 0);
		targetPricePVO.setNow(processComplexType(sourcePrice.getNow()));
		return targetPricePVO;
	}

	private List<ColorSwatchVO> copyColorSwatchAttributes(List<ColorSwatch> colorSwatches) {
		List<ColorSwatchVO> colorSwatchVOs = new ArrayList<ColorSwatchVO>();
		for (ColorSwatch colorSwatch : colorSwatches) {
			ColorSwatchVO colorSwatchVO = new ColorSwatchVO();
			BeanUtils.copyProperties(colorSwatch, colorSwatchVO);
			colorSwatchVOs.add(colorSwatchVO);
		}
		return colorSwatchVOs;
	}

	public Object processComplexType(Object t) {
		if (t instanceof String) {
			return processComplexType((String) t);
		} else if (t instanceof Double) {
			return processComplexType((Double) t);
		} else if (t instanceof Integer) {
			return processComplexType((Integer) t);
		} else if (t instanceof Map) {
			return processComplexType((Map<String, String>)t);
		}
		return t;
	}

}
