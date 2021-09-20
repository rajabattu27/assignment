package com.web.framework;

import com.Configuration;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Abstract class contains all the common methods used in screen classes
 */
@Log4j2
public abstract class AbstractBasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(id = "activityModal")
    private WebElement loaderImg;

    By loaderImgEle = By.id("activityModal");

    public AbstractBasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Configuration.DEFAULT_EXPLICIT_TIMEOUT);
        PageFactory.initElements(driver, this);
        isOnPage();
    }

    protected WebElement waitForVisibilityOfElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement waitForElementClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement waitForVisibilityOfElement(WebElement element, int timeout) {
        return new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForInvisibilityOfLoader() {
        delay(500);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loaderImgEle));
    }

    protected void delay(long milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (Exception e) {

        }
    }

    protected void switchToLatestWindow() {
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            driver.switchTo().window(window);
        }
    }

    public WebElement getRandomElement(List<WebElement> elements) {
        Random random = new Random();
        return elements.get(random.nextInt(elements.size()));
    }

    public void selectByValue(WebElement selectElement, String selectByText) {
        Select select = new Select(selectElement);
        select.selectByVisibleText(selectByText);
    }

    public void clickUsingJS(WebElement webElement) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();", webElement);
    }

    public void sendKeysUsingJS(WebElement webElement, String value) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].value='" + value + "';", webElement);
    }

    public void Delay(long timeInMilli) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickUsingCoordinates(WebElement element, int xOffset, int yOffset) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).moveByOffset(xOffset, yOffset).click().build().perform();
    }

    /**
     * Every class should implement its own isOnPage which verifies the
     * screen is loaded.
     */
    public abstract void isOnPage();
}
