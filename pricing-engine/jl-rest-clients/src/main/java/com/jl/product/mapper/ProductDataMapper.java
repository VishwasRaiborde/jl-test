package com.jl.product.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.jl.product.vo.ColorSwatchVO;
import com.jl.product.vo.NowPriceVO;
import com.jl.product.vo.PriceVO;
import com.jl.product.vo.ProductVO;
import com.jl.product.vo.json.ColorSwatch;
import com.jl.product.vo.json.Price;
import com.jl.product.vo.json.Product;

@Service
public class ProductDataMapper extends BaseMapper {

	public enum PriceLableType {
		ShowWasNow, ShowWasThenNow, ShowPercDscount
	}
	
	PriceLableType labelType ;

	public PriceLableType getLabelType() {
		return labelType;
	}

	public void setLabelType(PriceLableType labelType) {
		this.labelType = labelType;
	}

	
	
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
			copyColorSwatchAttributes(sourceProduct, targetProductPVO);
			copyPriceAttributes(sourcePrice, targetPricePVO);
			anySpecialPriceConditions(targetProductPVO);
			productPVOsList.add(targetProductPVO);
		}

		return productPVOsList;
	}

	public void copyProductAttributes(Product sourceProduct, ProductVO targetProductPVO) {
		BeanUtils.copyProperties(sourceProduct, targetProductPVO);
	}

	private void copyColorSwatchAttributes(Product sourceProduct, ProductVO targetProductPVO) {

		List<ColorSwatchVO> colorSwatches = new ArrayList<ColorSwatchVO>();
		ColorSwatchVO colorSwatchVO;
		for (ColorSwatch colorSwatch : sourceProduct.getColorSwatches()) {
			colorSwatchVO = new ColorSwatchVO();
			BeanUtils.copyProperties(colorSwatch, colorSwatchVO);
			colorSwatches.add(colorSwatchVO);
		}

		targetProductPVO.setColorSwatches(colorSwatches);
	}

	public void copyPriceAttributes(Price sourcePrice, PriceVO targetPricePVO) {
		targetPricePVO.setCurrency(sourcePrice.getCurrency());
		targetPricePVO.setUom(sourcePrice.getUom());
		targetPricePVO.setWas(StringUtils.isNotBlank(sourcePrice.getWas()) ? Double.parseDouble(sourcePrice.getWas()) : 0);
		targetPricePVO.setThen1(StringUtils.isNotBlank(sourcePrice.getThen1()) ? Double.parseDouble(sourcePrice.getThen1()) : 0);
		targetPricePVO.setThen2(StringUtils.isNotBlank(sourcePrice.getThen2()) ? Double.parseDouble(sourcePrice.getThen2()) : 0);
		targetPricePVO.setNow(processComplexType(sourcePrice.getNow()));
	}

	public void anySpecialPriceConditions(ProductVO product) {
		
		Double wasPrice = product.getPrice().getWas();
		Double then1Price = product.getPrice().getThen1();
		Double then2Price = product.getPrice().getThen2();
		Object nowPrice = product.getPrice().getNow();
		String priceLabel = product.getPriceLabel();

		switch (labelType) {
		case ShowWasNow: {

			StringBuilder showWasNow = new StringBuilder();
			showWasNow.append(" {");
			showWasNow.append("was=");
			showWasNow.append(wasPrice);
			showWasNow.append( priceLabel!= null ? priceLabel :"" );
			showWasNow.append(", ");
			showWasNow.append("now=");
			showWasNow.append(nowPrice);
			showWasNow.append( "}");
			
			product.setNowPrice(showWasNow.toString());
			
		}
		case ShowWasThenNow: {
			
			StringBuilder showWasThenNow = new StringBuilder();
			
			showWasThenNow.append("{");
			showWasThenNow.append("was=");
			showWasThenNow.append(wasPrice);
			showWasThenNow.append( priceLabel!= null ? priceLabel :"" );
			showWasThenNow.append(",");
			
			showWasThenNow.append("then1=");
			showWasThenNow.append(then1Price);
			showWasThenNow.append( priceLabel!= null ? priceLabel :"" );
			showWasThenNow.append(",");
			
			showWasThenNow.append("then2=");
			showWasThenNow.append(then2Price);
			showWasThenNow.append( priceLabel!= null ? priceLabel :"" );
			showWasThenNow.append(",");
			
			showWasThenNow.append("now=");
			showWasThenNow.append(nowPrice);
			showWasThenNow.append( priceLabel!= null ? priceLabel :"" );
			
			showWasThenNow.append("}");
			
			product.setNowPrice(showWasThenNow.toString());
		}
		case ShowPercDscount: {

		}
		}

	}

	public Object processComplexType(Object t) {

		if (t instanceof String) {
			return processComplexType((String) t);

		} else if (t instanceof Double) {
			return processComplexType((Double) t);

		} else if (t instanceof Integer) {
			return processComplexType((NowPriceVO) t);

		} else if (t instanceof NowPriceVO) {
			return processComplexType((NowPriceVO) t);

		}

		return t;
	}

}
