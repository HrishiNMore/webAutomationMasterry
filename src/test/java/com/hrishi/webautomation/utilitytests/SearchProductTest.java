package com.hrishi.webautomation.utilitytests;

import com.hrishi.webautomation.BaseTest;
import com.hrishi.webautomation.actions.SearchContent;
import com.hrishi.webautomation.components.SearchModal;
import com.hrishi.webautomation.pages.HomePage;
import com.hrishi.webautomation.pages.ProductsPage;
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
        ProductsPage productsPage = searchModal.searchResult(searchContent.getInput());

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
        ProductsPage productsPage = searchModal.searchResult(searchContent.getInput());

        //assert
        List<String> productNames = productsPage.getProductNames();
        for(String productName : productNames){
//            System.out.println(productName);
            Assert.assertTrue(productName.toLowerCase().contains(searchContent.getInput().toLowerCase()),"No Products Found");
        }

    }
}
