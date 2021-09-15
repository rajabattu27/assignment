package com.api.v4.responses.inventoryproducts;

import com.api.core.HttpResponse;
import com.api.v4.responses.inventoryproducts.data2.GetProductAreaResponseData;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class contains response data for https://inventory-service.tixuk.io/api/v4/products/6362/areas?date=20211118&time=1430&quantity=2&includeSeatsAttributes=true
 */
public class GetProductAreaResponse extends HttpResponse {

    private GetProductAreaResponseData responseData;

    public GetProductAreaResponse(HttpResponse getProductAreaResponse) {
        this.code = getProductAreaResponse.code;
        this.body = getProductAreaResponse.body;
        this.errorMessage = getProductAreaResponse.errorMessage;
        this.json = getProductAreaResponse.json;
    }

    public GetProductAreaResponseData getProductAreaResponseData() {
        if (this.code == 200 && this.body != null) {
            try {
                responseData = new ObjectMapper().readValue(this.body, GetProductAreaResponseData.class);
            } catch (Exception e) {
                throw new RuntimeException("There was an error processing the Json in the response body. Please check the JSON Mapping in the code.", e);
            }
        }
        return responseData;
    }
}
