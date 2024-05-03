package com.hrishi.webautomation.Utility;


import com.hrishi.webautomation.models.cart;
import com.hrishi.webautomation.pages.CartPage;

import java.util.List;

public class RemoveProductFromCart {
    private CartPage cartPage;

    public RemoveProductFromCart(CartPage cartPage) {
        this.cartPage = cartPage;
    }
    public void removeProductFromCart(String productName) {
        List<cart> cartItems = cartPage.getDetails();
        for (int i = 0; i < cartItems.size(); i++) {
            cart cartItem = cartItems.get(i);
            if (cartItem.getProductName().equals(productName)) {
                cartItems.remove(i);
                break;
            }
        }
    }
}
