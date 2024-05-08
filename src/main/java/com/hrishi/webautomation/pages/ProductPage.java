package com.hrishi.webautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//*[@id=\"FacetsWrapperDesktop\"]/details[2]/summary/div/span")
    private WebElement filterPrice;


    @FindBy(xpath = "//*[@id=\"web-pixel-sandbox-CUSTOM-shopify-custom-pixel-LAX-bf0a1c21w381382fdp2197aec3mf9663592\"]>iframe")
    private WebElement mainFrame;

    //    public WebElement getMainFrame(){
//        return mainFrame;
//    }
    //span[contains(text(),'Rs. 100.00-Rs. 500.00')]
    public void clickFilterPrice(){
        filterPrice.click();

    }

}
