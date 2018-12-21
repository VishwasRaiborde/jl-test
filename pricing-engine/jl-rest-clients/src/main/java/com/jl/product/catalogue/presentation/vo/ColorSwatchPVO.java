
package com.jl.product.catalogue.presentation.vo;

import java.io.Serializable;

public class ColorSwatchPVO implements Serializable {

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((basicColor == null) ? 0 : basicColor.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((colorSwatchUrl == null) ? 0 : colorSwatchUrl.hashCode());
		result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
		result = prime * result + ((isAvailable == null) ? 0 : isAvailable.hashCode());
		result = prime * result + ((skuId == null) ? 0 : skuId.hashCode());
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
		ColorSwatchPVO other = (ColorSwatchPVO) obj;
		if (basicColor == null) {
			if (other.basicColor != null)
				return false;
		} else if (!basicColor.equals(other.basicColor))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (colorSwatchUrl == null) {
			if (other.colorSwatchUrl != null)
				return false;
		} else if (!colorSwatchUrl.equals(other.colorSwatchUrl))
			return false;
		if (imageUrl == null) {
			if (other.imageUrl != null)
				return false;
		} else if (!imageUrl.equals(other.imageUrl))
			return false;
		if (isAvailable == null) {
			if (other.isAvailable != null)
				return false;
		} else if (!isAvailable.equals(other.isAvailable))
			return false;
		if (skuId == null) {
			if (other.skuId != null)
				return false;
		} else if (!skuId.equals(other.skuId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ColorSwatchPVO [color=" + color + ", basicColor=" + basicColor + ", colorSwatchUrl=" + colorSwatchUrl
				+ ", imageUrl=" + imageUrl + ", isAvailable=" + isAvailable + ", skuId=" + skuId + "]";
	}

}
