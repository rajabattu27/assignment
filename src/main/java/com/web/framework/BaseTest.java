package com.web.framework;

import com.aventstack.extentreports.MediaEntityBuilder;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

import static com.web.framework.ExtentConfig.*;



/**
 * Class contains the Pre-requisite setup before running a Test Case
 *
 */
@Log4j2
public class BaseTest {

    protected ThreadLocal<AppDriver> appInstance = new ThreadLocal<>();
    protected static final String DEFAULT_PROVIDER = "defaultConfig";

    @BeforeTest
    public void beforeTest(ITestContext iTestContext) {
       // getExtentParent().set(getExtentReport().createTest(iTestContext.getName()));
    }

    @BeforeMethod
    public void beforeMethodTestBase(ITestContext iTestContext, Method method, Object[] params) {
        if (params.length > 0 && params[0] instanceof AppDriver) {
            appInstance.set((AppDriver) params[0]);
        }
        getAppInstance().setTestName(method.getName());
        getAppInstance().setSuiteName(iTestContext.getCurrentXmlTest().getSuite().getName());
        getAppInstance().setLoggingProperties();
        getExtentParent().set(getExtentReport().createTest(method.getName()));
      //  getExtentChild().set(getExtentParent().get().createNode(method.getName()));
        log.info("beforeMethodTestBase() called");
    }

    @DataProvider(name = DEFAULT_PROVIDER)
    public Object[][] defaultProvider(Method beforeMethod) {

            return new Object[][]{{
                    new LocalDriver()}
            };
    }

    @AfterTest
    protected void afterSuite() {
        getExtentReport().flush();
    }

    @AfterMethod
    protected void afterMethod(ITestResult iTestResult) throws IOException {
        log.info("afterMethodTestBase() called");
        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            String path = Screenshot.capture(getDriver(), iTestResult.getName());
            getExtentParent().get().fail( iTestResult.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());
         //   getExtentChild().get().fail( iTestResult.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());
        }
        getDriver().quit();
        log.info("Test log for " + getAppInstance().getTestName() + " is available at " + getAppInstance().getLogFilePath());
    }


    private AppDriver getAppInstance() {
        return appInstance.get();
    }

    protected WebDriver getDriver() {
        return getAppInstance().getDriver();
    }
}
