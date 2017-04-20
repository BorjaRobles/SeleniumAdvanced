package com.examples.selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.*;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Listeners(TestNGListener.class)
public class DockerGridTest {
        WebDriver driver;

        @BeforeTest
        public void setUp(){
                try{
                        DesiredCapabilities capabilities = new DesiredCapabilities();
                        capabilities.setBrowserName("chrome");
                        driver = new RemoteWebDriver( new URL("http://localhost:32768/wd/hub"), capabilities);

                        driver.get("http://www.lufthansa.com");
                        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                }
                catch(MalformedURLException e){
                        System.out.println("Invalid URL string specified for driver object. Make sure ip and port information are correct.");
                        e.printStackTrace();
                }
        }

        @Test
        public void verifyTitle() {
                try{
                	String actualTest = this.getClass().getName()+"."+  "verifyTitle";
                	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                	FileUtils.copyFile(scrFile, new File("target/screenshots/"+actualTest+".png"));
                	String title = driver.getTitle();
                	Assert.assertTrue(title.contains("Lufthansa"));
		}
		catch(IOException e){
			System.out.println("Problem in creating screenshot");
			e.printStackTrace();
		}
        }

        @AfterTest
        public void tearDown(){
                driver.close();
        }

}
