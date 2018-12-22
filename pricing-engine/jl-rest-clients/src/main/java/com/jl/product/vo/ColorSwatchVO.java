
package com.jl.product.vo;

import java.io.Serializable;

public class ColorSwatchVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String color;

	private String basicColor;

	private String colorSwatchUrl;

	private String imageUrl;

	private Boolean isAvailable;

	private String skuId;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBasicColor() {
		return basicColor;
	}

	public void setBasicColor(String basicColor) {
		this.basicColor = basicColor;
	}

	public String getColorSwatchUrl() {
		return colorSwatchUrl;
	}

	public void setColorSwatchUrl(String colorSwatchUrl) {
		this.colorSwatchUrl = colorSwatchUrl;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	

	@Override
	public String toString() {
		return "ColorSwatchPVO [color=" + color + ", basicColor=" + basicColor + ", colorSwatchUrl=" + colorSwatchUrl
				+ ", imageUrl=" + imageUrl + ", isAvailable=" + isAvailable + ", skuId=" + skuId + "]";
	}

}
