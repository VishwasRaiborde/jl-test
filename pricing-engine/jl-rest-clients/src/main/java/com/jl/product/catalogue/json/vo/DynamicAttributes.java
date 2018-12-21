
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
    "newinproducttype",
    "washinginstructions",
    "dressbyoccasion",
    "dressshape",
    "typeofpattern",
    "luxuryfabric",
    "fabric",
    "typeofknit",
    "countryoforigin",
    "dryinginstructions"
})
public class DynamicAttributes {

    @JsonProperty("newinproducttype")
    private String newinproducttype;
    @JsonProperty("washinginstructions")
    private String washinginstructions;
    @JsonProperty("dressbyoccasion")
    private String dressbyoccasion;
    @JsonProperty("dressshape")
    private String dressshape;
    @JsonProperty("typeofpattern")
    private String typeofpattern;
    @JsonProperty("luxuryfabric")
    private String luxuryfabric;
    @JsonProperty("fabric")
    private String fabric;
    @JsonProperty("typeofknit")
    private String typeofknit;
    @JsonProperty("countryoforigin")
    private String countryoforigin;
    @JsonProperty("dryinginstructions")
    private String dryinginstructions;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("newinproducttype")
    public String getNewinproducttype() {
        return newinproducttype;
    }

    @JsonProperty("newinproducttype")
    public void setNewinproducttype(String newinproducttype) {
        this.newinproducttype = newinproducttype;
    }

    public DynamicAttributes withNewinproducttype(String newinproducttype) {
        this.newinproducttype = newinproducttype;
        return this;
    }

    @JsonProperty("washinginstructions")
    public String getWashinginstructions() {
        return washinginstructions;
    }

    @JsonProperty("washinginstructions")
    public void setWashinginstructions(String washinginstructions) {
        this.washinginstructions = washinginstructions;
    }

    public DynamicAttributes withWashinginstructions(String washinginstructions) {
        this.washinginstructions = washinginstructions;
        return this;
    }

    @JsonProperty("dressbyoccasion")
    public String getDressbyoccasion() {
        return dressbyoccasion;
    }

    @JsonProperty("dressbyoccasion")
    public void setDressbyoccasion(String dressbyoccasion) {
        this.dressbyoccasion = dressbyoccasion;
    }

    public DynamicAttributes withDressbyoccasion(String dressbyoccasion) {
        this.dressbyoccasion = dressbyoccasion;
        return this;
    }

    @JsonProperty("dressshape")
    public String getDressshape() {
        return dressshape;
    }

    @JsonProperty("dressshape")
    public void setDressshape(String dressshape) {
        this.dressshape = dressshape;
    }

    public DynamicAttributes withDressshape(String dressshape) {
        this.dressshape = dressshape;
        return this;
    }

    @JsonProperty("typeofpattern")
    public String getTypeofpattern() {
        return typeofpattern;
    }

    @JsonProperty("typeofpattern")
    public void setTypeofpattern(String typeofpattern) {
        this.typeofpattern = typeofpattern;
    }

    public DynamicAttributes withTypeofpattern(String typeofpattern) {
        this.typeofpattern = typeofpattern;
        return this;
    }

    @JsonProperty("luxuryfabric")
    public String getLuxuryfabric() {
        return luxuryfabric;
    }

    @JsonProperty("luxuryfabric")
    public void setLuxuryfabric(String luxuryfabric) {
        this.luxuryfabric = luxuryfabric;
    }

    public DynamicAttributes withLuxuryfabric(String luxuryfabric) {
        this.luxuryfabric = luxuryfabric;
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

    public DynamicAttributes withFabric(String fabric) {
        this.fabric = fabric;
        return this;
    }

    @JsonProperty("typeofknit")
    public String getTypeofknit() {
        return typeofknit;
    }

    @JsonProperty("typeofknit")
    public void setTypeofknit(String typeofknit) {
        this.typeofknit = typeofknit;
    }

    public DynamicAttributes withTypeofknit(String typeofknit) {
        this.typeofknit = typeofknit;
        return this;
    }

    @JsonProperty("countryoforigin")
    public String getCountryoforigin() {
        return countryoforigin;
    }

    @JsonProperty("countryoforigin")
    public void setCountryoforigin(String countryoforigin) {
        this.countryoforigin = countryoforigin;
    }

    public DynamicAttributes withCountryoforigin(String countryoforigin) {
        this.countryoforigin = countryoforigin;
        return this;
    }

    @JsonProperty("dryinginstructions")
    public String getDryinginstructions() {
        return dryinginstructions;
    }

    @JsonProperty("dryinginstructions")
    public void setDryinginstructions(String dryinginstructions) {
        this.dryinginstructions = dryinginstructions;
    }

    public DynamicAttributes withDryinginstructions(String dryinginstructions) {
        this.dryinginstructions = dryinginstructions;
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

    public DynamicAttributes withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(newinproducttype).append(washinginstructions).append(dressbyoccasion).append(dressshape).append(typeofpattern).append(luxuryfabric).append(fabric).append(typeofknit).append(countryoforigin).append(dryinginstructions).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DynamicAttributes) == false) {
            return false;
        }
        DynamicAttributes rhs = ((DynamicAttributes) other);
        return new EqualsBuilder().append(newinproducttype, rhs.newinproducttype).append(washinginstructions, rhs.washinginstructions).append(dressbyoccasion, rhs.dressbyoccasion).append(dressshape, rhs.dressshape).append(typeofpattern, rhs.typeofpattern).append(luxuryfabric, rhs.luxuryfabric).append(fabric, rhs.fabric).append(typeofknit, rhs.typeofknit).append(countryoforigin, rhs.countryoforigin).append(dryinginstructions, rhs.dryinginstructions).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
