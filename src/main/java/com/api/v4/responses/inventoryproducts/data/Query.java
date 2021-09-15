package com.api.v4.responses.inventoryproducts.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "affiliateId"
})
public class Query {

    @JsonProperty("affiliateId")
    private String affiliateId;
}