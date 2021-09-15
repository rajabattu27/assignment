package com.encore.mobile.tests;

import com.mobile.framework.AppiumBaseTest;
import com.mobile.encore.screens.GetTicketsAtAPriceScreen;
import org.testng.annotations.Test;

public class EncoreMobileTests extends AppiumBaseTest {

	@Test
    public void verifyTicketBooking() {
        GetTicketsAtAPriceScreen getTicketsAtAPriceScreen = new GetTicketsAtAPriceScreen(this.driver);
        getTicketsAtAPriceScreen
                .clickNext()
                .clickNext()
                .clickNext()
                .clickSelectManually()
                .clickOnLocation("London")
                .clickContinueWithOutSignUp();
    }
}
