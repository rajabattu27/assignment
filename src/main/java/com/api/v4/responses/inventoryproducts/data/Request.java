package com.api.v4.responses.inventoryproducts.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "body",
        "query",
        "urlParams"
})
public class Request {

    @JsonProperty("body")
    private String body;

    @JsonProperty("query")
    private Query query;

    @JsonProperty("urlParams")
    private UrlParams urlParams;

}