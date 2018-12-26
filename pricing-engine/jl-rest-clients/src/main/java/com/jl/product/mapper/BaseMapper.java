package com.jl.product.mapper;

import java.util.Map;

import com.jl.product.vo.NowPriceRangeVO;

public abstract class BaseMapper {

	
	public String processComplexType(String t) {
		return  t;
	}

	public Double processComplexType(Double t) {
		return t;
	}
	
	public Integer processComplexType(Integer t) {
		return t;
	}

	public NowPriceRangeVO processComplexType(Map t) {
		NowPriceRangeVO nowPrice = new NowPriceRangeVO();
		nowPrice.setFrom((Double.parseDouble(t.get("from").toString())));
		nowPrice.setTo(Double.parseDouble(t.get("to").toString()));
		return nowPrice;
	}
	
	
	public abstract Object processComplexType(Object t);
	
	
	

	

}
