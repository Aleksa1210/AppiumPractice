package com.cydeo.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorTest {

    @Test
    public void initialTest() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities(); // unitilaze our object and send key and value

        //caps.setCapability("deviceName", "Pixel 3"); //"Pixel 3" name imileter another way sent capability
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        //this is where we are telling which application we are testing
        caps.setCapability(MobileCapabilityType.APP, "https://cybertek-appium.s3.amazonaws.com/calculator.apk"); // which application will test


        URL url = new URL("http://localhost:4723/wd/hub"); // run from local computer

        //Before setting the driver object we need set URL and Desired Capabilites
        AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(url,caps);
        Thread.sleep(600);
        MobileElement digit9 = driver.findElement(By.id("com.google.android.calculator:id/digit_9"));
        digit9.click();

        MobileElement clearElement = driver.findElement(MobileBy.AccessibilityId("clear"));
        clearElement.click();
        System.out.println("getText clear  " + clearElement.getText());
        Assertions.assertTrue(clearElement.isDisplayed());
        driver.closeApp();

    }
}
