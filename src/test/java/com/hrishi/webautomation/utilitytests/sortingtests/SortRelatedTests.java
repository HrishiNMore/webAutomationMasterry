package com.hrishi.webautomation.utilitytests.sortingtests;

import com.hrishi.webautomation.BaseTest;
import com.hrishi.webautomation.components.SortComponant;
import com.hrishi.webautomation.functions.ViewProduct;
import com.hrishi.webautomation.models.User;
import com.hrishi.webautomation.pages.HomePage;
import com.hrishi.webautomation.pages.StorePage;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class SortRelatedTests extends BaseTest {
    @Test
    public void userShouldableToSortTheProduct() throws InterruptedException {
        User user= User.builder().build().userWithValidCredentials();
        HomePage homePage=new HomePage(getWebDriver());
        homePage.getHeader().navToLoginPage().login(user);
        StorePage storePage = homePage.getHeader().navToStore();
        SortComponant sortComponant=new SortComponant(getWebDriver());
        Thread.sleep(5000);
//        // Create a Select object
//        Select dropdown = new Select(sortComponant.getSortDropdown());
//
//        // Select option by visible text
//        dropdown.selectByVisibleText("Price,low to high");

        // Initialize WebDriverWait with a timeout of 10 seconds
        WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(10));

        // Wait for the dropdown element to be clickable
        WebElement dropdownElement = wait.until(ExpectedConditions.elementToBeClickable(sortComponant.getSortDropdown()));

        // Create a Select object for the dropdown element
        Select dropdown = new Select(dropdownElement);

        // Select an option by visible text
        dropdown.selectByVisibleText("Price,low to high");


//        sortComponant.getSortDropdown().click();
//        Thread.sleep(5000);
//        Actions actions=new Actions(getWebDriver());
//        actions.doubleClick(sortComponant.getDropdownoption()).build().perform();
////        sortComponant.getDropdownoption().click();
        Thread.sleep(5000);
    }

    }

