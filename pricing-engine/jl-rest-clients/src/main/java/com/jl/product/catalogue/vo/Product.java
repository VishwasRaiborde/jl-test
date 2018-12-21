
package com.jl.product.catalogue.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    "productId",
    "type",
    "title",
    "code",
    "averageRating",
    "reviews",
    "price",
    "image",
    "additionalServices",
    "displaySpecialOffer",
    "promoMessages",
    "nonPromoMessage",
    "defaultSkuId",
    "colorSwatches",
    "colorSwatchSelected",
    "colorWheelMessage",
    "outOfStock",
    "emailMeWhenAvailable",
    "availabilityMessage",
    "compare",
    "fabric",
    "swatchAvailable",
    "categoryQuickViewEnabled",
    "swatchCategoryType",
    "brand",
    "ageRestriction",
    "isInStoreOnly",
    "isMadeToMeasure",
    "isBundle",
    "isProductSet",
    "promotionalFeatures",
    "features",
    "dynamicAttributes",
    "directorate",
    "releaseDateTimestamp"
})
public class Product {

    @JsonProperty("productId")
    private String productId;
    @JsonProperty("type")
    private String type;
    @JsonProperty("title")
    private String title;
    @JsonProperty("code")
    private String code;
    @JsonProperty("averageRating")
    private Integer averageRating;
    @JsonProperty("reviews")
    private Integer reviews;
    @JsonProperty("price")
    private Price price;
    @JsonProperty("image")
    private String image;
    @JsonProperty("additionalServices")
    private List<Object> additionalServices = new ArrayList<Object>();
    @JsonProperty("displaySpecialOffer")
    private String displaySpecialOffer;
    @JsonProperty("promoMessages")
    private PromoMessages promoMessages;
    @JsonProperty("nonPromoMessage")
    private String nonPromoMessage;
    @JsonProperty("defaultSkuId")
    private String defaultSkuId;
    @JsonProperty("colorSwatches")
    private List<ColorSwatch> colorSwatches = new ArrayList<ColorSwatch>();
    @JsonProperty("colorSwatchSelected")
    private Integer colorSwatchSelected;
    @JsonProperty("colorWheelMessage")
    private String colorWheelMessage;
    @JsonProperty("outOfStock")
    private Boolean outOfStock;
    @JsonProperty("emailMeWhenAvailable")
    private Boolean emailMeWhenAvailable;
    @JsonProperty("availabilityMessage")
    private String availabilityMessage;
    @JsonProperty("compare")
    private Boolean compare;
    @JsonProperty("fabric")
    private String fabric;
    @JsonProperty("swatchAvailable")
    private Boolean swatchAvailable;
    @JsonProperty("categoryQuickViewEnabled")
    private Boolean categoryQuickViewEnabled;
    @JsonProperty("swatchCategoryType")
    private String swatchCategoryType;
    @JsonProperty("brand")
    private String brand;
    @JsonProperty("ageRestriction")
    private Integer ageRestriction;
    @JsonProperty("isInStoreOnly")
    private Boolean isInStoreOnly;
    @JsonProperty("isMadeToMeasure")
    private Boolean isMadeToMeasure;
    @JsonProperty("isBundle")
    private Boolean isBundle;
    @JsonProperty("isProductSet")
    private Boolean isProductSet;
    @JsonProperty("promotionalFeatures")
    private List<PromotionalFeature> promotionalFeatures = new ArrayList<PromotionalFeature>();
    @JsonProperty("features")
    private List<Object> features = new ArrayList<Object>();
    @JsonProperty("dynamicAttributes")
    private DynamicAttributes dynamicAttributes;
    @JsonProperty("directorate")
    private String directorate;
    @JsonProperty("releaseDateTimestamp")
    private Integer releaseDateTimestamp;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("productId")
    public String getProductId() {
        return productId;
    }

