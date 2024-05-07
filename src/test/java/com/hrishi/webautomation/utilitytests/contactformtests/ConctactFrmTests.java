package com.hrishi.webautomation.utilitytests.contactformtests;

import com.hrishi.webautomation.BaseTest;
import com.hrishi.webautomation.components.HeaderComponent;
import com.hrishi.webautomation.modals.ProductList;
import com.hrishi.webautomation.models.FeedbackInput;
import com.hrishi.webautomation.pages.ContactPage;
import com.hrishi.webautomation.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ConctactFrmTests extends BaseTest {
    @Test
    public void userIsAbleToOpenContactPage(){
        HomePage homePage=new HomePage(getWebDriver());
        homePage.getHeader().navToContactPage();
        ContactPage contactPage=new ContactPage(getWebDriver());
        String contactHeading = contactPage.getContactHeading();

        Assert.assertTrue(contactHeading.contains("Contact"));
    }

    @Test
    public void userIsAbleToSubmitContactFormWithValidData()  {
        FeedbackInput feedBack=FeedbackInput.builder().build().validDetails();
        HomePage homePage=new HomePage(getWebDriver());
        homePage.getHeader().navToContactPage();
        ContactPage contactPage=new ContactPage(getWebDriver());
        contactPage.sendFeedback(feedBack);
        String successMessage = contactPage.getSuccessMessage();
        System.out.println(successMessage);
        Assert.assertTrue(successMessage.contains("Thanks for contacting us. We'll get back to you as soon as possible."));
    }
    @Test
    public void userIsAbleToSubmitContactFormWithInValidData() {
        FeedbackInput feedBack=FeedbackInput.builder().build().inValidDetails();
        HomePage homePage=new HomePage(getWebDriver());
        homePage.getHeader().navToContactPage();
        ContactPage contactPage=new ContactPage(getWebDriver());
        contactPage.sendFeedback(feedBack);
        String successMessage = contactPage.getSuccessMessage();
        System.out.println(successMessage);
        Assert.assertTrue(successMessage.contains("Thanks for contacting us. We'll get back to you as soon as possible."));
    }


    @Test
    public void UserShouldAbleToFilterProductBasedonInStockAndOutofStock () {
        HeaderComponent headerComponent=new HeaderComponent(getWebDriver());
        ProductList p=new ProductList(getWebDriver());
        String text = p.printGridItemsInStock();
        System.out.println(text);
         String act=headerComponent.actext();
         System.out.println(act);
        Assert.assertTrue(text.contains(act));
    }

    @Test
    public void UserShouldAbleToFilterInStockProduct (){
        ProductList p=new ProductList(getWebDriver());
        String text=p.filterInStockProduct();
        String web=p.getAddToCart();
        Assert.assertTrue(text.contains(web));
    }
    @Test
    public void UserShouldAbleToFilterOutOfStockProduct (){
        ProductList p=new ProductList(getWebDriver());
        String text=p.filterOutOfStockProduct();
        String web=p.getSoldOut();
        Assert.assertTrue(text.contains(web));
    }

    @Test
    public void UserShouldAbleToFilterByprice (){
        ProductList p=new ProductList(getWebDriver());
        String text=p.printGridPrice();
        System.out.println(text);

    }
}
