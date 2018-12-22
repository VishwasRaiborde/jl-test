package com.jl.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jl.product.exception.ClientCommunicationException;
import com.jl.product.exception.NoDataFoundException;
import com.jl.product.service.ProductCatalogueDataClientService;
import com.jl.product.vo.ProductVO;

@Service
public class ProductService implements IProductService{

	@Autowired
	ProductCatalogueDataClientService productCatalogueDataClientService ;
	
	public List<ProductVO> getProducedsWithPriceReduction() {
		try {
			return productCatalogueDataClientService.getProductsHavingPriceReductionCatalogue();
		} catch (NoDataFoundException e) {
			e.printStackTrace();
		} catch (ClientCommunicationException e) {
			e.printStackTrace();
		}
		return null;
	}

}
