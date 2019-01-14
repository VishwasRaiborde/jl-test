package com.jl.product.service;

import java.util.List;

import com.jl.product.exception.ClientCommunicationException;
import com.jl.product.exception.NoAppropraiteDataFilterProvidedException;
import com.jl.product.exception.NoDataFoundException;
import com.jl.product.filter.ProductDataFilter;
import com.jl.product.vo.ProductVO;

public interface IProductService {

	public List<ProductVO> getProducts() throws NoDataFoundException, ClientCommunicationException;
	public List<ProductVO> getFilteredProducts(ProductDataFilter filter) throws NoAppropraiteDataFilterProvidedException;
}
