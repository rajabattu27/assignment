package com.mobile.framework;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
	protected AppiumDriver<MobileElement> driver;
	public WebDriverWait wait;

	protected BasePage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, 30);
	}

	/**
	 * Returns True, if Element is found else false
	 * 
	 * @param by
	 * @param waittime
	 * @return
	 */
	public boolean waitforVisibilityOfElement(By by, int waittime) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, waittime);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Returns True, if Element is found else false
	 * 
	 * @param by
	 * @return
	 * @throws Exception
	 */
	public void clickOnElement(By by) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			driver.findElement(by).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param by
	 * @param input
	 * @return
	 * @throws Exception
	 */
	public void enterText(By by, String input) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			driver.findElement(by).sendKeys(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public abstract void isPageValid();
}
