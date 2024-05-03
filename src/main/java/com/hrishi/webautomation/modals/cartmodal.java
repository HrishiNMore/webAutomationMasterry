package com.hrishi.webautomation.modals;

import com.hrishi.webautomation.pages.BasePage;
import com.hrishi.webautomation.pages.CartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class cartmodal extends BasePage {
    @FindBy(xpath = "//*[@id=\"cart-notification-button\"]")
    private WebElement viewMyCart;

    public cartmodal(WebDriver webDriver) {
        super(webDriver);
    }

    public CartPage viewMyCartClick(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cart-notification\"]")));
        buttonActions.click(viewMyCart);
        return new CartPage(webDriver);
    }
}
