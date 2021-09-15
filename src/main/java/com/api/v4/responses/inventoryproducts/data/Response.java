package com.api.v4.responses.inventoryproducts.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "datetime",
        "partTwoDatetime",
        "largestLumpOfTickets",
        "availableSeatCount",
        "minPrice",
        "maxPrice",
        "noBookingFee",
        "discount"
})
public class Response {

    @JsonProperty("datetime")
    private String datetime;

    @JsonProperty("partTwoDatetime")
    private Object partTwoDatetime;

    @JsonProperty("largestLumpOfTickets")
    private Integer largestLumpOfTickets;

    @JsonProperty("availableSeatCount")
    private Integer availableSeatCount;

    @JsonProperty("minPrice")
    private Integer minPrice;

    @JsonProperty("maxPrice")
    private Object maxPrice;

    @JsonProperty("noBookingFee")
    private Boolean noBookingFee;

    @JsonProperty("discount")
    private Boolean discount;

}