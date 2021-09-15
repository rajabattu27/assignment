package com.api.v4.responses.inventoryproducts.data2;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "displayCurrency",
        "availableCount",
        "areas"
})
public class Response {

    @JsonProperty("displayCurrency")
    private String displayCurrency;

    @JsonProperty("availableCount")
    private Integer availableCount;

    @JsonProperty("areas")
    private List<Area> areas = new ArrayList<Area>();
}