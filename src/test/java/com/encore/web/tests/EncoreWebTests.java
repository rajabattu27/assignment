package com.encore.web.tests;

import com.api.utils.DateUtils;
import com.api.v4.helpers.InventoryProductsHelpers;
import com.api.v4.responses.inventoryproducts.GetProductAreaResponse;
import com.api.v4.responses.inventoryproducts.GetProductQuantityResponse;
import com.web.encore.pages.SeatPlanningPage;
import com.web.framework.AppDriver;
import com.web.framework.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * Encore Tests
 *
 */
public class EncoreWebTests extends BaseTest {

    private final String showName = "TINA-The Tina Turner Musical";
    private final InventoryProductsHelpers inventoryProductsHelpers = new InventoryProductsHelpers();
    private final Random randomNumber = new Random();
    private final String productId = "6362";
    private final String quantity = "2";
    private final String fromDate = "20211101";
    private final String toDate = "20211201";
    private String date = "";
    private String selectedDate = "20211122";
    private String selectedTime = "1900";


    @BeforeMethod
    public void getRandomDateAndTimeForBookingViaAPI() {

        // Making a call to GET/v4/availability/products/%s/quantity/%s/from/%s/to/%s
        GetProductQuantityResponse getProductQuantityResponse = inventoryProductsHelpers.getProductQuantityResponse(productId, quantity, fromDate, toDate);
        Assert.assertEquals(getProductQuantityResponse.code,200,"Expected status code is 200 but actual status code is "+getProductQuantityResponse.code);
        int size = getProductQuantityResponse.getProductQuantityResponseData().getResponse().size();
        date = getProductQuantityResponse.getProductQuantityResponseData().getResponse().get(randomNumber.nextInt(size - 1)).getDatetime();
      //  selectedDate = DateUtils.getDateFromDateTime("yyyy-MM-dd'T'HH:mm:ss+SSSS", "yyyyMMdd", date);
       // selectedTime = DateUtils.getTimeFromDateTime("yyyy-MM-dd'T'HH:mm:ss+SSSS", "HHmm", date);

        // Making a call to GET/v4/products/%s/areas?date=%s&time=%s&quantity=%s
        GetProductAreaResponse getProductAreaResponse = inventoryProductsHelpers.getProductArea(productId, selectedDate, selectedTime, quantity, "true");
    }


    @Test(dataProvider = DEFAULT_PROVIDER)
    public void verifyBookingTest(AppDriver app) {

        String inputMonthYear  = DateUtils.getDateFromDateTime("yyyyMMdd", "MMMM yyyy", selectedDate);
        String inputDate   = DateUtils.getDateFromDateTime("yyyyMMdd", "MMMM d, yyyy", selectedDate);
        String selectedTime = DateUtils.getTimeFromDateTime("yyyy-MM-dd'T'HH:mm:ss+SSSS", "HH:mm", date);
        SeatPlanningPage seatPlanningPage = app.start()
                .enterShow(showName)
                .clickFirstSearchResult()
                .clickFindTickets()
                .clickMonthSelector()
                .selectMonthYear(inputMonthYear)
                .selectDate(inputDate)
                .selectShowTime(selectedTime)
                .clickPickYourSeats();// Validating the each page when an object is created

                seatPlanningPage.selectSeat();
                seatPlanningPage.clickAddToBasket();
    }

    @Test(dataProvider = DEFAULT_PROVIDER)
    public void verifyBookingRestTest(AppDriver app) {

        String inputMonthYear  = DateUtils.getDateFromDateTime("yyyyMMdd", "MMMM yyyy", selectedDate);
        String inputDate   = DateUtils.getDateFromDateTime("yyyyMMdd", "MMMM d, yyyy", selectedDate);
        String selectedTime = DateUtils.getTimeFromDateTime("yyyy-MM-dd'T'HH:mm:ss+SSSS", "HH:mm", date);
        SeatPlanningPage seatPlanningPage = app.start()
                .enterShow(showName)
                .clickFirstSearchResult()
                .clickFindTickets()
                .clickMonthSelector()
                .selectMonthYear(inputMonthYear)
                .selectDate(inputDate)
                .selectShowTime(selectedTime)
                .clickPickYourSeats() ;// Validating the each page when an object is created

        seatPlanningPage.selectRestrictedSeat();
        boolean importantSeatSelectionDisplayed = seatPlanningPage.
                clickAddToBasket()
                .isImportantSeatInfoDisplayed();

        Assert.assertTrue(importantSeatSelectionDisplayed, " Import Seat info should be dispalyed for restricted view ");
    }


}
