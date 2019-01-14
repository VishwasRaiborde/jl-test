package com.jl.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jl.product.exception.NoAppropraiteDataFilterProvidedException;
import com.jl.product.filter.DataFilter;
import com.jl.product.vo.ProductVO;

@Service
public class ProductDataFilterService {

	@SuppressWarnings("unchecked")
	public List<ProductVO> applyProductfilter(DataFilter<ProductVO> filter) throws NoAppropraiteDataFilterProvidedException{
		if(filter != null) {
			return (List<ProductVO>) filter.filter();
		}else {
			throw new NoAppropraiteDataFilterProvidedException();
		}
		
	}

}
