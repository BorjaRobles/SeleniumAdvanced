package com.examples.selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

@Listeners(TestNGListener.class)
public class AppTest{
    private WebDriver driver;


    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","./src/test/resources/chrome/driver/chromedriver.exe");
        /*ChromeOptions profile = new ChromeOptions();
        profile.addArguments("user-data-dir=C:\\Users\\New\\SeleniumAdvanced\\src\\test\\resources\\Chrome\\profile\\");

        driver = new ChromeDriver(profile);*/

        driver = new ChromeDriver();
        driver.get("https://github.com/kammavar/");
    }

    @Test
    public void validateCookieInPC(){
        try{
            String actualTest = this.getClass().getName()+"."+  "validateCookieInPC";
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("target/screenshots/"+actualTest+".png"));
            String timezone = driver.manage().getCookieNamed("tz").getValue();
            Assert.assertTrue(timezone.contains("Berlin"));
        }
        catch(IOException e){
            System.out.println("Problem in file handling. Verify the screenshots file process.");
            e.printStackTrace();
        }

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}