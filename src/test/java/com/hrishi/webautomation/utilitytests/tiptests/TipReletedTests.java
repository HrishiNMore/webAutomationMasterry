package com.hrishi.webautomation.utilitytests.tiptests;

import com.hrishi.webautomation.BaseTest;
import com.hrishi.webautomation.functions.ViewProduct;
import com.hrishi.webautomation.actions.SearchContent;
import com.hrishi.webautomation.components.SearchModal;
import com.hrishi.webautomation.components.TipComponant;
import com.hrishi.webautomation.modals.Cartmodal;
import com.hrishi.webautomation.models.User;
import com.hrishi.webautomation.pages.BillingPage;
import com.hrishi.webautomation.pages.CartPage;
import com.hrishi.webautomation.pages.HomePage;
import com.hrishi.webautomation.pages.accounts.LoginPage;
import com.hrishi.webautomation.pages.accounts.ProfilePage;
import com.hrishi.webautomation.pages.accounts.ViewProPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TipReletedTests extends BaseTest {


    @Test
    public void UserShouldAbleToAddTipAndCheckingFinalTotals() throws InterruptedException {

        User user = User.builder().build().userWithValidCredentials();
        HomePage homePage = new HomePage(getWebDriver());
        LoginPage loginPage = homePage.getHeader().navToLoginPage();
        ProfilePage profilePage = loginPage.login(user);
        SearchContent searchContent = SearchContent.builder().build().init();
        SearchModal searchModal = homePage.getHeader().openSearchModal();
        searchModal.searchResult(searchContent.getInput());
        ViewProduct viewProduct = new ViewProduct(getWebDriver());
        ViewProPage viewProductPage = viewProduct.selectProduct();
        Cartmodal cartPage = viewProductPage.buyproduct();
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
        ViewProduct viewProducts=new ViewProduct(getWebDriver());
        ViewProPage viewProductPage = viewProducts.selectProduct();
        CartPage cartPage = viewProductPage.addToCart().viewMyCartClick();
        BillingPage billingPage = cartPage.clickCheckOutBtn();
//        Thread.sleep(5000);
        String paymentText = billingPage.getPaymentText();
        Assert.assertTrue(paymentText.contains("Payment"));
        Assert.assertEquals(billingPage.autoTotalAmount(),billingPage.totalAmount());

    }
    @Test
    public void defaultTip() throws InterruptedException {
        SearchContent searchContent= SearchContent.builder().build().init();
        User user= User.builder().build().userWithValidCredentials();
        HomePage homePage=new HomePage(getWebDriver());
        homePage.getHeader().navToLoginPage().login(user);
        homePage.getHeader().openSearchModal().searchResult(searchContent.getInput());
        ViewProduct viewProducts=new ViewProduct(getWebDriver());
        ViewProPage viewProductPage = viewProducts.selectProduct();
        CartPage cartPage = viewProductPage.addToCart().viewMyCartClick();
        BillingPage billingPage = cartPage.clickCheckOutBtn();
        Thread.sleep(5000);
        String paymentText = billingPage.getPaymentText();
        Assert.assertTrue(paymentText.contains("Payment"));
//        System.out.println(billingPage.tipAmount());
        System.out.println(billingPage.getSubTotal());
        System.out.println(billingPage.offer());
        System.out.println(billingPage.taxValue());
        System.out.println(billingPage.tipAmount());
        System.out.println(billingPage.totalAmount());
        System.out.println(billingPage.autoTotalAmount());
        Assert.assertEquals(billingPage.autoTotalAmount(),billingPage.totalAmount());

        billingPage.selectPayment();
        billingPage.completeOrder();

        String confirmationMessage = billingPage.getConfirmationMessage();
        Assert.assertTrue(confirmationMessage.contains("Your order is confirmed"));


    }
}
