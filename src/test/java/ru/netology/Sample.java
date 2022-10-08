package ru.netology.qa;

import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import ru.netology.qa.screens.MainScreen;

import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_ACTIVITY;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_PACKAGE;
import static io.appium.java_client.remote.IOSMobileCapabilityType.*;
import static io.appium.java_client.remote.MobileCapabilityType.*;
import static org.junit.jupiter.api.TestInstance.Lifecycle;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

@TestInstance(Lifecycle.PER_CLASS)
public class SampleTest {

    private AppiumDriver driver;

    @BeforeAll
    public void createDriver() throws MalformedURLException {
        String platform = System.getProperty("platform");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

            desiredCapabilities.setCapability(PLATFORM_NAME, "android");
            desiredCapabilities.setCapability(DEVICE_NAME, "any name");
            desiredCapabilities.setCapability(APP_PACKAGE, "ru.netology.testing.uiautomator");
            desiredCapabilities.setCapability(APP_ACTIVITY, "ru.netology.testing.uiautomator.MainActivity");
        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
    }

    @Test
    public void testEmp() {
       // MainScreen mainScreen = new MainScreen(driver);
        MobileElement el3 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/buttonChange");
        el3.click();
        MobileElement el1 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/textToBeChanged");

       Assertions.assertEquals("Hello UiAutomator!", el1.getText() );
    }
    @Test
    public void testTwo()
    {
        MobileElement el1 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/buttonActivity");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView");
        Assertions.assertEquals("UiAutomator", el2.getText() );
    }


    @AfterAll
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
package ru.netology.qa;

import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.netology.qa.screens.MainScreen;

import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_ACTIVITY;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_PACKAGE;
import static io.appium.java_client.remote.IOSMobileCapabilityType.*;
import static io.appium.java_client.remote.MobileCapabilityType.*;
import static org.junit.jupiter.api.TestInstance.Lifecycle;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;


@TestInstance(Lifecycle.PER_CLASS)
public class SempelTest {

    private AppiumDriver driver;

    @BeforeAll
    public void createDriver() throws MalformedURLException {
        String platform = System.getProperty("platform");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        if ("android".equals(platform)) {
            desiredCapabilities.setCapability(PLATFORM_NAME, "android");
            desiredCapabilities.setCapability(DEVICE_NAME, "any name");
            desiredCapabilities.setCapability(APP_PACKAGE, "ru.netology.testing.uiautomator");
            desiredCapabilities.setCapability(APP_ACTIVITY, "ru.netology.testing.uiautomator.");
        }  else {
            throw new IllegalArgumentException(String.format("Platform %s no supported", platform));
        }
        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
    }

    @Test
    public void testEmp() {
        MainScreen mainScreen = new MainScreen(driver);
		mainScreen.buttonChange.click();
        Assertions.assertEquals("Type something...", mainScreen.userInput.getText());
    }


    @AfterAll
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
