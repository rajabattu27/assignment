package com.api.v4.responses.inventoryproducts.data2;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "productId"
})
public class UrlParams {

    @JsonProperty("productId")
    private String productId;

    @JsonProperty("productId")
    public String getProductId() {
        return productId;
    }
}