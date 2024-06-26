package com.hrishi.webautomation.utilitytests;

import com.hrishi.webautomation.BaseTest;
import com.hrishi.webautomation.actions.SearchContent;
import com.hrishi.webautomation.actions.WebActions;
import com.hrishi.webautomation.components.HeaderComponent;
import com.hrishi.webautomation.components.SearchModal;
import com.hrishi.webautomation.components.ZoomComponant;
import com.hrishi.webautomation.data.clientdata.ProductDataClient;
import com.hrishi.webautomation.models.ChoosedProduct;
import com.hrishi.webautomation.models.User;
import com.hrishi.webautomation.pages.*;
import com.hrishi.webautomation.pages.accounts.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
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


    @Test
    public void verifyProductInformationIsCorrect(){
        //arrange
        SearchContent searchContent=SearchContent.builder().build().init();
        HomePage homePage=new HomePage(getWebDriver());
        SearchModal searchModal = homePage.getHeader().openSearchModal();
        ProductDataClient productDataClient=new ProductDataClient();
        String name = productDataClient.getProduct().getName();

        //act
        ProductsPage productsPage = searchModal.searchResult(searchContent.getInput());
        WebElement productImage= getWebDriver().findElement(By.xpath("//*[@id=\"product-grid\"]/ul/li/div"));
        productImage.click();

        ChoosedProduct choosedProduct=new ChoosedProduct(getWebDriver());
        String productName = choosedProduct.getProductName();
        String sellerName=choosedProduct.getSellerName();
        String regularPrice=choosedProduct.getPrice();
        System.out.println(productName+" "+sellerName+" "+regularPrice);

        //assert
        Assert.assertTrue(productName.contains(name));
        Assert.assertTrue(sellerName.contains(sellerName));
        Assert.assertTrue(regularPrice.contains(regularPrice));
    }
    @Test
    public void userShouldAbleToZoom() {
        SearchContent searchContent = SearchContent.builder().build().init();
        HomePage homePage = new HomePage(getWebDriver());
        SearchModal searchModal = homePage.getHeader().openSearchModal();
        ProductDataClient productDataClient = new ProductDataClient();

        //act
        ProductsPage productsPage = searchModal.searchResult(searchContent.getInput());
        WebElement productImage = getWebDriver().findElement(By.xpath("//*[@id=\"product-grid\"]/ul/li/div"));
        productImage.click();

        ZoomComponant zoomImage = new ZoomComponant(getWebDriver());
        zoomImage.zoomImageFunction();

        Assert.assertTrue(zoomImage.getZoomedWidth() > zoomImage.getOriginalWidth());

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
        ProductsPage productsPage = searchModal.searchResult(searchContent.getInput());

        SerchPage serchPage=homePage.getHeader().navTopicture();

        SerchPage addCart=homePage.getHeader().navToAddCart();

        SerchPage viewCart=homePage.getHeader().navToViewCart();

        HeaderComponent headerComponent=new HeaderComponent(getWebDriver());
        String a=headerComponent.navToTextCart();
        Assert.assertTrue(a.contains("Megara Dress"));

    }

}
