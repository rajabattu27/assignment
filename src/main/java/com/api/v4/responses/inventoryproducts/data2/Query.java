package com.api.v4.responses.inventoryproducts.data2;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "date",
        "includeSeatsAttributes",
        "quantity",
        "time"
})
public class Query {

    @JsonProperty("affiliateId")
    private String affiliateId;

    @JsonProperty("date")
    private String date;

    @JsonProperty("includeSeatsAttributes")
    private String includeSeatsAttributes;

    @JsonProperty("quantity")
    private String quantity;

    @JsonProperty("time")
    private String time;
}