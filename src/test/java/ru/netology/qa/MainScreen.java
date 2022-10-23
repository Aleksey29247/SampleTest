package ru.netology.qa;

import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_ACTIVITY;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_PACKAGE;
import static io.appium.java_client.remote.MobileCapabilityType.DEVICE_NAME;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.net.URL;
import java.time.Duration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MainScreen {
    public AppiumDriver driver;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/userInput")
    public MobileElement EditText;

    @AndroidFindBy(id = "buttonActivity")
    public MobileElement buttonActivity;

    @AndroidFindBy(id = "buttonChange")
    public MobileElement buttonChange;


    @AndroidFindBy(id = "text")
    public MobileElement TextView1;


    public MainScreen(AppiumDriver driver) {
        this.driver = driver;
        this.EditText = (MobileElement) this.driver.findElementById("ru.netology.testing.uiautomator:id/userInput");
        this.buttonChange = (MobileElement) this.driver.findElementById("ru.netology.testing.uiautomator:id/buttonChange");
        this.buttonActivity = (MobileElement) this.driver.findElementById("ru.netology.testing.uiautomator:id/buttonActivity");

    }

    public void setPage2() {
        this.TextView1 = (MobileElement) this.driver.findElementById("ru.netology.testing.uiautomator:id/text");
    }

}
