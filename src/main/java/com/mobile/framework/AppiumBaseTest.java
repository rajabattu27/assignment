package com.mobile.framework;

import java.net.MalformedURLException;
import java.net.URL;

import com.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumBaseTest {

    public AppiumDriver<MobileElement> driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", Configuration.DEVICE_NAME);
        capabilities.setCapability("platformVersion", Configuration.PLATFORM_VERSION);
        capabilities.setCapability("platformName", Configuration.PLATFORM_NAME);
        capabilities.setCapability("appPackage", Configuration.APP_PACKAGE);
        capabilities.setCapability("appActivity", Configuration.APP_ACTIVITY);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 180);
        setDriver(new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:" + "4723" + "/wd/hub"), capabilities));
    }

    @AfterMethod
    public void quit() {
        // close the app.
        getDriver().quit();
    }

    public AppiumDriver<MobileElement> getDriver() {
        return driver;
    }

    public void setDriver(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }
}