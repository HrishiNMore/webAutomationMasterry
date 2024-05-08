package com.hrishi.webautomation.utilitytests.contactformtests;

import com.hrishi.webautomation.BaseTest;
import com.hrishi.webautomation.models.FeedbackInput;
import com.hrishi.webautomation.pages.ContactPage;
import com.hrishi.webautomation.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ConctactFormTests extends BaseTest {
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

}
