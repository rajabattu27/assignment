package com.web.encore.pages;

import com.web.framework.AbstractBasePage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class contains all the elements and actions performed on HomePage
 */
@Log4j2
public class HomePage extends AbstractBasePage {

    @FindBy(css = "input[type='search']")
    private WebElement searchField;

    @FindBy(css = "div.c-quick-search__results li")
    private WebElement firstSearchResult;

    @FindBy(css = "button.c-quick-search__btn")
    private WebElement findTickets;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage enterShow(String showName) {
        log.info("Entering the Show or Attraction: " + showName);
        waitForVisibilityOfElement(searchField).sendKeys(showName);
        return this;
    }

    public HomePage clickFirstSearchResult() {
        log.info("Clicking First Search Result");
        waitForVisibilityOfElement(firstSearchResult);
        clickUsingJS(firstSearchResult);
        return this;
    }

    public ChooseADatePage clickFindTickets() {
        log.info("Clicking Find Tickets button");
        waitForVisibilityOfElement(findTickets).click();
        return new ChooseADatePage(driver);
    }

    @Override
    public void isOnPage() {
        log.info("Verifying Sign in page.");
        waitForVisibilityOfElement(searchField);
    }
}
