package com.web.encore.pages;

import com.web.framework.AbstractBasePage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class BasketPage extends AbstractBasePage {

    @FindBy(css =  "h1.o-title")
    private WebElement basketPage;



    @FindBy(css =  "span.seat-info__link-text")
    private WebElement seatInfo;

    public BasketPage(WebDriver driver) {
        super(driver);
    }


    public boolean isImportantSeatInfoDisplayed() {
        try {
            waitForVisibilityOfElement(seatInfo);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void isOnPage() {
        log.info("Verifying the basket Page");
        waitForVisibilityOfElement(basketPage);
    }
}
