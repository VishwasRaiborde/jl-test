package com.jl.rest.product.service;

public class ProductFilter {

	enum ProductFilterSortOrder {
		ASCENDING, DESCENDINMG
	}

	public Boolean withPriceReduction;
	public ProductFilterSortOrder productFilterSortOrder;

	public ProductFilter withPriceReduction(Boolean withPriceReduction) {
		this.withPriceReduction = withPriceReduction;
		return this;
	}

	public ProductFilter withPriceReductionSortOrder(ProductFilterSortOrder productFilterSortOrder) {
		this.productFilterSortOrder = productFilterSortOrder;
		return this;
	}

}
