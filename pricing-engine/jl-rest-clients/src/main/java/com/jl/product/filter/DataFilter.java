package com.jl.product.filter;

public abstract class DataFilter<T> {
	
	@SuppressWarnings("hiding")
	public abstract <T> Object filter(); 

}
