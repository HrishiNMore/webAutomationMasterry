package com.hrishi.webautomation.utilitytests;

import com.hrishi.webautomation.BaseTest;
import com.hrishi.webautomation.models.User;
import com.hrishi.webautomation.pages.HomePage;
import com.hrishi.webautomation.pages.accounts.LoginPage;
import com.hrishi.webautomation.pages.accounts.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test
    public void userIsAbleToLoginWithCredentials() {
        //arrange
        User user = User.builder().build().userWithValidCredentials();
        HomePage homePage = new HomePage(getWebDriver());
        LoginPage loginPage = homePage.getHeader().navToLoginPage();

        //act
        ProfilePage profilePage = loginPage.login(user);
        String accountDetails = profilePage.getAccountDetails();

        //assert
        Assert.assertTrue(accountDetails.contains(user.getFirst_name().toLowerCase()));
        Assert.assertTrue(accountDetails.contains(user.getLast_name().toLowerCase()));

    }

    @Test
    public void verifyThatUserIsAbleToLoginWithIncorrectCredentials() {
        //arrange
        User user = User.builder().build().userWithInvalidCredentials();
        HomePage homePage = new HomePage(getWebDriver());

        //act
        LoginPage loginPage = homePage.getHeader().navToLoginPage();
        loginPage.login(user);
        String errorMessage = loginPage.getErrorMessage();

        //assert
        Assert.assertTrue(errorMessage.contains("Incorrect email or password."));

    }


}
