package com.encore.web.tests;

import com.api.utils.DateUtils;
import com.api.v4.helpers.InventoryProductsHelpers;
import com.api.v4.responses.inventoryproducts.GetProductAreaResponse;
import com.api.v4.responses.inventoryproducts.GetProductQuantityResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * This class contains tests related to https://inventory-service.tixuk.io/api/v4/availability/products/6362/quantity/2/from/20211101/to/20211201
 * and https://inventory-service.tixuk.io/api/v4/products/6362/areas?date=20211118&time=1430&quantity=2&includeSeatsAttributes=true endpoints
 */
public class GetProductQuantityTests {

    private InventoryProductsHelpers inventoryProductsHelpers = new InventoryProductsHelpers();
    private Random randomNumber = new Random();
    private String productId = "6362";
    private String quantity = "2";
    private String fromDate = "20211101";
    private String toDate = "20211201";


    @Test
    public void testGetProductAreaIncludingSeatAttributes() {

        // Making a call to GET/v4/availability/products/%s/quantity/%s/from/%s/to/%s
        GetProductQuantityResponse getProductQuantityResponse = inventoryProductsHelpers.getProductQuantityResponse(productId, quantity, fromDate, toDate);
        Assert.assertEquals(getProductQuantityResponse.code,200,"Expected status code is 200 but actual status code is "+getProductQuantityResponse.code);
        int size = getProductQuantityResponse.getProductQuantityResponseData().getResponse().size();
        String date = getProductQuantityResponse.getProductQuantityResponseData().getResponse().get(randomNumber.nextInt(size - 1)).getDatetime();
        String formattedDate = DateUtils.getDateFromDateTime("yyyy-MM-dd'T'HH:mm:ss+SSSS", "yyyyMMdd", date);
        String time = DateUtils.getTimeFromDateTime("yyyy-MM-dd'T'HH:mm:ss+SSSS", "HHmm", date);

        // Making a call to GET/v4/products/%s/areas?date=%s&time=%s&quantity=%s
        GetProductAreaResponse getProductAreaResponse = inventoryProductsHelpers.getProductArea(productId, formattedDate, time, quantity, "true");
        Assert.assertEquals(getProductAreaResponse.code,200,"Expected status code is 200 but actual status code is "+getProductAreaResponse.code);
    }

    @Test
    public void testGetProductAreaExcludingSeatAttributes() {

        // Making a call to GET/v4/availability/products/%s/quantity/%s/from/%s/to/%s
        GetProductQuantityResponse getProductQuantityResponse = inventoryProductsHelpers.getProductQuantityResponse(productId, quantity, fromDate, toDate);
        Assert.assertEquals(getProductQuantityResponse.code,200,"Expected status code is 200 but actual status code is "+getProductQuantityResponse.code);
        int size = getProductQuantityResponse.getProductQuantityResponseData().getResponse().size();
        String date = getProductQuantityResponse.getProductQuantityResponseData().getResponse().get(randomNumber.nextInt(size - 1)).getDatetime();
        String formattedDate = DateUtils.getDateFromDateTime("yyyy-MM-dd'T'HH:mm:ss+SSSS", "yyyyMMdd", date);
        String time = DateUtils.getTimeFromDateTime("yyyy-MM-dd'T'HH:mm:ss+SSSS", "HHmm", date);

        // Making a call to GET/v4/products/%s/areas?date=%s&time=%s&quantity=%s
        GetProductAreaResponse getProductAreaResponse = inventoryProductsHelpers.getProductArea(productId, formattedDate, time, quantity, "true");
        Assert.assertEquals(getProductAreaResponse.code,200,"Expected status code is 200 but actual status code is "+getProductAreaResponse.code);
    }

}
