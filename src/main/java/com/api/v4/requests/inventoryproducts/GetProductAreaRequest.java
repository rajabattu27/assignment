package com.api.v4.requests.inventoryproducts;


import com.api.constants.RequestMethod;
import com.api.core.HttpRequest;
import com.api.core.HttpResponse;
import com.api.v4.responses.inventoryproducts.GetProductAreaResponse;

/**
 * This class contains request data for https://inventory-service.tixuk.io/api/v4/products/6362/areas?date=20211118&time=1430&quantity=2&includeSeatsAttributes=true
 */
public class GetProductAreaRequest extends HttpRequest {

    private final String urlFormat = "/v4/products/%s/areas?date=%s&time=%s&quantity=%s";
    private final String includeSeatQueryParam = "&includeSeatsAttributes=%s";

    public GetProductAreaRequest(String productId, String date, String time, String quantity, String includeSeatsAttributes) {
        this.requestMethod = RequestMethod.Get;
        this.pathAndQueryString = String.format(urlFormat, productId, date, time, quantity) +
                (includeSeatsAttributes != "" ? String.format(includeSeatQueryParam, includeSeatsAttributes) : includeSeatsAttributes);
        this.requestMethod = RequestMethod.Get;
        this.affiliateId = "encoretickets";
    }

    public GetProductAreaResponse execute() {
        HttpResponse baseResponse;
        try {
            baseResponse = super.execute();
            return new GetProductAreaResponse(baseResponse);
        } catch (Exception e) {
            throw new RuntimeException("There was an error while fetching the response", e);
        }
    }
}
