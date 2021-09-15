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
        "groupIdentifier",
        "aggregateReference",
        "row",
        "mode",
        "seatNumberStart",
        "seatNumberEnd",
        "availableCount",
        "pricing",
        "seats",
        "seatLumps"
})
public class Grouping {

    @JsonProperty("groupIdentifier")
    private String groupIdentifier;

    @JsonProperty("aggregateReference")
    private Object aggregateReference;

    @JsonProperty("row")
    private String row;

    @JsonProperty("mode")
    private String mode;

    @JsonProperty("seatNumberStart")
    private Integer seatNumberStart;

    @JsonProperty("seatNumberEnd")
    private Integer seatNumberEnd;

    @JsonProperty("availableCount")
    private Integer availableCount;

    @JsonProperty("pricing")
    private Pricing pricing;

    @JsonProperty("seats")
    private List<Seat> seats = new ArrayList<Seat>();

    @JsonProperty("seatLumps")
    private List<SeatLump> seatLumps = new ArrayList<SeatLump>();
}