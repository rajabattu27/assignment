package com.api.v4.responses.inventoryproducts.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "request",
        "response",
        "context"
})
public class GetProductQuantityResponseData {

    @JsonProperty("request")
    private Request request;

    @JsonProperty("response")
    private List<Response> response = new ArrayList<Response>();

    @JsonProperty("context")
    private Object context;
}