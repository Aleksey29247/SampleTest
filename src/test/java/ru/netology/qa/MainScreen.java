package ru.netology.qa;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;

public class MainScreen {
    private AndroidDriver driver;

    @AndroidFindBy(id = "userInput")
    private AndroidElement EditText;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/buttonActivity")
    private AndroidElement buttonActivity;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/buttonChange")
    private AndroidElement buttonChange;


    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/text")
    private AndroidElement TextView1;


    public MainScreen(AndroidDriver appiumDriver) {
        this.driver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void ClickButtonChange() {
        buttonChange.click();
    }


    public String editTextGetText() {
        return EditText.getText().toString();
    }

    public void setEditText(String text) {
        EditText.sendKeys(text);
    }


    public void ClickButtonActive() {
        buttonActivity.click();
    }

    public String textGetString() {
        return TextView1.getText().toString();
    }
}
