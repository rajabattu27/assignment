package com.web.encore.pages;

import com.web.framework.AbstractBasePage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Log4j2
public class SeatPlanningPage extends AbstractBasePage {

    @FindBy(id = "seat-plan-page")
    private WebElement selectedFloor;

    public SeatPlanningPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isOnPage() {
        log.info("Verifying Seat planning Page");
        waitForVisibilityOfElement(selectedFloor);
    }
}