    @JsonProperty("productId")
    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Product withProductId(String productId) {
        this.productId = productId;
        return this;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public Product withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    public Product withTitle(String title) {
        this.title = title;
        return this;
    }

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    public Product withCode(String code) {
        this.code = code;
        return this;
    }

    @JsonProperty("averageRating")
    public Integer getAverageRating() {
        return averageRating;
    }

    @JsonProperty("averageRating")
    public void setAverageRating(Integer averageRating) {
        this.averageRating = averageRating;
    }

    public Product withAverageRating(Integer averageRating) {
        this.averageRating = averageRating;
        return this;
    }

    @JsonProperty("reviews")
    public Integer getReviews() {
        return reviews;
    }

    @JsonProperty("reviews")
    public void setReviews(Integer reviews) {
        this.reviews = reviews;
    }

    public Product withReviews(Integer reviews) {
        this.reviews = reviews;
        return this;
    }

    @JsonProperty("price")
    public Price getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Price price) {
        this.price = price;
    }

    public Product withPrice(Price price) {
        this.price = price;
        return this;
    }

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    public Product withImage(String image) {
        this.image = image;
        return this;
    }

    @JsonProperty("additionalServices")
    public List<Object> getAdditionalServices() {
        return additionalServices;
    }

    @JsonProperty("additionalServices")
    public void setAdditionalServices(List<Object> additionalServices) {
        this.additionalServices = additionalServices;
    }

    public Product withAdditionalServices(List<Object> additionalServices) {
        this.additionalServices = additionalServices;
        return this;
    }

    @JsonProperty("displaySpecialOffer")
    public String getDisplaySpecialOffer() {
        return displaySpecialOffer;
    }

    @JsonProperty("displaySpecialOffer")
    public void setDisplaySpecialOffer(String displaySpecialOffer) {
        this.displaySpecialOffer = displaySpecialOffer;
    }

    public Product withDisplaySpecialOffer(String displaySpecialOffer) {
        this.displaySpecialOffer = displaySpecialOffer;
        return this;
    }

    @JsonProperty("promoMessages")
    public PromoMessages getPromoMessages() {
        return promoMessages;
    }

    @JsonProperty("promoMessages")
    public void setPromoMessages(PromoMessages promoMessages) {
        this.promoMessages = promoMessages;
    }

    public Product withPromoMessages(PromoMessages promoMessages) {
        this.promoMessages = promoMessages;
        return this;
    }

    @JsonProperty("nonPromoMessage")
    public String getNonPromoMessage() {
        return nonPromoMessage;
    }

    @JsonProperty("nonPromoMessage")
    public void setNonPromoMessage(String nonPromoMessage) {
        this.nonPromoMessage = nonPromoMessage;
    }

    public Product withNonPromoMessage(String nonPromoMessage) {
        this.nonPromoMessage = nonPromoMessage;
        return this;
    }

    @JsonProperty("defaultSkuId")
    public String getDefaultSkuId() {
        return defaultSkuId;
    }

    @JsonProperty("defaultSkuId")
    public void setDefaultSkuId(String defaultSkuId) {
        this.defaultSkuId = defaultSkuId;
    }

    public Product withDefaultSkuId(String defaultSkuId) {
        this.defaultSkuId = defaultSkuId;
        return this;
    }

    @JsonProperty("colorSwatches")
    public List<ColorSwatch> getColorSwatches() {
        return colorSwatches;
    }

    @JsonProperty("colorSwatches")
    public void setColorSwatches(List<ColorSwatch> colorSwatches) {
        this.colorSwatches = colorSwatches;
    }

    public Product withColorSwatches(List<ColorSwatch> colorSwatches) {
        this.colorSwatches = colorSwatches;
        return this;
    }

    @JsonProperty("colorSwatchSelected")
    public Integer getColorSwatchSelected() {
        return colorSwatchSelected;
    }

    @JsonProperty("colorSwatchSelected")
    public void setColorSwatchSelected(Integer colorSwatchSelected) {
        this.colorSwatchSelected = colorSwatchSelected;
    }

    public Product withColorSwatchSelected(Integer colorSwatchSelected) {
        this.colorSwatchSelected = colorSwatchSelected;
        return this;
    }

    @JsonProperty("colorWheelMessage")
    public String getColorWheelMessage() {
        return colorWheelMessage;
    }

