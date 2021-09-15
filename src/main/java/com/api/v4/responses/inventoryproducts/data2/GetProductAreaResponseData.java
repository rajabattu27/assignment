package com.api.v4.responses.inventoryproducts.data2;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "request",
        "response",
        "context"
})
public class GetProductAreaResponseData {

    @JsonProperty("request")
    private Request request;

    @JsonProperty("response")
    private Response response;

    @JsonProperty("context")
    private Object context;
}