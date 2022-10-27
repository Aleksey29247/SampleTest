package ru.netology.qa;

import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_ACTIVITY;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_PACKAGE;
import static io.appium.java_client.remote.MobileCapabilityType.*;
import static org.junit.jupiter.api.TestInstance.Lifecycle;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

@TestInstance(Lifecycle.PER_CLASS)
public class Sample {


    private AndroidDriver driver;

    @BeforeAll
    public void createDriver() throws MalformedURLException {
        String platform = System.getProperty("platform");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(PLATFORM_NAME, "android");
        desiredCapabilities.setCapability(DEVICE_NAME, "any name");
        desiredCapabilities.setCapability(APP_PACKAGE, "ru.netology.testing.uiautomator");
        desiredCapabilities.setCapability(APP_ACTIVITY, "ru.netology.testing.uiautomator.MainActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

        driver.resetApp();

    }

    @Test
    public void testEmp() {
        MainScreen mainScreen = new MainScreen(driver);
        String str1 = " ";
        mainScreen.setEditText(" ");
        mainScreen.ClickButtonChange();
        String str = mainScreen.editTextGetText();
        Assertions.assertEquals(str1, str);
    }


    @Test
    public void enterText() throws InterruptedException {
        //проверка на ввод текста
        MainScreen mainScreen = new MainScreen(driver);
        mainScreen.setEditText("www");
        String str = mainScreen.editTextGetText();
        mainScreen.ClickButtonActive();
        TimeUnit.SECONDS.sleep(6);

        String str2 = mainScreen.textGetString();
        Assertions.assertEquals(str, str2);

    }

    @AfterAll
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}