    @JsonProperty("colorWheelMessage")
    public void setColorWheelMessage(String colorWheelMessage) {
        this.colorWheelMessage = colorWheelMessage;
    }

    public Product withColorWheelMessage(String colorWheelMessage) {
        this.colorWheelMessage = colorWheelMessage;
        return this;
    }

    @JsonProperty("outOfStock")
    public Boolean getOutOfStock() {
        return outOfStock;
    }

    @JsonProperty("outOfStock")
    public void setOutOfStock(Boolean outOfStock) {
        this.outOfStock = outOfStock;
    }

    public Product withOutOfStock(Boolean outOfStock) {
        this.outOfStock = outOfStock;
        return this;
    }

    @JsonProperty("emailMeWhenAvailable")
    public Boolean getEmailMeWhenAvailable() {
        return emailMeWhenAvailable;
    }

    @JsonProperty("emailMeWhenAvailable")
    public void setEmailMeWhenAvailable(Boolean emailMeWhenAvailable) {
        this.emailMeWhenAvailable = emailMeWhenAvailable;
    }

    public Product withEmailMeWhenAvailable(Boolean emailMeWhenAvailable) {
        this.emailMeWhenAvailable = emailMeWhenAvailable;
        return this;
    }

    @JsonProperty("availabilityMessage")
    public String getAvailabilityMessage() {
        return availabilityMessage;
    }

    @JsonProperty("availabilityMessage")
    public void setAvailabilityMessage(String availabilityMessage) {
        this.availabilityMessage = availabilityMessage;
    }

    public Product withAvailabilityMessage(String availabilityMessage) {
        this.availabilityMessage = availabilityMessage;
        return this;
    }

    @JsonProperty("compare")
    public Boolean getCompare() {
        return compare;
    }

    @JsonProperty("compare")
    public void setCompare(Boolean compare) {
        this.compare = compare;
    }

    public Product withCompare(Boolean compare) {
        this.compare = compare;
        return this;
    }

    @JsonProperty("fabric")
    public String getFabric() {
        return fabric;
    }

    @JsonProperty("fabric")
    public void setFabric(String fabric) {
        this.fabric = fabric;
    }

    public Product withFabric(String fabric) {
        this.fabric = fabric;
        return this;
    }

    @JsonProperty("swatchAvailable")
    public Boolean getSwatchAvailable() {
        return swatchAvailable;
    }

    @JsonProperty("swatchAvailable")
    public void setSwatchAvailable(Boolean swatchAvailable) {
        this.swatchAvailable = swatchAvailable;
    }

    public Product withSwatchAvailable(Boolean swatchAvailable) {
        this.swatchAvailable = swatchAvailable;
        return this;
    }

    @JsonProperty("categoryQuickViewEnabled")
    public Boolean getCategoryQuickViewEnabled() {
        return categoryQuickViewEnabled;
    }

    @JsonProperty("categoryQuickViewEnabled")
    public void setCategoryQuickViewEnabled(Boolean categoryQuickViewEnabled) {
        this.categoryQuickViewEnabled = categoryQuickViewEnabled;
    }

    public Product withCategoryQuickViewEnabled(Boolean categoryQuickViewEnabled) {
        this.categoryQuickViewEnabled = categoryQuickViewEnabled;
        return this;
    }

    @JsonProperty("swatchCategoryType")
    public String getSwatchCategoryType() {
        return swatchCategoryType;
    }

    @JsonProperty("swatchCategoryType")
    public void setSwatchCategoryType(String swatchCategoryType) {
        this.swatchCategoryType = swatchCategoryType;
    }

    public Product withSwatchCategoryType(String swatchCategoryType) {
        this.swatchCategoryType = swatchCategoryType;
        return this;
    }

    @JsonProperty("brand")
    public String getBrand() {
        return brand;
    }

    @JsonProperty("brand")
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Product withBrand(String brand) {
        this.brand = brand;
        return this;
    }

    @JsonProperty("ageRestriction")
    public Integer getAgeRestriction() {
        return ageRestriction;
    }

