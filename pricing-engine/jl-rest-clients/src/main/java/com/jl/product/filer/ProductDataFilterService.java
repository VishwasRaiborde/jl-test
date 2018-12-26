package com.jl.product.filer;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jl.product.exception.NoAppropraiteDataFilterProvidedException;
import com.jl.product.vo.ProductVO;

@Service
public class ProductDataFilterService {

	@SuppressWarnings("unchecked")
	public List<ProductVO> getProcductAfterFilter(DataFilter<ProductVO> filter) throws NoAppropraiteDataFilterProvidedException{
		if(filter != null) {
			return (List<ProductVO>) filter.filter();
		}else {
			throw new NoAppropraiteDataFilterProvidedException();
		}
		
	}

}
