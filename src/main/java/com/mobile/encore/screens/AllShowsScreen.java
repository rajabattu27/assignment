package com.mobile.encore.screens;

import com.mobile.framework.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Screen class for All Shows Screen
 */
public class AllShowsScreen extends BasePage {

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'title')]")
    private MobileElement titleLabel;



    public AllShowsScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public SelectShowDateScreen selectShowMammaMia() {

        MobileElement MammaMia = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().textContains(\"Mamma Mia!\"))"));

        MammaMia.click();

        return new SelectShowDateScreen(driver);
    }

    @Override
    public void isPageValid() {
        System.out.println("Verifying All Shows Screen");
        wait.until(ExpectedConditions.visibilityOf(titleLabel));
    }
}
