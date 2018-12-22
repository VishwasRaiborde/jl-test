package com.jl.rest.product.mapper;

import com.jl.product.catalogue.presentation.vo.NowPricePVO;

public class BaseMapper {

	
	public String processComplexTypeAttributes(String t) {
		return (String) t;
	}

	public Double processComplexTypeAttributes(Double t) {
		return (Double) t;
	}
	
	public Integer processComplexTypeAttributes(Integer t) {
		return (Integer) t;
	}

	public NowPricePVO processComplexTypeAttributes(NowPricePVO t) {
		return (NowPricePVO) t;
	}

	public Object processComplexTypeAttributes(Object t) {
		if (t instanceof String) {
			return processComplexTypeAttributes((String) t);
		} else if (t instanceof Double) {
			return processComplexTypeAttributes((Double) t);
		} else if (t instanceof Integer) {
			return processComplexTypeAttributes((NowPricePVO) t);
		} else if (t instanceof NowPricePVO) {
			return processComplexTypeAttributes((NowPricePVO) t);
		}
		return t;
	}

}
