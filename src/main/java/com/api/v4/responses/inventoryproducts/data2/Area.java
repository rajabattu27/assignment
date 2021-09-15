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
        "availableCount",
        "date",
        "partTwoDate",
        "name",
        "mode",
        "groupings"
})
public class Area {

    @JsonProperty("availableCount")
    private Integer availableCount;

    @JsonProperty("date")
    private String date;

    @JsonProperty("partTwoDate")
    private Object partTwoDate;

    @JsonProperty("name")
    private String name;

    @JsonProperty("mode")
    private String mode;

    @JsonProperty("groupings")
    private List<Grouping> groupings = new ArrayList<Grouping>();
}