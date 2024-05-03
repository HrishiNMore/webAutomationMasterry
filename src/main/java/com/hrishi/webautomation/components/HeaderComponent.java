package com.hrishi.webautomation.components;

import com.hrishi.webautomation.actions.ButtonAction;
import com.hrishi.webautomation.pages.*;
import com.hrishi.webautomation.pages.accounts.LoginPage;
import com.hrishi.webautomation.pages.accounts.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderComponent extends BasePage {

    @FindBy(xpath = "//*[@id=\"shopify-section-header\"]/sticky-header/header/h1/a/span")
    private WebElement logo;

    @FindBy(xpath = "//*[@id=\"shopify-section-header\"]/sticky-header/header/nav/ul/li[1]/a")
    private WebElement homeBtnEle;

    @FindBy(xpath = "//*[@id=\"shopify-section-header\"]/sticky-header/header/nav/ul/li[2]/a/span")
    private WebElement storeBtnEle;

    @FindBy(xpath = "//*[@id=\"shopify-section-header\"]/sticky-header/header/nav/ul/li[3]/a")
    private WebElement contactBtnEle;

    @FindBy(xpath = "//*[@id=\"shopify-section-header\"]/sticky-header/header/div/details-modal/details/summary/span")
    private WebElement searchIconEle;

    @FindBy(xpath = "//*[@id=\"shopify-section-header\"]/sticky-header/header/div/a[1]")
    private WebElement profileBtnEle;

    @FindBy(xpath = "//*[@id=\"cart-icon-bubble\"]")
    private WebElement cartBtnEle;

    @FindBy(xpath = "//*[@id=\"FacetsWrapperDesktop\"]/details[1]/summary")
    private WebElement avalBtnEle;

    @FindBy(xpath = "//*[@id=\"product-grid\"]/ul/li[1]/div/div[1]/div/h3/a")
    private WebElement picture;

    @FindBy(xpath = "//*[@id=\"product-form-template--15328405717213__main\"]/div/button/span")
    private WebElement addToCartEle;
    @FindBy(xpath = "//*[@id=\"cart-notification-button\"]")
    private WebElement viewMyCart;

    @FindBy(xpath = "//*[@id=\"CartItem-1\"]/td[2]/a")
    private WebElement cartTextEle;

    public HeaderComponent(WebDriver webDriver) {
        super(webDriver);
        this.buttonActions=new ButtonAction(webDriver);
    }

    public HomePage navToHomePageUsingLogo(){
        buttonActions.click(logo);
        return new HomePage(webDriver);
    }

    public HomePage navToHomePageUsingHomeButton(){
        buttonActions.click(homeBtnEle);
        return new HomePage(webDriver);
    }

    public StorePage navToStore(){
        buttonActions.click(storeBtnEle);
        return new StorePage(webDriver);
    }

    public StorePage navToAvil(){
        buttonActions.click(avalBtnEle);
        return new StorePage(webDriver);
    }

    public ContactPage navToContactPage(){
        buttonActions.click(contactBtnEle);
        return new ContactPage(webDriver);
    }

    public SearchModal openSearchModal(){
        buttonActions.click(searchIconEle);
        return new SearchModal(webDriver);
    }

    public LoginPage navToLoginPage(){
        buttonActions.click(profileBtnEle);
        return new LoginPage(webDriver);
    }

    public ProfilePage navToProfilePage(){
        buttonActions.click(profileBtnEle);
        return new ProfilePage(webDriver);
    }

    public CartPage navToCartPage(){
        buttonActions.click(cartBtnEle);
        return new CartPage(webDriver);
    }

    public SerchPage navTopicture(){
        buttonActions.click(picture);
        return new SerchPage(webDriver);
    }
    public SerchPage navToAddCart(){
        buttonActions.click(addToCartEle);
        return new SerchPage(webDriver);
    }

    public SerchPage navToViewCart(){
        buttonActions.click(viewMyCart);
        return new SerchPage(webDriver);
    }
    public String navToTextCart(){
        return  webActions.getText(cartTextEle);
    }

}
