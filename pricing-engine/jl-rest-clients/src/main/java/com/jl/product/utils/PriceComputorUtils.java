package com.jl.product.utils;

import com.jl.product.vo.PriceVO;

public class PriceComputorUtils {
	
	private PriceComputorUtils(){
		
	}

	public static Double calculatePriceDrop(Double fromPrice, Double nowPrice) {
		Double reducedPrice = 0.00;
		if (fromPrice > nowPrice) {
			reducedPrice = fromPrice - nowPrice;
		}
		return nowPrice;

	}

	public static boolean calculatePriceDrop(PriceVO price) {
		
		
		Double reducedPrice = 0.00;
		
	
		if(price.getWas() == 0.0 && price.getThen2() == 0.0 && price.getThen1() ==0.0 && price.getNow() !=null) {
			reducedPrice = 0.0;
			return false;
		}
		if (price.getThen1() < price.getWas()) {
			reducedPrice = price.getWas() - price.getThen1();
		}
		if (price.getThen2() < price.getThen1()) {
			reducedPrice = price.getThen1() - price.getThen2();
		}

		
		price.setReducedPrice(reducedPrice);
		return true;
	}
}
