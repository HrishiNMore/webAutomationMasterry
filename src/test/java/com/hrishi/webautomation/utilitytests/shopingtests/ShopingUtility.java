package com.hrishi.webautomation.utilitytests.shopingtests;

import com.hrishi.webautomation.BaseTest;
import com.hrishi.webautomation.Utility.ViewProducts;
import com.hrishi.webautomation.actions.SearchContent;
import com.hrishi.webautomation.components.SearchModal;
import com.hrishi.webautomation.pages.CartPage;
import com.hrishi.webautomation.pages.HomePage;
import com.hrishi.webautomation.pages.accounts.ViewProPage;
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
    public void userIsAbleToAddProductAfterSearching()  {
        SearchContent searchContent= SearchContent.builder().build().init();
        HomePage homePage=new HomePage(getWebDriver());
        SearchModal searchModal = homePage.getHeader().openSearchModal();
        searchModal.searchResult(searchContent.getInput());
        ViewProducts viewProduct=new ViewProducts(getWebDriver());
        ViewProPage viewProductPage = viewProduct.selectProduct();
        CartPage cartPage = viewProductPage.addToCart().viewMyCartClick();
        cartPage.printCartDetails();
        List<String> productNames = cartPage.getProductNames();

        String productAdded = searchContent.selectDress();

        Assert.assertFalse(productNames.isEmpty());
        Assert.assertTrue(productNames.contains(productAdded));
    }

    @Test
    public void deleteProductFromCart(){
        SearchContent searchContent= SearchContent.builder().build().init();
        HomePage homePage=new HomePage(getWebDriver());
        SearchModal searchModal = homePage.getHeader().openSearchModal();
        searchModal.searchResult(searchContent.getInput());
        ViewProducts viewProduct=new ViewProducts(getWebDriver());
        ViewProPage viewProductPage = viewProduct.selectProduct();
        CartPage cartPage = viewProductPage.addToCart().viewMyCartClick();

    }
}
