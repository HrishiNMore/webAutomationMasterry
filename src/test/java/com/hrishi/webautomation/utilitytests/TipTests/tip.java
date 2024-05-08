package com.hrishi.webautomation.utilitytests.TipTests;

import com.hrishi.webautomation.BaseTest;
import com.hrishi.webautomation.Utility.ViewProducts;
import com.hrishi.webautomation.actions.SearchContent;
import com.hrishi.webautomation.components.SearchModal;
import com.hrishi.webautomation.components.TipComponant;
import com.hrishi.webautomation.modals.cartmodal;
import com.hrishi.webautomation.models.User;
import com.hrishi.webautomation.pages.BillingPage;
import com.hrishi.webautomation.pages.CartPage;
import com.hrishi.webautomation.pages.HomePage;
import com.hrishi.webautomation.pages.StorePage;
import com.hrishi.webautomation.pages.accounts.LoginPage;
import com.hrishi.webautomation.pages.accounts.ProfilePage;
import com.hrishi.webautomation.pages.accounts.ViewProPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class tip extends BaseTest {


    @Test
    public void test() throws InterruptedException {

        User user = User.builder().build().userWithValidCredentials();
        HomePage homePage = new HomePage(getWebDriver());
        LoginPage loginPage = homePage.getHeader().navToLoginPage();
        ProfilePage profilePage = loginPage.login(user);
        SearchContent searchContent = SearchContent.builder().build().init();
        SearchModal searchModal = homePage.getHeader().openSearchModal();
        searchModal.searchResult(searchContent.getInput());
        ViewProducts viewProduct = new ViewProducts(getWebDriver());
        ViewProPage viewProductPage = viewProduct.selectProduct();
        cartmodal cartPage = viewProductPage.buyproduct();
        Thread.sleep(5000);
        TipComponant t = new TipComponant(getWebDriver());
        t.clickontip();
        Thread.sleep(5000);
        double h = t.demo();
        double roundedH = Math.round(h * 100.0) / 100.0;
        double ip = t.result();
        System.out.println(roundedH + " " + ip);
        Assert.assertEquals(roundedH, ip);
    }

    @Test
    public void completeCheckOutProcess() throws InterruptedException {
        SearchContent searchContent= SearchContent.builder().build().init();
        User user= User.builder().build().userWithValidCredentials();
        HomePage homePage=new HomePage(getWebDriver());
        homePage.getHeader().navToLoginPage().login(user);
        homePage.getHeader().openSearchModal().searchResult(searchContent.getInput());
        ViewProducts viewProducts=new ViewProducts(getWebDriver());
        ViewProPage viewProductPage = viewProducts.selectProduct();
        CartPage cartPage = viewProductPage.addToCart().viewMyCartClick();
        BillingPage billingPage = cartPage.clickCheckOutBtn();
//        Thread.sleep(5000);
        String paymentText = billingPage.getPaymentText();
        Assert.assertTrue(paymentText.contains("Payment"));
        Assert.assertEquals(billingPage.autoTotalAmount(),billingPage.totalAmount());

    }
}
