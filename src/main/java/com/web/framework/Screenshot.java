package com.web.framework;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshot {

    public static String capture(WebDriver driver, String screenShotName) throws IOException
    {
        //create a string variable which will be unique always
        String dateTime = new SimpleDateFormat("yyyyMMddhhss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String screenshotPath = "/target/ExtentReports/";
        //store the screen shot path in path variable. Here we are storing the screenshots under screenshots folder
        String path = System.getProperty("user.dir") + screenshotPath + screenShotName + dateTime + ".png";
        File destination = new File(path);
        FileUtils.copyFile(source, destination);
        return screenShotName + dateTime + ".png";
    }

}


