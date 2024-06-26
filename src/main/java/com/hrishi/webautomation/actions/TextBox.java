package com.hrishi.webautomation.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TextBox extends WebActions{
    public TextBox(WebDriver webDriver) {
        super(webDriver);
    }

    public void type(WebElement element,String input){
        webDriverWait.until(ExpectedConditions.visibilityOf(element)).sendKeys(input);
    }
}
