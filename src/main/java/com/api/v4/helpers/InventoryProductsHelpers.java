package com.api.v4.helpers;


import com.api.v4.requests.inventoryproducts.GetProductAreaRequest;
import com.api.v4.requests.inventoryproducts.GetProductQuantityRequest;
import com.api.v4.responses.inventoryproducts.GetProductAreaResponse;
import com.api.v4.responses.inventoryproducts.GetProductQuantityResponse;

/**
 * This class contains helpers related to inventory products endpoints
 */
public class InventoryProductsHelpers {

    public GetProductQuantityResponse getProductQuantityResponse(String productId, String quantity, String fromDate, String toDate) {
        return new GetProductQuantityRequest(productId,quantity,fromDate,toDate).execute();
    }

    public GetProductAreaResponse getProductArea(String productId, String date, String time, String quantity, String includeSeatsAttributes){
        return new GetProductAreaRequest(productId,date,time,quantity,includeSeatsAttributes).execute();
    }
}