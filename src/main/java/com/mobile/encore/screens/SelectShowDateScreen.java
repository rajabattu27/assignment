package com.mobile.encore.screens;

import com.mobile.framework.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

/**
 * Screen class for All Shows Screen
 */
public class SelectShowDateScreen extends BasePage {

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'title')]")
    private MobileElement titleLabel;



    public SelectShowDateScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }


    public void selectDatePrice(){

        try {

            Dimension diamension = driver.manage().window().getSize();
            int start_x = (int) (diamension.width * 0.5);
            int start_y = (int) (diamension.height * 0.8);

            int end_x = (int) (diamension.width * 0.2);
            int end_y = (int) (diamension.height * 0.2);

            TouchAction touch = new TouchAction(driver);
            //new TouchAction(driver).press(PointOption.point(start_x, start_y)).moveTo(PointOption.point(end_x, end_y).release().perform();

            new TouchAction(driver).press(PointOption.point(747, 1849)).moveTo(PointOption.point(727, 878)).release().perform();
            Delay(3000);
            driver.findElement(By.xpath("//*[@text='30']")).click();
            Delay(3000);
            driver.findElement(By.xpath("//*[@text='From £28']")).click();
            Screen s149 = new Screen();
            Delay(7000);
            new TouchAction(driver).press(PointOption.point(484, 1981)).release().perform();
            Delay(3000);
            Pattern fare_28 = new Pattern("src\\main\\resources\\fare_28.PNG");
            //s.find("D:\\AmlanStuff\\Projects\\TestMaven\\Image1.PNG");
            //s.wait(10);
            // s.click("D:\\AmlanStuff\\Projects\\TestMaven\\Image1.PNG");
            s149.wait(fare_28);
            s149.click(fare_28);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    public void isPageValid() {
        System.out.println("Verifying Select Show Date Screen");
        wait.until(ExpectedConditions.visibilityOf(titleLabel));
    }
}
