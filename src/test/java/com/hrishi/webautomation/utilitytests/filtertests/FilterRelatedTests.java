package com.hrishi.webautomation.utilitytests.filtertests;

import com.hrishi.webautomation.BaseTest;
import com.hrishi.webautomation.components.FilterComponant;
import com.hrishi.webautomation.components.HeaderComponent;
import com.hrishi.webautomation.modals.FilterPriceModal;
import com.hrishi.webautomation.models.ProductList;
import com.hrishi.webautomation.pages.HomePage;
import com.hrishi.webautomation.pages.ProductPage;
import com.hrishi.webautomation.pages.StorePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FilterRelatedTests extends BaseTest {

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
    public void userShouldAbleToClearAllFilter() throws InterruptedException {
        HomePage homePage = new HomePage(getWebDriver());
        homePage.getHeader().navToStore();
        FilterComponant filterComponant = new FilterComponant(getWebDriver());
        String a=filterComponant.getPict().getText();
        Thread.sleep(5000);

        filterComponant.getBrand().click();
        filterComponant.getBrandEle().click();
        Thread.sleep(3000);
        Actions actions = new Actions(getWebDriver());
        actions.doubleClick(filterComponant.getSize()).perform();
        filterComponant.getSizeEle1().click();
        Thread.sleep(3000);
        WebElement clearAll= getWebDriver().findElement(By.xpath("//*[@id=\"FacetFiltersForm\"]/div[2]/facet-remove[3]/a/span"));
        actions.doubleClick(clearAll).perform();
        Thread.sleep(3000);
        String b=filterComponant.getPict().getText();
       // System.out.println(a+b);
        Assert.assertEquals(a,b);
        Thread.sleep(3000);

    }

    @Test(testName = "Filter by price range",description = "User is able to Filter by price range")
    public void userIsAbleToFilterByPriceRange() throws InterruptedException {
        HomePage homePage = new HomePage(getWebDriver());
        HeaderComponent headerComponent = new HeaderComponent(getWebDriver());
        ProductPage p=new ProductPage(getWebDriver());
        StorePage productsPage = headerComponent.navToStore();
        p.clickFilterPrice();

        FilterPriceModal filterPriceModal = new FilterPriceModal(getWebDriver());
        WebElement fromPrice = filterPriceModal.getFromPrice();
        fromPrice.sendKeys("100");


        WebElement toPrice = filterPriceModal.getToPrice();
        toPrice.sendKeys("300");

        Actions actions=new Actions(getWebDriver());
        actions.doubleClick(filterPriceModal.getHead()).build().perform();

        Thread.sleep(2000);




    }
}
