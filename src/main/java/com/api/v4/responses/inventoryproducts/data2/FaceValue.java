package com.api.v4.responses.inventoryproducts.data2;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "value",
        "currency",
        "decimalPlaces"
})
public class FaceValue {

    @JsonProperty("value")
    private Integer value;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("decimalPlaces")
    private Integer decimalPlaces;
}