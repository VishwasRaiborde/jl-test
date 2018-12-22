package com.jl.product.catalogue.presentation.vo;

import java.io.Serializable;

public class PricePVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Double was;

	private Double then1;

	private Double then2;

	private Object now;

	private String uom;

	private String currency;
	
	private Double reducedPrice;

	public Double getReducedPrice() {
		return reducedPrice;
	}

	public void setReducedPrice(Double reducedPrice) {
		this.reducedPrice = reducedPrice;
	}

	public Double getWas() {
		return was;
	}

	public void setWas(Double was) {
		//TODO hmmm revisit, do i really need this now ,since data mappers are introduced ?
		if(was == null) {
			this.was = 0.00;
		}
		this.was = was;
	}

	public Double getThen1() {
		return then1;
	}

	public void setThen1(Double then1) {
		if(then1 == null) {
			this.then1 = 0.00;
		}
		this.then1 = then1;
	}

	public Double getThen2() {
		return then2;
	}

	public void setThen2(Double then2) {
		if(then2 == null) {
			this.then2 = 0.00;
		}
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + ((now == null) ? 0 : now.hashCode());
		result = prime * result + ((then1 == null) ? 0 : then1.hashCode());
		result = prime * result + ((then2 == null) ? 0 : then2.hashCode());
		result = prime * result + ((uom == null) ? 0 : uom.hashCode());
		result = prime * result + ((was == null) ? 0 : was.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PricePVO other = (PricePVO) obj;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (now == null) {
			if (other.now != null)
				return false;
		} else if (!now.equals(other.now))
			return false;
		if (then1 == null) {
			if (other.then1 != null)
				return false;
		} else if (!then1.equals(other.then1))
			return false;
		if (then2 == null) {
			if (other.then2 != null)
				return false;
		} else if (!then2.equals(other.then2))
			return false;
		if (uom == null) {
			if (other.uom != null)
				return false;
		} else if (!uom.equals(other.uom))
			return false;
		if (was == null) {
			if (other.was != null)
				return false;
		} else if (!was.equals(other.was))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PricePVO [was=" + was + ", then1=" + then1 + ", then2=" + then2 + ", now=" + now + ", uom=" + uom
				+ ", currency=" + currency + "]";
	}

}
