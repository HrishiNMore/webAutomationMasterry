package com.hrishi.webautomation.pages;

import com.hrishi.webautomation.Utility.CartItemExtractor;
import com.hrishi.webautomation.models.cart;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage{
    CartItemExtractor cartItemExtractor=new CartItemExtractor(webDriver);

    @FindBy(xpath = "//*[@id=\"Remove-1\"]/a")
    private WebElement removeProductBtn;

    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement checkOutBtn;


    public void removeProduct(){
        buttonActions.click(removeProductBtn);
//        removeProductFromCart(    );
    }
    public void removeProductFromCart(String productName) {
        List<cart> cartItems = getDetails();
        for (int i = 0; i < cartItems.size(); i++) {
            cart cartItem = cartItems.get(i);
            if (cartItem.getProductName().equals(productName)) {
                cartItems.remove(i);
                break;
            }
        }
    }
    public List<cart> getDetails(){
        return cartItemExtractor.getCartDetails();
    }

    public List<String> getProductNames() {
        List<cart> cartItems = cartItemExtractor.getCartDetails();
        List<String> productNames = new ArrayList<>();
        for (cart cartItem : cartItems) {
            productNames.add(cartItem.getProductName());
        }
        return productNames;
    }

    public void printCartDetails() {
        List<cart> cartItems = cartItemExtractor.getCartDetails();
        System.out.println("Cart Details:");
        System.out.println("-------------");
        for (cart cartItem : cartItems) {
            System.out.println("Product Name: " + cartItem.getProductName());
            System.out.println("Size Info: " + cartItem.getSizeInfo());
            System.out.println("-------------");
        }
    }
    public String getCurrentURL(){
        return webDriver.getCurrentUrl();
    }

    public BillingPage clickCheckOutBtn(){
        buttonActions.click(checkOutBtn);
        return new BillingPage(webDriver);
    }
    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }
}
