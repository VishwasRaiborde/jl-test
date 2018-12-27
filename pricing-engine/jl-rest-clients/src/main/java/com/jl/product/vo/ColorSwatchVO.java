
package com.jl.product.vo;

import java.io.Serializable;

public class ColorSwatchVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 private String color;

	transient private String basicColor;

	transient private String colorSwatchUrl;

	transient private String imageUrl;

	transient private Boolean isAvailable;

	transient private String skuId;
	
	private String rgbColor ;
	

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

	

	public String getRgbColor() {
		return rgbColor;
	}

	public void setRgbColor(String rgbColor) {
		this.rgbColor = rgbColor;
	}

	@Override
	public String toString() {
		return "ColorSwatchVO [color=" + color + ", basicColor=" + basicColor + ", colorSwatchUrl=" + colorSwatchUrl
				+ ", imageUrl=" + imageUrl + ", isAvailable=" + isAvailable + ", skuId=" + skuId + ", rgbColor="
				+ rgbColor + "]";
	}

	

}
