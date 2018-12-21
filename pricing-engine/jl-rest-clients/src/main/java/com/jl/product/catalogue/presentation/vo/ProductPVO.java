package com.jl.product.catalogue.presentation.vo;

import java.io.Serializable;

public class ProductPVO implements Serializable {

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
	private ColorSwatchPVO colorSwatches;
	private String nowPrice;
	private String priceLabel; // ShowWasNow,ShowWasThenNow,ShowPercDscount
	private String reducedPrice;
	private PricePVO price;

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

	public ColorSwatchPVO getColorSwatches() {
		return colorSwatches;
	}

	public void setColorSwatches(ColorSwatchPVO colorSwatches) {
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

	public PricePVO getPrice() {
		return price;
	}

	public void setPrice(PricePVO price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductPVO [productId=" + productId + ", title=" + title + ", colorSwatches=" + colorSwatches
				+ ", nowPrice=" + nowPrice + ", priceLabel=" + priceLabel + ", reducedPrice=" + reducedPrice
				+ ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((colorSwatches == null) ? 0 : colorSwatches.hashCode());
		result = prime * result + ((nowPrice == null) ? 0 : nowPrice.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((priceLabel == null) ? 0 : priceLabel.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((reducedPrice == null) ? 0 : reducedPrice.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		ProductPVO other = (ProductPVO) obj;
		if (colorSwatches == null) {
			if (other.colorSwatches != null)
				return false;
		} else if (!colorSwatches.equals(other.colorSwatches))
			return false;
		if (nowPrice == null) {
			if (other.nowPrice != null)
				return false;
		} else if (!nowPrice.equals(other.nowPrice))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (priceLabel == null) {
			if (other.priceLabel != null)
				return false;
		} else if (!priceLabel.equals(other.priceLabel))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (reducedPrice == null) {
			if (other.reducedPrice != null)
				return false;
		} else if (!reducedPrice.equals(other.reducedPrice))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}


}
