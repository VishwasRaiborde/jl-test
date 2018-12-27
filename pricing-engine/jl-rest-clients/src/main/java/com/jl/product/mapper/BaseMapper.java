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

	public NowPriceRangeVO processComplexType(Map<String, String> t) {
		// this is when the attributes are passed in as map i.e Dynamic Attribues these are growable in case new attributes are added make chanage here
		NowPriceRangeVO nowPrice = new NowPriceRangeVO();
		nowPrice.setFrom((Double.parseDouble(t.get("from"))));
		nowPrice.setTo(Double.parseDouble(t.get("to")));
		return nowPrice;
	}
	
	
	public abstract Object processComplexType(Object t);
	
	
	

	

}
