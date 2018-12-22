
package com.jl.product.json;

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
    "facetId",
    "label",
    "qty",
    "color",
    "colorSwatchUrl",
    "isSelected",
    "seoUrlParts"
})
public class Detail {

    @JsonProperty("facetId")
    private String facetId;
    @JsonProperty("label")
    private String label;
    @JsonProperty("qty")
    private String qty;
    @JsonProperty("color")
    private String color;
    @JsonProperty("colorSwatchUrl")
    private String colorSwatchUrl;
    @JsonProperty("isSelected")
    private String isSelected;
    @JsonProperty("seoUrlParts")
    private String seoUrlParts;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("facetId")
    public String getFacetId() {
        return facetId;
    }

    @JsonProperty("facetId")
    public void setFacetId(String facetId) {
        this.facetId = facetId;
    }

    public Detail withFacetId(String facetId) {
        this.facetId = facetId;
        return this;
    }

    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    @JsonProperty("label")
    public void setLabel(String label) {
        this.label = label;
    }

    public Detail withLabel(String label) {
        this.label = label;
        return this;
    }

    @JsonProperty("qty")
    public String getQty() {
        return qty;
    }

    @JsonProperty("qty")
    public void setQty(String qty) {
        this.qty = qty;
    }

    public Detail withQty(String qty) {
        this.qty = qty;
        return this;
    }

    @JsonProperty("color")
    public String getColor() {
        return color;
    }

    @JsonProperty("color")
    public void setColor(String color) {
        this.color = color;
    }

    public Detail withColor(String color) {
        this.color = color;
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

    public Detail withColorSwatchUrl(String colorSwatchUrl) {
        this.colorSwatchUrl = colorSwatchUrl;
        return this;
    }

    @JsonProperty("isSelected")
    public String getIsSelected() {
        return isSelected;
    }

    @JsonProperty("isSelected")
    public void setIsSelected(String isSelected) {
        this.isSelected = isSelected;
    }

    public Detail withIsSelected(String isSelected) {
        this.isSelected = isSelected;
        return this;
    }

    @JsonProperty("seoUrlParts")
    public String getSeoUrlParts() {
        return seoUrlParts;
    }

    @JsonProperty("seoUrlParts")
    public void setSeoUrlParts(String seoUrlParts) {
        this.seoUrlParts = seoUrlParts;
    }

    public Detail withSeoUrlParts(String seoUrlParts) {
        this.seoUrlParts = seoUrlParts;
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

    public Detail withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(facetId).append(label).append(qty).append(color).append(colorSwatchUrl).append(isSelected).append(seoUrlParts).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Detail) == false) {
            return false;
        }
        Detail rhs = ((Detail) other);
        return new EqualsBuilder().append(facetId, rhs.facetId).append(label, rhs.label).append(qty, rhs.qty).append(color, rhs.color).append(colorSwatchUrl, rhs.colorSwatchUrl).append(isSelected, rhs.isSelected).append(seoUrlParts, rhs.seoUrlParts).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
