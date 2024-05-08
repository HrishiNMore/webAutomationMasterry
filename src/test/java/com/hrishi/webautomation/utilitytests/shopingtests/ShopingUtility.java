package com.hrishi.webautomation.utilitytests.shopingtests;

import com.hrishi.webautomation.BaseTest;

import com.hrishi.webautomation.actions.SearchContent;
import com.hrishi.webautomation.components.SearchModal;
import com.hrishi.webautomation.models.User;
import com.hrishi.webautomation.pages.CartPage;
import com.hrishi.webautomation.pages.HomePage;
import com.hrishi.webautomation.pages.accounts.ViewProPage;
import com.hrishi.webautomation.functions.ViewProduct;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ShopingUtility extends BaseTest {
    @Test
    public void userIsAbleToNavigateToStorePage() {
        HomePage homePage=new HomePage(getWebDriver());
        homePage.getHeader().navToStore();
    }

    @Test
    public void userIsAbleToNavigateToCartPage(){
        HomePage homePage=new HomePage(getWebDriver());
        CartPage cartPage = homePage.getHeader().navToCartPage();

        //assert
        Assert.assertTrue(cartPage.getCurrentURL().contains("https://web-playground.ultralesson.com/cart"));
    }

    @Test
    public void userIsAbleToAddProductAfterSearching() throws InterruptedException {
        SearchContent searchContent= SearchContent.builder().build().init();
        HomePage homePage=new HomePage(getWebDriver());
        SearchModal searchModal = homePage.getHeader().openSearchModal();
        searchModal.searchResult(searchContent.getInput());
        ViewProduct viewProduct=new ViewProduct(getWebDriver());
        ViewProPage viewProductPage = viewProduct.selectProduct();
        Thread.sleep(5000);
        CartPage cartPage = viewProductPage.addToCart().viewMyCartClick();
        cartPage.printCartDetails();
        List<String> productNames = cartPage.getProductNames();

        String productAdded = searchContent.selectDress();

        Assert.assertFalse(productNames.isEmpty());
        Assert.assertTrue(productNames.contains(productAdded));
    }

    @Test
    public void testCartPersistenceAcrossSessions() {
        // Step 1: Add products to the cart in one session
        SearchContent searchContent = SearchContent.builder().build().init();
        HomePage homePage = new HomePage(getWebDriver());
        User user= User.builder().build().userWithValidCredentials();
        homePage.getHeader().navToLoginPage().login(user);
        SearchModal searchModal = homePage.getHeader().openSearchModal();
        searchModal.searchResult(searchContent.getInput());
        ViewProduct viewProduct = new ViewProduct(getWebDriver());
        ViewProPage viewProductPage = viewProduct.selectProduct();
        CartPage cartPage = viewProductPage.addToCart().viewMyCartClick();
        List<String> productNames = cartPage.getProductNames();

        //Log out
        homePage.getHeader().navToProfilePage().logOut();

        //Log back in
        homePage.getHeader().navToLoginPage().login(user);

        //Assert
        CartPage loggedInCartPage = new HomePage(getWebDriver()).getHeader().navToCartPage();
        List<String> loggedInProductNames = loggedInCartPage.getProductNames();
        Assert.assertTrue(loggedInProductNames.containsAll(productNames));
    }
    @Test
    public void deleteProductFromCart(){
        SearchContent searchContent= SearchContent.builder().build().init();
        HomePage homePage=new HomePage(getWebDriver());
        SearchModal searchModal = homePage.getHeader().openSearchModal();
        searchModal.searchResult(searchContent.getInput());
        ViewProduct viewProduct=new ViewProduct(getWebDriver());
        ViewProPage viewProductPage = viewProduct.selectProduct();
        CartPage cartPage = viewProductPage.addToCart().viewMyCartClick();

    }
}
