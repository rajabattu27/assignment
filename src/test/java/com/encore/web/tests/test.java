package com.encore.web.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.awt.*;
import java.util.concurrent.TimeUnit;


public class test {

    public static WebDriver driver;

    private test(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    static String imagexpath = "//*[@id='chartContainer']/div";
    static String TicketSummary = "//div[@class='seat-summary__price o-seat-summary__price--per-ticket']/span";
    static String tooltip = "//*[@id=\"cursorTooltipContent\"]/div[1]/div[2]/div";
    static String restrictedView = "\"//li[text()='Restricted view']\"";
    static String yellow = "//*[@id=\"seat-plan-page\"]/div/main/div[1]/div/div/div/div[1]/div/div[2]/div[1]/span";

    public static void main(String[] args) throws InterruptedException, AWTException {
        // TODO Auto-generated method stub



        System.setProperty("webdriver.chrome.driver","src/test/drivers/chromedriver 8");
        driver = new ChromeDriver();
        // Entering the URL
        driver.get("https://www.encoretickets.co.uk/booking/seating-plan?product_id=6362&content_product_id=6362&product_type=show&performance_type=M&venue_id=112&qt=2&slot=19:00&date=2021-11-22&booking_ends=2022-06-26&booking_starts=2021-09-16");

        //driver.get("https://www.encoretickets.co.uk/booking/seating-plan?product_id=6362&content_product_id=6362&product_type=show&performance_type=E&venue_id=112&qt=1&slot=19:30&date=2021-09-24&booking_ends=2022-06-26&booking_starts=2021-09-17");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Thread.sleep(5000);
        int framecount = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Number of frames present : "+framecount);
        driver.switchTo().frame(0);
        Thread.sleep(3000);

        WebElement element = driver.findElement(By.xpath(imagexpath));

        if(element.isDisplayed()){
            String price = "48"	;
           // Actions actions = new Actions(driver);
           // actions.moveToElement(driver.findElement(By.xpath(imagexpath))).moveByOffset(0, 109).click().build().perform();
//           for (int x = 500 ;x < element.getSize().getWidth(); x++) {
//               for (int y =-400; y < element.getSize().getHeight(); y--) {
//
//                   actions.moveToElement(element).moveByOffset(x, y).click().build().perform();
//
//                   System.out.println("X and Y when condition satisified  are : " + x + " and " + y);
//                    //Thread.sleep(3000);
//                }
//            }
            selectSeat(price);
        }
        Thread.sleep(10000);

    }





    private static void selectSeat(String price) throws InterruptedException {

        Actions actions = new Actions(driver);
        switch(price){

            case "24" :

                actions.moveToElement(driver.findElement(By.xpath(imagexpath))).moveByOffset(0, 250).click().build().perform();
                Thread.sleep(5000);
               // System.out.println();
                //actions.moveToElement(driver.findElement(By.xpath(tooltip))).perform();
                actions.moveToElement(driver.findElement(By.xpath(imagexpath))).moveByOffset(-110,260).click().build().perform();
                Thread.sleep(3000);
                actions.moveToElement(driver.findElement(By.xpath(imagexpath))).moveByOffset(0, 0).click().build().perform();
                Thread.sleep(3000);
                driver.switchTo().parentFrame();
                Thread.sleep(3000);
                WebElement yellow = driver.findElement(By.xpath("//*[@id=\"seat-plan-page\"]/div/main/div[1]/div/div/div/div[1]/div/div[2]/div[1]/span"));
                String actualLowPrice = yellow.getText();

                String epectedLow = driver.findElement(By.xpath(TicketSummary)).getText();
                String epectedLowPrice = epectedLow.substring(15, 21);

                Assert.assertEquals(actualLowPrice,epectedLowPrice);
                System.out.println(epectedLowPrice + "  Bucks tickets have been selected !!");
                break;

            case "Restricted View" : actions.moveToElement(driver.findElement(By.xpath(imagexpath))).moveByOffset(0, 0).click().build().perform();
                Thread.sleep(5000);
                // System.out.println();
                //actions.moveToElement(driver.findElement(By.xpath(tooltip))).perform();
                actions.moveToElement(driver.findElement(By.xpath(imagexpath))).moveByOffset(-110,-148).click().build().perform();
                Thread.sleep(3000);
                actions.moveToElement(driver.findElement(By.xpath(imagexpath))).moveByOffset(0, 0).click().build().perform();
                Thread.sleep(3000);
                driver.switchTo().parentFrame();
                Thread.sleep(3000);
                WebElement actual = driver.findElement(By.xpath("//*[@id=\"seat-plan-page\"]/div/main/div[1]/div/div/div/div[1]/div/div[2]/div[2]/span"));
                String actualRestricted = actual.getText();

                String epectedRes = driver.findElement(By.xpath(TicketSummary)).getText();
                String epectedRestricted = epectedRes.substring(15, 21);
                Assert.assertEquals(actualRestricted,epectedRestricted);

                System.out.println(epectedRestricted + " Bucks tickets have been selected !!");
                break;

            case "60" :actions.moveToElement(driver.findElement(By.xpath(imagexpath))).moveByOffset(0, 109).click().build().perform();
                Thread.sleep(5000);
                actions.moveToElement(driver.findElement(By.xpath(imagexpath))).moveByOffset(150,160).click().build().perform();
                Thread.sleep(3000);
                driver.switchTo().parentFrame();
                Thread.sleep(3000);
                Assert.assertTrue(driver.findElement(By.xpath(TicketSummary)).getText().contains("60.00"));
                System.out.println("60 bucks tickets have been selected !!");
                Thread.sleep(5000);
                break;


            case "72" :actions.moveToElement(driver.findElement(By.xpath(imagexpath))).moveByOffset(0, 109).click().build().perform();
                Thread.sleep(5000);
                actions.moveToElement(driver.findElement(By.xpath(imagexpath))).moveByOffset(150,100).click().build().perform();
                Thread.sleep(3000);
                driver.switchTo().parentFrame();
                Thread.sleep(3000);
                Assert.assertTrue(driver.findElement(By.xpath(TicketSummary)).getText().contains("72.00"));
                System.out.println("72 bucks tickets have been selected !!");
                Thread.sleep(5000);
                break;


            case "90" :actions.moveToElement(driver.findElement(By.xpath(imagexpath))).moveByOffset(0, 50).click().build().perform();
                Thread.sleep(5000);
                actions.moveToElement(driver.findElement(By.xpath(imagexpath))).moveByOffset(-50, 110).click().build().perform();
                Thread.sleep(5000);
                Thread.sleep(3000);
                driver.switchTo().parentFrame();
                Thread.sleep(3000);
                Assert.assertTrue(driver.findElement(By.xpath(TicketSummary)).getText().contains("90.00"));
                System.out.println("90 bucks tickets have been selected !!");
                Thread.sleep(5000);
                break;


            case "114" :actions.moveToElement(driver.findElement(By.xpath(imagexpath))).moveByOffset(75, -150).click().build().perform();
                Thread.sleep(5000);
                actions.moveToElement(driver.findElement(By.xpath(imagexpath))).moveByOffset(-50,-180).click().build().perform();
                Thread.sleep(3000);
                driver.switchTo().parentFrame();
                Thread.sleep(3000);
                Assert.assertTrue(driver.findElement(By.xpath(TicketSummary)).getText().contains("114.00"));
                System.out.println("114 bucks tickets have been selected !!");
                Thread.sleep(5000);
                break;


            case "48" :actions.moveToElement(driver.findElement(By.xpath(imagexpath))).moveByOffset(0, 250).click().build().perform();
                Thread.sleep(5000);
                actions.moveToElement(driver.findElement(By.xpath(imagexpath))).moveByOffset(-110,165).click().build().perform();
                Thread.sleep(3000);
                driver.switchTo().parentFrame();
                Thread.sleep(3000);
                Assert.assertTrue(driver.findElement(By.xpath(TicketSummary)).getText().contains("48.00"));
                System.out.println("48 bucks tickets have been selected !!");
                Thread.sleep(5000);
                break;


        }

    }

}



