package com.hrishi.webautomation.pages.accounts;

import com.hrishi.webautomation.modals.cartmodal;
import com.hrishi.webautomation.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ViewProPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"ProductInfo-template--15328405717213__main\"]/p[1]")
    private WebElement seller;

    @FindBy(className = "product__title")
    private WebElement productTitle;

    private WebElement selectedRadio = null;
    List<WebElement> sizeRadioButtons = webDriver.findElements(By.name("Size"));

    public String getSizeSelected() {
        for (WebElement i : sizeRadioButtons) {
            if (i.isSelected()) {
                selectedRadio = i;
                return i.getAttribute("value");
            }
        }
        return null;
    }

    private WebElement colorSelected=null;
    List<WebElement> colorRadioButtons=webDriver.findElements(By.name("Color"));

    public String getColorSelected(){
        for(WebElement i: colorRadioButtons){
            if(i.isSelected()){
                colorSelected=i;
                return i.getAttribute("value");
            }
        }
        return null;
    }

    @FindBy(xpath = "//*[@id=\"product-form-template--15328405717213__main\"]/div/button")
    private WebElement addToCartBtn;

    public cartmodal addToCart(){
        buttonActions.click(addToCartBtn);

        return new cartmodal(webDriver);
    }
    //*[@id="product-form-template--15328405717213__main"]/div/div/dynamic-checkout/div/shopify-buy-it-now-button/button

    @FindBy(xpath = "//*[@id=\"product-form-template--15328405717213__main\"]/div/div/dynamic-checkout/div/shopify-buy-it-now-button/button")
    private WebElement byProductBtn;

    public cartmodal buyproduct(){
        buttonActions.click(byProductBtn);

        return new cartmodal(webDriver);
    }
    public ViewProPage(WebDriver webDriver) {
        super(webDriver);
    }
}
