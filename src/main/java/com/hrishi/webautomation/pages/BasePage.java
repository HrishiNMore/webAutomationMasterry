package com.hrishi.webautomation.pages;

import com.hrishi.webautomation.actions.ButtonAction;
import com.hrishi.webautomation.actions.TextBox;
import com.hrishi.webautomation.actions.WebActions;
import com.hrishi.webautomation.components.HeaderComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected WebDriver webDriver;
    protected ButtonAction buttonActions;
    protected TextBox textBox;
    protected WebActions webActions;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
        this.buttonActions=new ButtonAction(webDriver);
        this.textBox=new TextBox(webDriver);
        this.webActions=new WebActions(webDriver);
    }

    public HeaderComponent getHeader(){
        return new HeaderComponent(webDriver);
    }
}
