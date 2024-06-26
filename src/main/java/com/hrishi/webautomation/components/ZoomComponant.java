package com.hrishi.webautomation.components;

import com.hrishi.webautomation.actions.WebActions;
import com.hrishi.webautomation.pages.BasePage;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ZoomComponant extends WebActions {
    private int originalWidth, originalHeight, zoomedWidth, zoomedHeight;
    @FindBy(xpath = "//*[@id=\"shopify-section-template--15328405717213__main\"]/section/div/div[1]/slider-component/ul/li[1]/modal-opener/button")
    private WebElement productImage;

    public WebElement getProductImage() {
        return productImage;
    }

    public void zoomImageFunction(){
        this.productImage=productImage;
        originalWidth=productImage.getSize().getWidth();
        originalHeight=productImage.getSize().getHeight();
        productImage.click();
        zoomedWidth=productImage.getSize().getWidth();
        zoomedHeight=productImage.getSize().getHeight();
    }
    public ZoomComponant(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this); // Initialize page elements
    }

    public int getOriginalWidth() {
        return originalWidth;
    }

    public int getOriginalHeight() {
        return originalHeight;
    }

    public int getZoomedWidth() {
        return zoomedWidth;
    }

    public int getZoomedHeight() {
        return zoomedHeight;
    }
}
