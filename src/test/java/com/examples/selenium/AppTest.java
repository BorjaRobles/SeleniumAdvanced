package com.examples.selenium;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest{
    WebDriver driver;
    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://github.com/kammavar");
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