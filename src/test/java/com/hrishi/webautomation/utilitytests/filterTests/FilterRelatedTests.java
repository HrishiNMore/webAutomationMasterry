package com.hrishi.webautomation.utilitytests.filterTests;

import com.hrishi.webautomation.BaseTest;
import com.hrishi.webautomation.components.FilterComponant;
import com.hrishi.webautomation.pages.HomePage;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FilterRelatedTests extends BaseTest {
    @Test
    public void userShouldAbleToFilterTheProductBySize() throws InterruptedException {
        HomePage homePage = new HomePage(getWebDriver());
        homePage.getHeader().navToStore();
        Thread.sleep(5000);
        FilterComponant filterComponant = new FilterComponant(getWebDriver());
        filterComponant.getSize().click();
        filterComponant.getSizeEle().click();
        Thread.sleep(3000);
        String a = filterComponant.getLabelEle().getText().split("\\s+")[0];
        Thread.sleep(3000);
        Actions actions = new Actions(getWebDriver());
        actions.doubleClick(filterComponant.getPict()).perform();
        String b = filterComponant.getSizeText().getText();
//        System.out.println(a+b);
        Assert.assertEquals(a,b);
        Thread.sleep(5000);
    }

    @Test
    public void userShouldAbleToFilterTheProductByBrand() throws InterruptedException {
        HomePage homePage = new HomePage(getWebDriver());
        homePage.getHeader().navToStore();
        Thread.sleep(5000);
        FilterComponant filterComponant = new FilterComponant(getWebDriver());
        filterComponant.getBrand().click();
        filterComponant.getBrandEle().click();
        Thread.sleep(3000);
        String a = filterComponant.getLabelEle().getText().split("\\s+")[0];
        Thread.sleep(3000);
        Actions actions = new Actions(getWebDriver());
        actions.doubleClick(filterComponant.getPict()).perform();
        String b = filterComponant.getBrandText().getText();
//       System.out.println(a+b);
        Assert.assertEquals(a,b);
    }

    @Test
    public void userShouldAbleToClearFilter() throws InterruptedException {
        HomePage homePage = new HomePage(getWebDriver());
        homePage.getHeader().navToStore();
        Thread.sleep(5000);
        FilterComponant filterComponant = new FilterComponant(getWebDriver());
        filterComponant.getBrand().click();
        filterComponant.getBrandEle().click();
        Thread.sleep(3000);
        Actions actions = new Actions(getWebDriver());
        actions.doubleClick(filterComponant.getSize()).perform();
        filterComponant.getSizeEle1().click();
        Thread.sleep(3000);


    }
}
