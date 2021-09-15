package com.api.v4.requests.inventoryproducts;


import com.api.constants.RequestMethod;
import com.api.core.HttpRequest;
import com.api.core.HttpResponse;
import com.api.v4.responses.inventoryproducts.GetProductQuantityResponse;

/**
 * This class contains request data for https://inventory-service.tixuk.io/api/v4/availability/products/6362/quantity/2/from/20211101/to/20211201
 */
public class GetProductQuantityRequest extends HttpRequest {

    private final String pathFormat = "/v4/availability/products/%s/quantity/%s/from/%s/to/%s";

    public GetProductQuantityRequest(String productId, String quantity, String fromDate, String toDate) {
        this.requestMethod = RequestMethod.Get;
        this.pathAndQueryString = String.format(pathFormat, productId, quantity, fromDate, toDate);
        this.contentType = "application/json";
        this.affiliateId = "encoretickets";
    }

    public GetProductQuantityResponse execute() {
        HttpResponse baseResponse;
        try {
            baseResponse = super.execute();
            return new GetProductQuantityResponse(baseResponse);
        } catch (Exception e) {
            throw new RuntimeException("There was an error while fetching the response", e);
        }
    }
}
