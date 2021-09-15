package com.api.v4.responses.inventoryproducts;

import com.api.core.HttpResponse;
import com.api.v4.responses.inventoryproducts.data.GetProductQuantityResponseData;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class contains response data for https://inventory-service.tixuk.io/api/v4/availability/products/6362/quantity/2/from/20211101/to/20211201
 */
public class GetProductQuantityResponse extends HttpResponse {

    private GetProductQuantityResponseData responseData;

    public GetProductQuantityResponse(HttpResponse getProductQuantityResponse) {
        this.code = getProductQuantityResponse.code;
        this.body = getProductQuantityResponse.body;
        this.errorMessage = getProductQuantityResponse.errorMessage;
        this.json = getProductQuantityResponse.json;
    }

    public GetProductQuantityResponseData getProductQuantityResponseData() {
        if (this.code == 200 && this.body != null) {
            try {
                responseData = new ObjectMapper().readValue(this.body, GetProductQuantityResponseData.class);
            } catch (Exception e) {
                throw new RuntimeException("There was an error processing the Json in the response body. Please check the JSON Mapping in the code.", e);
            }
        }
        return responseData;
    }
}
