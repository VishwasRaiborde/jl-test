
package com.jl.product.catalogue.json.vo;

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
    "title",
    "iconUrl",
    "linkUrl",
    "description",
    "longDescription"
})
public class PromotionalFeature {

    @JsonProperty("title")
    private String title;
    @JsonProperty("iconUrl")
    private String iconUrl;
    @JsonProperty("linkUrl")
    private String linkUrl;
    @JsonProperty("description")
    private String description;
    @JsonProperty("longDescription")
    private String longDescription;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    public PromotionalFeature withTitle(String title) {
        this.title = title;
        return this;
    }

    @JsonProperty("iconUrl")
    public String getIconUrl() {
        return iconUrl;
    }

    @JsonProperty("iconUrl")
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public PromotionalFeature withIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
        return this;
    }

    @JsonProperty("linkUrl")
    public String getLinkUrl() {
        return linkUrl;
    }

    @JsonProperty("linkUrl")
    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public PromotionalFeature withLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
        return this;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public PromotionalFeature withDescription(String description) {
        this.description = description;
        return this;
    }

    @JsonProperty("longDescription")
    public String getLongDescription() {
        return longDescription;
    }

    @JsonProperty("longDescription")
    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public PromotionalFeature withLongDescription(String longDescription) {
        this.longDescription = longDescription;
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

    public PromotionalFeature withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(title).append(iconUrl).append(linkUrl).append(description).append(longDescription).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PromotionalFeature) == false) {
            return false;
        }
        PromotionalFeature rhs = ((PromotionalFeature) other);
        return new EqualsBuilder().append(title, rhs.title).append(iconUrl, rhs.iconUrl).append(linkUrl, rhs.linkUrl).append(description, rhs.description).append(longDescription, rhs.longDescription).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
