package com.jl.product.vo;

import java.io.Serializable;

public class PriceVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Double was;

	private Double then1;

	private Double then2;

	transient  Object now;

	private String uom;

	private String currency;

	private Double reducedPrice;

	public Double getWas() {
		return was;
	}

	public void setWas(Double was) {

		this.was = was;
	}

	public Double getThen1() {
		return then1;
	}

	public void setThen1(Double then1) {

		this.then1 = then1;
	}

	public Double getThen2() {
		return then2;
	}

	public void setThen2(Double then2) {

		this.then2 = then2;
	}

	public Object getNow() {
		return now;
	}

	public void setNow(Object now) {
		this.now = now;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getReducedPrice() {
		return reducedPrice;
	}

	public void setReducedPrice(Double reducedPrice) {
		this.reducedPrice = reducedPrice;
	}

	@Override
	public String toString() {
		return "PricePVO [was=" + was + ", then1=" + then1 + ", then2=" + then2 + ", now=" + now + ", uom=" + uom
				+ ", currency=" + currency + "]";
	}

}
