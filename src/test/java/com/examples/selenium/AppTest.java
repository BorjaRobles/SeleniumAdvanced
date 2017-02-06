package com.examples.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest{
    private WebDriver driver;

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","./src/test/resources/chrome/driver/chromedriver.exe");
        ChromeOptions profile = new ChromeOptions();
        profile.addArguments("user-data-dir=C:\\Users\\New\\SeleniumAdvanced\\src\\test\\resources\\Chrome\\profile\\");

        driver = new ChromeDriver(profile);
        driver.get("https://github.com/kammavar/");
    }

    @Test
    public void validateCookie(){
        String timezone = driver.manage().getCookieNamed("tz").getValue();
        System.out.println(timezone);
        Assert.assertTrue(timezone.contains("Berlin"));
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}