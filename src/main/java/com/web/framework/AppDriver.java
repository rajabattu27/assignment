package com.web.framework;

import com.Configuration;
import com.web.encore.pages.HomePage;
import com.web.utilities.DateUtils;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Abstract App Instance class to deal with all the driver related setup
 *
 */
@Log4j2
public abstract class AppDriver {

    protected WebDriver webDriver;

    private String testName;
    private String suiteName;
    private String logFilePath;

    public abstract HomePage start();

    /**
     * Configures the driver instance
     */
    protected void configureDriver() {
        log.info("Launching URL: " + Configuration.WEB_URL);
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Configuration.DEFAULT_IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
        getDriver().get(Configuration.WEB_URL);
    }

    /**
     * Creates the log folder with current test name and sets the Log file name
     * <p>
     * Note:
     * Below line adds a folder with Suite name under target/logs for more clear log structure. Will enable if needed
     * String logFilePath = getSuiteName() + File.separator + getTestName();
     */
    public void setLoggingProperties() {
        String baseLogFilePath = "target/logs";
        String logFolderName = getTestName();
        String logFileName = "app-execution-" + DateUtils.getCurrentTimeStamp() + ".log";
        ThreadContext.put("ROUTINGKEY", logFolderName);
        setLogFilePath(baseLogFilePath + File.separator + logFolderName + File.separator + logFileName);
        ThreadContext.put("LOGFILENAME", getLogFilePath());
        log.info("Test log for " + getTestName() + " is available at " + getLogFilePath());
    }


    protected WebDriver getDriver() {
        return webDriver;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getSuiteName() {
        return suiteName;
    }

    public void setSuiteName(String suiteName) {
        this.suiteName = suiteName;
    }

    public String getLogFilePath() {
        return logFilePath;
    }

    public void setLogFilePath(String logFilePath) {
        this.logFilePath = logFilePath;
    }
}
