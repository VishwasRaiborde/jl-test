package com.jl.product.sort;

import java.util.Comparator;

import com.jl.product.vo.PriceVO;

public class PriceComparator implements Comparator<PriceVO> {

	

	public int compare(PriceVO o1, PriceVO o2) {
		// TODO Auto-generated method stub
		return (int) (o1.getReducedPrice() - o2.getReducedPrice());
	}

}
