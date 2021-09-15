package com.mobile.encore.screens;

import com.mobile.framework.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * Screen class for Select Location Screen
 */
public class SelectLocationScreen extends BasePage {

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'title')]")
    private MobileElement titleLabel;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'location_text')]")
    private List<MobileElement> locationsList;

    public SelectLocationScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public JoinUsScreen clickOnLocation(String locationName) {
        System.out.println("Clicking Location - " + locationName);
        boolean locationExists = false;
        for (int i = 0; i < locationsList.size(); i++) {
            locationExists = wait.until(ExpectedConditions.visibilityOf(locationsList.get(i))).getText().equalsIgnoreCase(locationName);
            if (locationExists) {
                locationsList.get(i).click();
                break;
            }
        }
        if (!locationExists) {
            throw new RuntimeException("Location Name doesn't exist in the list of locations");
        }
        return new JoinUsScreen(driver);
    }

    @Override
    public void isPageValid() {
        System.out.println("Verifying Select Location Name Screen");
        wait.until(ExpectedConditions.visibilityOf(titleLabel));
    }
}
