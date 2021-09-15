package com.web.framework;

import com.Configuration;
import com.web.encore.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Class Contains local driver setup
 *
 */
@Log4j2
public class LocalDriver extends AppDriver {

    private void initializeDriver() {
        String browser = Configuration.LOCAL_BROWSER;
        log.info("Initializing browser: " + browser);
        if ("chrome".equalsIgnoreCase(browser)) {
            initializeChrome();
        } else {
            throw new RuntimeException("Invalid Browser Input. Valid Browsers are chrome, firefox, edge");
        }
    }

    private void initializeChrome() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }

    @Override
    public HomePage start() {
        initializeDriver();
        configureDriver();
        return new HomePage(getDriver());
    }
}
