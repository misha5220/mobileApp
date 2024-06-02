package config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumConfig {

    public static AppiumDriver<MobileElement> driver;

    @BeforeSuite
    public void setUp() throws MalformedURLException {
/*
        {
            "platformName": "Android",
                "deviceName": "Pix6",
                "platformVersion": "11.0",
                "appPackage": "com.sheygam.contactapp",
                "appActivity": ".SplashActivity"
        }
*/
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability( "platformName", "Android");
        capabilities.setCapability( "deviceName", "Pix6");
        capabilities.setCapability( "platformVersion", "11.0");
        capabilities.setCapability( "appPackage", "com.sheygam.contactapp");
        capabilities.setCapability(  "appActivity", ".SplashActivity");

        capabilities.setCapability(MobileCapabilityType.APPLICATION_NAME, "Appium");
        capabilities.setCapability(MobileCapabilityType.APP,"/Users/michael/documents/apk/contacts-android.apk");
        driver=new AppiumDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
        driver.manage().timeouts()
                .implicitlyWait(5, TimeUnit.SECONDS);

    }


    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
}
