package com.jl.product.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductVO implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	/*
	 * productId <String> title <String> colorSwatches. Each element should contain:
	 * color<String> rgbColor<String> which is an RGB representation of the
	 * basicColor in a six digit hexadecimal format, e.g. â€œF0A1C2â€�. skuid<String>
	 * nowPrice<String> which is the price.now represented as a string, including
	 * the currency, e.g. â€œÂ£1.75â€�. For values that are integer, if they are less Â£10
	 * return a decimal price, otherwise show an integer price, e.g. â€œÂ£2.00â€� or
	 * â€œÂ£10â€�. priceLabel<String>. An optional query parm called labelType can be set
	 * to any of: 1. ShowWasNow - in which case return a string saying â€œWas Â£x.xx,
	 * now Â£y.yyyâ€�. 2. ShowWasThenNow - in which case return a string saying â€œWas
	 * Â£x.xx, then Â£y.yy, now Â£z.zzzâ€�. If the original price.then2 is not empty use
	 * that for the â€œthenâ€� price otherwise use the then1 price. If the then1 price
	 * is also empty then donâ€™t show the â€œthenâ€� price. 3. ShowPercDscount - in which
	 * case return â€œx% off - now Â£y.yyâ€�. If the query parm is not set default to use
	 * ShowWasNow format. In all cases use the price formatting as described for
	 * nowPrice.
	 * 
	 * 
	 */

	private Integer productId;
	private String title;
	private String defaultSkuId;
	private Double reducedPrice;
	private String nowPrice;
	
	private String priceLabel; 
	private List<ColorSwatchVO> colorSwatches = new ArrayList<ColorSwatchVO>();
	
	private PriceVO price;
	

	public String getDefaultSkuId() {
		return defaultSkuId;
	}

	public void setDefaultSkuId(String defaultSkuId) {
		this.defaultSkuId = defaultSkuId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<ColorSwatchVO> getColorSwatches() {
		return colorSwatches;
	}

	public void setColorSwatches(List<ColorSwatchVO> colorSwatches) {
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

	public Double getReducedPrice() {
		return reducedPrice;
	}

	public void setReducedPrice(Double reducedPrice2) {
		this.reducedPrice = reducedPrice2;
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
		result = prime * result + ((reducedPrice == null) ? 0 : reducedPrice.hashCode());
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
		if (reducedPrice == null) {
			if (other.reducedPrice != null)
				return false;
		} else if (!reducedPrice.equals(other.reducedPrice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductVO [productId=" + productId + ", title=" + title + ", defaultSkuId=" + defaultSkuId
				+ ", reducedPrice=" + reducedPrice + ", nowPrice=" + nowPrice + ", priceLabel=" + priceLabel
				+ ", colorSwatches=" + colorSwatches + ", price=" + price + "]";
	}


	

}
