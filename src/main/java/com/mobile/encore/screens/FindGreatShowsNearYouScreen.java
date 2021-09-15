package com.mobile.encore.screens;

import com.mobile.framework.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Screen class for Find Great Shows Near You Screen
 */
public class FindGreatShowsNearYouScreen extends BasePage {
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'title')]")
    private MobileElement titleLabel;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'secondary_button')]")
    private MobileElement selectManuallyButton;

    public FindGreatShowsNearYouScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public SelectLocationScreen clickSelectManually() {
        System.out.println("Clicking on Select Manually Button");
        wait.until(ExpectedConditions.visibilityOf(selectManuallyButton)).click();
        return new SelectLocationScreen(driver);
    }

    @Override
    public void isPageValid() {
        System.out.println("Verifying Find Great Shows Near you Screen");
        wait.until(ExpectedConditions.visibilityOf(titleLabel));
    }
}
