package ru.netology;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MainScreen {

    @AndroidFindBy(id = "userInput")
    private MobileElement EditText;

    @AndroidFindBy (id = "buttonActivity")
    private MobileElement buttonActivity;

    @AndroidFindBy (id = "buttonChange")
    private MobileElement buttonChange;

    @AndroidFindBy (id = "text")
    private MobileElement TextView1;
    private AppiumDriver driver;
    private  MainScreen(AppiumDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);

    }
}