    @JsonProperty("ageRestriction")
    public void setAgeRestriction(Integer ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public Product withAgeRestriction(Integer ageRestriction) {
        this.ageRestriction = ageRestriction;
        return this;
    }

    @JsonProperty("isInStoreOnly")
    public Boolean getIsInStoreOnly() {
        return isInStoreOnly;
    }

    @JsonProperty("isInStoreOnly")
    public void setIsInStoreOnly(Boolean isInStoreOnly) {
        this.isInStoreOnly = isInStoreOnly;
    }

    public Product withIsInStoreOnly(Boolean isInStoreOnly) {
        this.isInStoreOnly = isInStoreOnly;
        return this;
    }

    @JsonProperty("isMadeToMeasure")
    public Boolean getIsMadeToMeasure() {
        return isMadeToMeasure;
    }

    @JsonProperty("isMadeToMeasure")
    public void setIsMadeToMeasure(Boolean isMadeToMeasure) {
        this.isMadeToMeasure = isMadeToMeasure;
    }

    public Product withIsMadeToMeasure(Boolean isMadeToMeasure) {
        this.isMadeToMeasure = isMadeToMeasure;
        return this;
    }

    @JsonProperty("isBundle")
    public Boolean getIsBundle() {
        return isBundle;
    }

    @JsonProperty("isBundle")
    public void setIsBundle(Boolean isBundle) {
        this.isBundle = isBundle;
    }

    public Product withIsBundle(Boolean isBundle) {
        this.isBundle = isBundle;
        return this;
    }

    @JsonProperty("isProductSet")
    public Boolean getIsProductSet() {
        return isProductSet;
    }

    @JsonProperty("isProductSet")
    public void setIsProductSet(Boolean isProductSet) {
        this.isProductSet = isProductSet;
    }

    public Product withIsProductSet(Boolean isProductSet) {
        this.isProductSet = isProductSet;
        return this;
    }

    @JsonProperty("promotionalFeatures")
    public List<PromotionalFeature> getPromotionalFeatures() {
        return promotionalFeatures;
    }

    @JsonProperty("promotionalFeatures")
    public void setPromotionalFeatures(List<PromotionalFeature> promotionalFeatures) {
        this.promotionalFeatures = promotionalFeatures;
    }

    public Product withPromotionalFeatures(List<PromotionalFeature> promotionalFeatures) {
        this.promotionalFeatures = promotionalFeatures;
        return this;
    }

    @JsonProperty("features")
    public List<Object> getFeatures() {
        return features;
    }

    @JsonProperty("features")
    public void setFeatures(List<Object> features) {
        this.features = features;
    }

    public Product withFeatures(List<Object> features) {
        this.features = features;
        return this;
    }

    @JsonProperty("dynamicAttributes")
    public DynamicAttributes getDynamicAttributes() {
        return dynamicAttributes;
    }

    @JsonProperty("dynamicAttributes")
    public void setDynamicAttributes(DynamicAttributes dynamicAttributes) {
        this.dynamicAttributes = dynamicAttributes;
    }

    public Product withDynamicAttributes(DynamicAttributes dynamicAttributes) {
        this.dynamicAttributes = dynamicAttributes;
        return this;
    }

    @JsonProperty("directorate")
    public String getDirectorate() {
        return directorate;
    }

    @JsonProperty("directorate")
    public void setDirectorate(String directorate) {
        this.directorate = directorate;
    }

    public Product withDirectorate(String directorate) {
        this.directorate = directorate;
        return this;
    }

    @JsonProperty("releaseDateTimestamp")
    public Integer getReleaseDateTimestamp() {
        return releaseDateTimestamp;
    }

    @JsonProperty("releaseDateTimestamp")
    public void setReleaseDateTimestamp(Integer releaseDateTimestamp) {
        this.releaseDateTimestamp = releaseDateTimestamp;
    }

    public Product withReleaseDateTimestamp(Integer releaseDateTimestamp) {
        this.releaseDateTimestamp = releaseDateTimestamp;
        return this;
    }

    /*@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }*/

    
    
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @Override
	public String toString() {
		return "Product [productId=" + productId + ", type=" + type + ", title=" + title + ", code=" + code
				+ ", averageRating=" + averageRating + ", reviews=" + reviews + ", price=" + price + ", image=" + image
				+ ", additionalServices=" + additionalServices + ", displaySpecialOffer=" + displaySpecialOffer
				+ ", promoMessages=" + promoMessages + ", nonPromoMessage=" + nonPromoMessage + ", defaultSkuId="
				+ defaultSkuId + ", colorSwatches=" + colorSwatches + ", colorSwatchSelected=" + colorSwatchSelected
				+ ", colorWheelMessage=" + colorWheelMessage + ", outOfStock=" + outOfStock + ", emailMeWhenAvailable="
				+ emailMeWhenAvailable + ", availabilityMessage=" + availabilityMessage + ", compare=" + compare
				+ ", fabric=" + fabric + ", swatchAvailable=" + swatchAvailable + ", categoryQuickViewEnabled="
				+ categoryQuickViewEnabled + ", swatchCategoryType=" + swatchCategoryType + ", brand=" + brand
				+ ", ageRestriction=" + ageRestriction + ", isInStoreOnly=" + isInStoreOnly + ", isMadeToMeasure="
				+ isMadeToMeasure + ", isBundle=" + isBundle + ", isProductSet=" + isProductSet
				+ ", promotionalFeatures=" + promotionalFeatures + ", features=" + features + ", dynamicAttributes="
				+ dynamicAttributes + ", directorate=" + directorate + ", releaseDateTimestamp=" + releaseDateTimestamp
				+ ", additionalProperties=" + additionalProperties + "]";
	}

	@JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Product withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(productId).append(type).append(title).append(code).append(averageRating).append(reviews).append(price).append(image).append(additionalServices).append(displaySpecialOffer).append(promoMessages).append(nonPromoMessage).append(defaultSkuId).append(colorSwatches).append(colorSwatchSelected).append(colorWheelMessage).append(outOfStock).append(emailMeWhenAvailable).append(availabilityMessage).append(compare).append(fabric).append(swatchAvailable).append(categoryQuickViewEnabled).append(swatchCategoryType).append(brand).append(ageRestriction).append(isInStoreOnly).append(isMadeToMeasure).append(isBundle).append(isProductSet).append(promotionalFeatures).append(features).append(dynamicAttributes).append(directorate).append(releaseDateTimestamp).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Product) == false) {
            return false;
        }
        Product rhs = ((Product) other);
        return new EqualsBuilder().append(productId, rhs.productId).append(type, rhs.type).append(title, rhs.title).append(code, rhs.code).append(averageRating, rhs.averageRating).append(reviews, rhs.reviews).append(price, rhs.price).append(image, rhs.image).append(additionalServices, rhs.additionalServices).append(displaySpecialOffer, rhs.displaySpecialOffer).append(promoMessages, rhs.promoMessages).append(nonPromoMessage, rhs.nonPromoMessage).append(defaultSkuId, rhs.defaultSkuId).append(colorSwatches, rhs.colorSwatches).append(colorSwatchSelected, rhs.colorSwatchSelected).append(colorWheelMessage, rhs.colorWheelMessage).append(outOfStock, rhs.outOfStock).append(emailMeWhenAvailable, rhs.emailMeWhenAvailable).append(availabilityMessage, rhs.availabilityMessage).append(compare, rhs.compare).append(fabric, rhs.fabric).append(swatchAvailable, rhs.swatchAvailable).append(categoryQuickViewEnabled, rhs.categoryQuickViewEnabled).append(swatchCategoryType, rhs.swatchCategoryType).append(brand, rhs.brand).append(ageRestriction, rhs.ageRestriction).append(isInStoreOnly, rhs.isInStoreOnly).append(isMadeToMeasure, rhs.isMadeToMeasure).append(isBundle, rhs.isBundle).append(isProductSet, rhs.isProductSet).append(promotionalFeatures, rhs.promotionalFeatures).append(features, rhs.features).append(dynamicAttributes, rhs.dynamicAttributes).append(directorate, rhs.directorate).append(releaseDateTimestamp, rhs.releaseDateTimestamp).append(additionalProperties, rhs.additionalProperties).isEquals();
    }
    
    

}
