package com.mobile.encore.screens;

import com.mobile.framework.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Screen class for Join Us Screen
 */
public class JoinUsScreen extends BasePage {

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'title')]")
    private MobileElement titleLabel;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'secondary_button')]")
    private MobileElement continueWithOutSignUpButton;

    public JoinUsScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public AllShowsScreen clickContinueWithOutSignUp() {
        System.out.println("Clicking continue With out SignUp Button");
        wait.until(ExpectedConditions.visibilityOf(continueWithOutSignUpButton)).click();
        return new AllShowsScreen(driver);
    }

    @Override
    public void isPageValid() {
        System.out.println("Verifying Select Location Name Screen");
        wait.until(ExpectedConditions.visibilityOf(titleLabel));
    }
}
