package com.examples.selenium;

import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.MobileElement;
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
public class MobileTest {
        AppiumDriver<MobileElement> driver;

        @BeforeTest
        public void setUp(){
                try{
                        DesiredCapabilities capabilities = new DesiredCapabilities();
                        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "LENNY");
                        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.CHROME);
                        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
                        //you are free to set additional capabilities
                        driver = new AndroidDriver<MobileElement>( new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

                        driver.get("https://github.com/kammavar/");
                        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                }
                catch(MalformedURLException e){
                        System.out.println("Invalid URL string specified for driver object. Make sure ip and port information are correct.");
                        e.printStackTrace();
                }
        }

        @Test
        public void validateCookieInMobile() {
                try{
                        String actualTest = this.getClass().getName()+"."+  "validateCookieInMobile";
                        File scrFile = driver.getScreenshotAs(OutputType.FILE);
                        FileUtils.copyFile(scrFile, new File("target/screenshots/"+actualTest+".png"));
                        String timezone = driver.manage().getCookieNamed("tz").getValue();
                        Assert.assertTrue(timezone.contains("CET"));
                }
                catch(IOException e){
                        System.out.println("Problem taking screenshots. ");
                        e.printStackTrace();
                }

        }

        @AfterTest
        public void tearDown(){
                driver.quit();
        }

}