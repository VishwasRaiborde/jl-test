
package com.jl.product.catalogue.vo;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "color",
    "basicColor",
    "colorSwatchUrl",
    "imageUrl",
    "isAvailable",
    "skuId"
})
public class ColorSwatch {

    @JsonProperty("color")
    private String color;
    @JsonProperty("basicColor")
    private String basicColor;
    @JsonProperty("colorSwatchUrl")
    private String colorSwatchUrl;
    @JsonProperty("imageUrl")
    private String imageUrl;
    @JsonProperty("isAvailable")
    private Boolean isAvailable;
    @JsonProperty("skuId")
    private String skuId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("color")
    public String getColor() {
        return color;
    }

    @JsonProperty("color")
    public void setColor(String color) {
        this.color = color;
    }

    public ColorSwatch withColor(String color) {
        this.color = color;
        return this;
    }

    @JsonProperty("basicColor")
    public String getBasicColor() {
        return basicColor;
    }

    @JsonProperty("basicColor")
    public void setBasicColor(String basicColor) {
        this.basicColor = basicColor;
    }

    public ColorSwatch withBasicColor(String basicColor) {
        this.basicColor = basicColor;
        return this;
    }

    @JsonProperty("colorSwatchUrl")
    public String getColorSwatchUrl() {
        return colorSwatchUrl;
    }

    @JsonProperty("colorSwatchUrl")
    public void setColorSwatchUrl(String colorSwatchUrl) {
        this.colorSwatchUrl = colorSwatchUrl;
    }

    public ColorSwatch withColorSwatchUrl(String colorSwatchUrl) {
        this.colorSwatchUrl = colorSwatchUrl;
        return this;
    }

    @JsonProperty("imageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("imageUrl")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ColorSwatch withImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    @JsonProperty("isAvailable")
    public Boolean getIsAvailable() {
        return isAvailable;
    }

    @JsonProperty("isAvailable")
    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public ColorSwatch withIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
        return this;
    }

    @JsonProperty("skuId")
    public String getSkuId() {
        return skuId;
    }

    @JsonProperty("skuId")
    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public ColorSwatch withSkuId(String skuId) {
        this.skuId = skuId;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public ColorSwatch withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(color).append(basicColor).append(colorSwatchUrl).append(imageUrl).append(isAvailable).append(skuId).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ColorSwatch) == false) {
            return false;
        }
        ColorSwatch rhs = ((ColorSwatch) other);
        return new EqualsBuilder().append(color, rhs.color).append(basicColor, rhs.basicColor).append(colorSwatchUrl, rhs.colorSwatchUrl).append(imageUrl, rhs.imageUrl).append(isAvailable, rhs.isAvailable).append(skuId, rhs.skuId).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
