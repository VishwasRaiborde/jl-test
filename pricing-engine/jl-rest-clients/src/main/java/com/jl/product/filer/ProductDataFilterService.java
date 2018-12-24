package com.jl.product.filer;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jl.product.vo.ProductVO;

@Service
public class ProductDataFilterService {

	@SuppressWarnings("unchecked")
	public List<ProductVO> getProcductAfterFilter(DataFilter<ProductVO> filter) {
		return (List<ProductVO>) filter.filter();
	}

}
