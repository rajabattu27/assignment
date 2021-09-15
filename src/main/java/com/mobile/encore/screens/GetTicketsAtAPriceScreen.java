package com.mobile.encore.screens;

import com.mobile.framework.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Screen class for Get Tickets At a Price Screen
 */
public class GetTicketsAtAPriceScreen extends BasePage {

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'title')]")
    private MobileElement titleLabel;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'next_button')]")
    private MobileElement nextButton;

    public GetTicketsAtAPriceScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public BookInAFewTapsScreen clickNext() {
        System.out.println("Clicking Next Button");
        wait.until(ExpectedConditions.visibilityOf(nextButton)).click();
        return new BookInAFewTapsScreen(driver);
    }

    @Override
    public void isPageValid() {
        System.out.println("Verifying Get Tickets At a Price Slider Screen");
        wait.until(ExpectedConditions.visibilityOf(titleLabel));
    }
}
