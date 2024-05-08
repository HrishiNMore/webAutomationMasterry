package com.hrishi.webautomation.utilitytests;

import com.hrishi.webautomation.BaseTest;
import com.hrishi.webautomation.actions.SearchContent;
import com.hrishi.webautomation.components.HeaderComponent;
import com.hrishi.webautomation.components.SearchModal;
import com.hrishi.webautomation.models.User;
import com.hrishi.webautomation.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchProductTest extends BaseTest {
    @Test
    public void verifyThatUserIsAbleToSeeTheProductPageAfterSearchingForProduct(){
        //arrange
        SearchContent searchContent= SearchContent.builder().build().init();
        HomePage homePage=new HomePage(getWebDriver());

        //arrange
        SearchModal searchModal = homePage.getHeader().openSearchModal();
        SearchProductsPage productsPage = searchModal.searchResult(searchContent.getInput());

        //assert
        Assert.assertTrue(productsPage.getHeading().contains("Search results"));
    }

    @Test
    public void verifyThatSearchProductIsRelevantToProductDisplayed(){
        //arrange
        SearchContent searchContent= SearchContent.builder().build().init();
        HomePage homePage=new HomePage(getWebDriver());

        //arrange
        SearchModal searchModal = homePage.getHeader().openSearchModal();
        SearchProductsPage productsPage = searchModal.searchResult(searchContent.getInput());

        //assert
        List<String> productNames = productsPage.getProductNames();
        for(String productName : productNames){
//            System.out.println(productName);
            Assert.assertTrue(productName.toLowerCase().contains(searchContent.getInput().toLowerCase()),"No Products Found");
        }

    }




    @Test
    public void userShouldAbleToCheckStockAvability() {
        //arrange
        User user= User.builder().build().userWithValidCredentials();
        HomePage homePage=new HomePage(getWebDriver());
        StorePage storePage = homePage.getHeader().navToStore();
        StorePage avilPage = homePage.getHeader().navToAvil();
        WebElement stock= getWebDriver().findElement(By.xpath("//*[@id=\"FacetsWrapperDesktop\"]/details[1]/div/ul/li[1]/label"));
        String a= stock.getText();
        Assert.assertEquals(a,"In stock (1486)");
    }

    @Test
    public void userShouldAbleToAddCartUsingSearchResultOrProductPage(){
        SearchContent searchContent = SearchContent.builder().build().init();
        HomePage homePage = new HomePage(getWebDriver());
        SearchModal searchModal = homePage.getHeader().openSearchModal();
        SearchProductsPage productsPage = searchModal.searchResult(searchContent.getInput());

        ProductPage serchPage=homePage.getHeader().navTopicture();

        ProductPage addCart=homePage.getHeader().navToAddCart();

        ProductPage viewCart=homePage.getHeader().navToViewCart();

        HeaderComponent headerComponent=new HeaderComponent(getWebDriver());
        String a=headerComponent.navToTextCart();
        Assert.assertTrue(a.contains("Megara Dress"));

    }

}
