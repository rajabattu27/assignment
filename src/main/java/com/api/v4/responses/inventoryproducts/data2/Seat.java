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
        "seatIdentifier",
        "aggregateReference",
        "row",
        "number",
        "pricing",
        "attributes",
        "isRestrictedView"
})
public class Seat {

    @JsonProperty("seatIdentifier")
    private String seatIdentifier;

    @JsonProperty("aggregateReference")
    private String aggregateReference;

    @JsonProperty("row")
    private String row;

    @JsonProperty("number")
    private Integer number;

    @JsonProperty("pricing")
    private Pricing pricing;

    @JsonProperty("attributes")
    private List<Object> attributes = new ArrayList<Object>();

    @JsonProperty("isRestrictedView")
    private Boolean isRestrictedView;

}