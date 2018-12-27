package com.jl.product.mapper;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.jl.product.vo.PriceVO;
import com.jl.product.vo.json.Price;

@Service
public class ProductPriceMapper extends BaseMapper {



	public PriceVO process(Price price) {
		return copyPriceAttributes(price);
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
