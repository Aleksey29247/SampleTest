package ru.netology.qa;

import io.appium.java_client.AppiumDriver;

import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;

import static ru.netology.qa.MainScreen.*;

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
        MainScreen mainScreen = new MainScreen(driver);
        //проверка на пустой текст buttonChange
        // MobileElement el1 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/userInput");
        String str1 = mainScreen.EditText.getText().toString();
        mainScreen.EditText.sendKeys("");
        // MobileElement el3 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/buttonChange");
        mainScreen.buttonChange.click();

        String str = mainScreen.EditText.getText(); //str =""
        Assertions.assertEquals(str1, str); //str
    }


    @Test
    public void enterText() throws InterruptedException {
        //проверка на ввод текста
        MainScreen mainScreen = new MainScreen(driver);
        // MobileElement el1 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/userInput");
        mainScreen.EditText.sendKeys("www");
        String str = mainScreen.EditText.getText();
        // MobileElement el3 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/buttonActivity");
        mainScreen.buttonActivity.click();
        //MobileElement el4 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/text");
        TimeUnit.SECONDS.sleep(6);
        mainScreen.setPage2();
        String str2 = mainScreen.TextView1.getText().toString();
        Assertions.assertEquals(str.toString(), str2.toString());

    }

    @AfterAll
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}

