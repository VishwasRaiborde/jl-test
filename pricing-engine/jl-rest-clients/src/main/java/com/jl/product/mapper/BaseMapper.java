package com.jl.product.mapper;

import com.jl.product.vo.NowPriceVO;

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

	public NowPriceVO processComplexType(NowPriceVO t) {
		return t;
	}
	
	
	public abstract Object processComplexType(Object t);
	
	
	

	

}
