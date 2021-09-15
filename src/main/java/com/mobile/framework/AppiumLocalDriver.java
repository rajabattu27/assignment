package com.mobile.framework;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumLocalDriver {

	protected AppiumDriver<MobileElement> driver;

	@AfterMethod
	public void quit() {
		// close the app.
		getDriver().quit();
	}

	@BeforeMethod
	public void setUp() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Pixel 3a API 30");
		capabilities.setCapability("platformVersion", "11.0");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.todaytix.TodayTix");
		capabilities.setCapability("appActivity", "com.todaytix.TodayTix.activity.MainActivity");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 180);
		setDriver(new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:" + "4723" + "/wd/hub"), capabilities));
	}

	public AppiumDriver<MobileElement> getDriver() {
		return driver;
	}

	public void setDriver(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}
}