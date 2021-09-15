package com.web.encore.pages;

import com.web.framework.AbstractBasePage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Log4j2
public class ChooseADatePage extends AbstractBasePage {

    @FindBy(css = "span.month-selector-navigation__month")
    private WebElement monthSelector;

    @FindBy(css = "div.month-selector__option")
    private List<WebElement> monthOptions;

    @FindBy(css = "div.dayContainer span.flatpickr-day")
    private List<WebElement> calendarDays;

    @FindBy(xpath = "//span[text()='Pick your seats']/../..")
    private WebElement pickYourSeatsButton;

    @FindBy(css = "span.c-quick-search__timeslot-time")
    private List<WebElement> timeSlot;


    public ChooseADatePage(WebDriver driver) {
        super(driver);
    }

    public ChooseADatePage clickMonthSelector() {
        log.info("Clicking Month Selector button");
        waitForVisibilityOfElement(monthSelector).click();
        return this;
    }

    public ChooseADatePage selectMonthYear(String date) {
        log.info("Selecting the Month and Year: " + date);
        for (WebElement e : monthOptions) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
        return this;
    }

    public ChooseADatePage selectDate(String date) {
        log.info("Selecting the date: " + date);
        Delay(3000);
        for (WebElement e : calendarDays) {
            if (e.getAttribute("aria-label").equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
        return this;
    }

    public SeatPlanningPage clickPickYourSeats() {
        log.info("Clicking Pick Your Seats button");
        waitForVisibilityOfElement(pickYourSeatsButton).click();
        return new SeatPlanningPage(driver);
    }

    public ChooseADatePage selectShowTime(String showTime) {
        log.info("Selecting the show time: " + showTime);
        for (WebElement e : timeSlot) {
            if (e.getText().equalsIgnoreCase(showTime)) {
                e.click();
                break;
            }
        }
        return this;
    }

    @Override
    public void isOnPage() {
        log.info("Verifying Choose a date page.");
        waitForVisibilityOfElement(monthSelector);
    }
}
