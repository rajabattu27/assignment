package com.api.v4.responses.inventoryproducts.data2;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "salePrice",
        "faceValue",
        "percentageDiscount",
        "includesBookingFee",
        "createdAt",
        "promotionLabel"
})
public class Pricing {

    @JsonProperty("salePrice")
    private List<SalePrice> salePrice = new ArrayList<SalePrice>();

    @JsonProperty("faceValue")
    private List<FaceValue> faceValue = new ArrayList<FaceValue>();

    @JsonProperty("percentageDiscount")
    private Integer percentageDiscount;

    @JsonProperty("includesBookingFee")
    private Boolean includesBookingFee;

    @JsonProperty("createdAt")
    private String createdAt;

    @JsonProperty("promotionLabel")
    private Object promotionLabel;

}