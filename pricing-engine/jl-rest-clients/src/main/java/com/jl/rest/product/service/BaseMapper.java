package com.jl.rest.product.service;

import com.jl.product.catalogue.presentation.vo.NowPricePVO;

public class BaseMapper {

	public String processComplexTypeAttributes(String t) {
		return (String) t;
	}

	public Double processComplexTypeAttributes(Double t) {
		return (Double) t;
	}
	
	public NowPricePVO processComplexTypeAttributes(NowPricePVO t) {
		return (NowPricePVO) t;
	}

	public Object processComplexTypeAttributes(Object t) {

		if (t instanceof String) {
			return processComplexTypeAttributes((String) t);
		}
		if (t instanceof Double) {
			return processComplexTypeAttributes((Double) t);
		}
		// add any specific Objects of add them for typecasting
		if (t instanceof NowPricePVO) {
			return processComplexTypeAttributes((NowPricePVO) t);
		}
		return (Object) t;
	}

}
