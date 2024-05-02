package com.hrishi.webautomation.utilitytests;

import com.hrishi.webautomation.BaseTest;
import com.hrishi.webautomation.models.User;
import com.hrishi.webautomation.pages.HomePage;
import com.hrishi.webautomation.pages.accounts.LoginPage;
import com.hrishi.webautomation.pages.accounts.ProfilePage;
import com.hrishi.webautomation.pages.accounts.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationPageTest extends BaseTest{
    @Test(testName = "New User Registration",description = "User is able to Register on the website")
    public void userIsAbleToRegister(){
        //arrange
        User user= User.builder().build().init();
        HomePage homePage=new HomePage(getWebDriver());
        LoginPage loginPage = homePage.getHeader().navToLoginPage();

        //act
        loginPage.navToRegisterationPage().createAccount(user);
        ProfilePage profilePage = homePage.getHeader().navToProfilePage();

        //assert
        String accountDetails= profilePage.getAccountDetails();
        Assert.assertTrue(accountDetails.contains(user.getFirst_name()));
    }

    @Test(testName = "Email ID Complusory for Registration")
    public void verifyThatUserIsNotAbleToRegisterWithEmptyEmail(){
        //arrange
        User user= User.builder().build().userWithoutEmail();
        HomePage homePage=new HomePage(getWebDriver());
        LoginPage loginPage = homePage.getHeader().navToLoginPage();
        RegistrationPage registrationPage=new RegistrationPage(getWebDriver());

        //act
        loginPage.navToRegisterationPage().createAccount(user);

        //assert
        String errorMessage = registrationPage.errorMessage();
        Assert.assertTrue(errorMessage.contains("Email can't be blank"));

    }

    @Test
    public void verifyThatUserIsNotAbleToRegisterWithEmptyPassword(){
        //arrange
        User user= User.builder().build().userWithoutPassword();
        HomePage homePage=new HomePage(getWebDriver());
        LoginPage loginPage = homePage.getHeader().navToLoginPage();
        RegistrationPage registrationPage=new RegistrationPage(getWebDriver());

        //act
        loginPage.navToRegisterationPage().createAccount(user);

        //assert
        String errorMessage = registrationPage.errorMessage();
        Assert.assertTrue(errorMessage.contains("Password can't be blank"));
    }
}
