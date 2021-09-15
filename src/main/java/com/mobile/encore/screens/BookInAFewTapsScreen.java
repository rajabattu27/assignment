package com.mobile.encore.screens;

import com.mobile.framework.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Screen class for Book In a Taps Screen
 */
public class BookInAFewTapsScreen extends BasePage {

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'title')]")
    private MobileElement titleLabel;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'next_button')]")
    private MobileElement nextButton;

    public BookInAFewTapsScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public DealsThatSeemTooScreen clickNext() {
        System.out.println("Clicking Next Button");
        wait.until(ExpectedConditions.visibilityOf(nextButton)).click();
        return new DealsThatSeemTooScreen(driver);
    }

    @Override
    public void isPageValid() {
        System.out.println("Verifying Book In a Few Taps Screen");
        wait.until(ExpectedConditions.visibilityOf(titleLabel));
    }
}
