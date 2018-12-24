package com.jl.product.service;

import java.util.List;

import com.jl.product.vo.ProductVO;

public interface IProductService {

	public List<ProductVO> getProducts();
	public List<ProductVO> getProducedsWithWithFilter() ;

}
