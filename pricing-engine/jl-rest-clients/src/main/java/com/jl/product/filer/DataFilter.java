package com.jl.product.filer;

public abstract class DataFilter<T> {
	
	@SuppressWarnings("hiding")
	public abstract <T> Object filter(); 

}
