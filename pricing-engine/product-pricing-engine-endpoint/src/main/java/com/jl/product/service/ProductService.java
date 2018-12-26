package com.jl.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jl.product.clients.rest.ProductCatalogueClient;
import com.jl.product.exception.ClientCommunicationException;
import com.jl.product.exception.NoAppropraiteDataFilterProvidedException;
import com.jl.product.exception.NoDataFoundException;
import com.jl.product.filer.ProductDataFilter;
import com.jl.product.filer.ProductDataFilter.PriceLableType;
import com.jl.product.filer.ProductDataFilter.ProductSortBy;
import com.jl.product.filer.ProductDataFilterService;
import com.jl.product.mapper.ProductDataMapper;
import com.jl.product.response.RestResponse;
import com.jl.product.vo.ProductVO;
import com.jl.product.vo.json.ProductCatalogue;

@Service
public class ProductService implements IProductService {

	@Autowired
	private ProductCatalogueClient productCatalogueClient;

	@Autowired
	ProductDataMapper productDataMapperService;
	@Autowired
	private ProductDataFilterService productDataFilterService;

	public List<ProductVO> getProducts() {
		try {

			RestResponse<ProductCatalogue> restResponse = productCatalogueClient.getProducts();
			return productDataMapperService.process(restResponse.getResponse().getProducts());

		} catch (NoDataFoundException e) {
			//business exception is needed here 
			e.printStackTrace();
		} catch (ClientCommunicationException e) {
			//business exception is needed here 
			e.printStackTrace();
		}
		return null;
	}

	public List<ProductVO> getProducedsWithWithFilter() {
		try {

			RestResponse<ProductCatalogue> restResponse = productCatalogueClient.getProducts();
			List<ProductVO> productPVOs = productDataMapperService.process(restResponse.getResponse().getProducts());
			// now populate this filter from the ui perspective and massage the data here
			ProductDataFilter filter = new ProductDataFilter(productPVOs, PriceLableType.SHOW_WAS_THEN_NOW,ProductSortBy.PRODUCT_PRICE_REDUCTION_DESC);
			return productDataFilterService.getProcductAfterFilter(filter);

		} catch (NoDataFoundException e) {
			//business exception is needed here 
			e.printStackTrace();
		} catch (ClientCommunicationException e) {
			
			e.printStackTrace();
		} catch (NoAppropraiteDataFilterProvidedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
