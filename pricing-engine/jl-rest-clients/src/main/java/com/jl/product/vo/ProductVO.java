package com.jl.product.vo;

import java.io.Serializable;

public class ProductVO implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	/*
	 * productId <String> title <String> colorSwatches. Each element should contain:
	 * color<String> rgbColor<String> which is an RGB representation of the
	 * basicColor in a six digit hexadecimal format, e.g. “F0A1C2”. skuid<String>
	 * nowPrice<String> which is the price.now represented as a string, including
	 * the currency, e.g. “£1.75”. For values that are integer, if they are less £10
	 * return a decimal price, otherwise show an integer price, e.g. “£2.00” or
	 * “£10”. priceLabel<String>. An optional query parm called labelType can be set
	 * to any of: 1. ShowWasNow - in which case return a string saying “Was £x.xx,
	 * now £y.yyy”. 2. ShowWasThenNow - in which case return a string saying “Was
	 * £x.xx, then £y.yy, now £z.zzz”. If the original price.then2 is not empty use
	 * that for the “then” price otherwise use the then1 price. If the then1 price
	 * is also empty then don’t show the “then” price. 3. ShowPercDscount - in which
	 * case return “x% off - now £y.yy”. If the query parm is not set default to use
	 * ShowWasNow format. In all cases use the price formatting as described for
	 * nowPrice.
	 * 
	 * 
	 */

	private String productId;
	private String title;
	private String defaultSkuId;
	private String nowPrice;
	private String priceLabel; // ShowWasNow,ShowWasThenNow,ShowPercDscount
	
	private ColorSwatchVO colorSwatches;
	private String reducedPrice;
	private PriceVO price;
	

	public String getDefaultSkuId() {
		return defaultSkuId;
	}

	public void setDefaultSkuId(String defaultSkuId) {
		this.defaultSkuId = defaultSkuId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ColorSwatchVO getColorSwatches() {
		return colorSwatches;
	}

	public void setColorSwatches(ColorSwatchVO colorSwatches) {
		this.colorSwatches = colorSwatches;
	}

	public String getNowPrice() {
		return nowPrice;
	}

	public void setNowPrice(String nowPrice) {
		this.nowPrice = nowPrice;
	}

	public String getPriceLabel() {
		return priceLabel;
	}

	public void setPriceLabel(String priceLabel) {
		this.priceLabel = priceLabel;
	}

	public String getReducedPrice() {
		return reducedPrice;
	}

	public void setReducedPrice(String reducedPrice) {
		this.reducedPrice = reducedPrice;
	}

	public PriceVO getPrice() {
		return price;
	}

	public void setPrice(PriceVO price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
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
		ProductVO other = (ProductVO) obj;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductPVO [productId=" + productId + ", title=" + title + ", defaultSkuId=" + defaultSkuId
				+ ", nowPrice=" + nowPrice + ", priceLabel=" + priceLabel + ", colorSwatches=" + colorSwatches
				+ ", reducedPrice=" + reducedPrice + ", price=" + price + "]";
	}

	

}
