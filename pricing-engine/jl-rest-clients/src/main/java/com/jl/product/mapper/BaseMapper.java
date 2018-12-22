package com.jl.product.mapper;

import com.jl.product.vo.NowPriceVO;

public class BaseMapper {

	
	public String processComplexTypeAttributes(String t) {
		return  t;
	}

	public Double processComplexTypeAttributes(Double t) {
		return t;
	}
	
	public Integer processComplexTypeAttributes(Integer t) {
		return t;
	}

	public NowPriceVO processComplexTypeAttributes(NowPriceVO t) {
		return t;
	}

	public Object processComplexTypeAttributes(Object t) {
		if (t instanceof String) {
			return processComplexTypeAttributes((String) t);
		} else if (t instanceof Double) {
			return processComplexTypeAttributes((Double) t);
		} else if (t instanceof Integer) {
			return processComplexTypeAttributes((NowPriceVO) t);
		} else if (t instanceof NowPriceVO) {
			return processComplexTypeAttributes((NowPriceVO) t);
		}
		return t;
	}

}
