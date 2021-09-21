package com.web.encore.pages;

import com.web.framework.AbstractBasePage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

@Log4j2
public class SeatPlanningPage extends AbstractBasePage {

    @FindBy(id = "seat-plan-page")
    private WebElement selectedFloor;

    @FindBy(css = "span.c-seat-plan-legend__details-price")
    private WebElement seatPrice;

    @FindBy(xpath = "//*[@id='chartContainer']/div")
    private WebElement seatPriceImage;

    @FindBy(xpath = "//*[@id=\"visibleArea\"]")
    private WebElement seatVisibleArea;

    @FindBy(css = "span.c-seat-plan-legend__details-price")
    private WebElement lowestPriceTicket;

    @FindBy(xpath = "//*[@id=\"seat-plan-page\"]/div/main/div[1]/div/div/div/div[1]/div/div[2]/div[2]/span")
    private WebElement restViewPriceTicket;

    @FindBy(xpath = "//div[@class='seat-summary__price o-seat-summary__price--per-ticket']/span")
    private WebElement ticketSummary;

    @FindBy(xpath = "//span[text()='Add to Basket']/..")
    private WebElement addToBasket;





    public SeatPlanningPage(WebDriver driver) {
        super(driver);
    }

    public String getLowestSeatPrice() {
        return seatPrice.getText();
    }

    public BasketPage clickAddToBasket() {
        log.info("Clicking add to Basket");
        waitForVisibilityOfElement(addToBasket);
        addToBasket.click();
        return new BasketPage(driver);
    }


    public void selectSeat(){
      //  waitForVisibilityOfElement(driver.findElement(By.tagName("iframe")));
        int framecount = driver.findElements(By.tagName("iframe")).size();
       // waitForVisibilityOfElement(driver.findElement(By.tagName("iframe")));
        log.info("Number of frames present : "+framecount);
        if(framecount>1){

            driver.switchTo().frame(0);
            Delay(5000);

            Actions actions = new Actions(driver);
            clickUsingCoordinates(seatVisibleArea, 0, 250);
            Delay(5000);
            clickUsingCoordinates(seatVisibleArea, -80, 230);
            driver.switchTo().parentFrame();
            Delay(3000);
            String actualLowPrice = lowestPriceTicket.getText();
            String epectedLow = ticketSummary.getText();
            String epectedLowPrice = epectedLow.substring(15, 21);

            Assert.assertEquals(actualLowPrice,epectedLowPrice);
            log.info(epectedLowPrice + "  Bucks tickets have been selected !!");

        }
        else {
            log.info("Page not loaded properly");
            Assert.fail("Page not loaded properly");
        }

    }

    public void selectRestrictedSeat(){
       // waitForVisibilityOfElement(driver.findElement(By.tagName("iframe")));
        int framecount = driver.findElements(By.tagName("iframe")).size();
        log.info("Number of frames present : "+framecount);
        driver.switchTo().frame(0);
        Delay(5000);
        Actions actions = new Actions(driver);
        clickUsingCoordinates(seatVisibleArea, 0, 0);
        Delay(5000);
        clickUsingCoordinates(seatVisibleArea, -110, -148);
        driver.switchTo().parentFrame();
        Delay(3000);
        String actualLowPrice = restViewPriceTicket.getText();
        String epectedLow = ticketSummary.getText();
        String epectedLowPrice = epectedLow.substring(15, 21);

        Assert.assertEquals(actualLowPrice,epectedLowPrice);
        log.info(epectedLowPrice + "  Bucks tickets have been selected !!");

    }

    @Override
    public void isOnPage() {
        log.info("Verifying Seat planning Page");
        waitForVisibilityOfElement(selectedFloor);
    }
}
