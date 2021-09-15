package com.api.v4.responses.inventoryproducts.data2;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "seats"
})
public class SeatLump {

    @JsonProperty("seats")
    private List<String> seats = new ArrayList<String>();

    @JsonProperty("seats")
    public List<String> getSeats() {
        return seats;
    }

    @JsonProperty("seats")
    public void setSeats(List<String> seats) {
        this.seats = seats;
    }

}