package com.api.v4.responses.inventoryproducts.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "productId",
        "quantity",
        "fromDate",
        "toDate"
})
public class UrlParams {

    @JsonProperty("productId")
    private String productId;

    @JsonProperty("quantity")
    private String quantity;

    @JsonProperty("fromDate")
    private String fromDate;

    @JsonProperty("toDate")
    private String toDate;
}