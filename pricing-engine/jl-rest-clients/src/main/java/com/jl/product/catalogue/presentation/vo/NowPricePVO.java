package com.jl.product.catalogue.presentation.vo;

import java.io.Serializable;

public class NowPricePVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Double from;
	private Double to;

	public Double getFrom() {
		return from;
	}

	public void setFrom(Double from) {
		this.from = from;
	}

	public Double getTo() {
		return to;
	}

	public void setTo(Double to) {
		this.to = to;
	}

}
