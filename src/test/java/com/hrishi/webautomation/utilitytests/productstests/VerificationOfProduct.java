package com.hrishi.webautomation.utilitytests.productstests;

import com.hrishi.webautomation.BaseTest;
import com.hrishi.webautomation.actions.SearchContent;
import com.hrishi.webautomation.components.SearchModal;
import com.hrishi.webautomation.components.ZoomComponant;
import com.hrishi.webautomation.data.clientdata.ProductDataClient;
import com.hrishi.webautomation.models.ChoosedProduct;
import com.hrishi.webautomation.pages.HomePage;
import com.hrishi.webautomation.pages.SearchProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerificationOfProduct extends BaseTest {

    @Test
    public void verifyProductInformationIsCorrect() {
        //arrange
        SearchContent searchContent = SearchContent.builder().build().init();
        HomePage homePage = new HomePage(getWebDriver());
        SearchModal searchModal = homePage.getHeader().openSearchModal();
        ProductDataClient productDataClient = new ProductDataClient();
        String name = productDataClient.getProduct().getName();

        //act
        SearchProductsPage productsPage = searchModal.searchResult(searchContent.getInput());
        WebElement productImage = getWebDriver().findElement(By.xpath("//*[@id=\"product-grid\"]/ul/li/div"));
        productImage.click();

        ChoosedProduct choosedProduct = new ChoosedProduct(getWebDriver());
        String productName = choosedProduct.getProductName();
        String sellerName = choosedProduct.getSellerName();
        String regularPrice = choosedProduct.getPrice();
        System.out.println(productName + " " + sellerName + " " + regularPrice);

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
        SearchProductsPage productsPage = searchModal.searchResult(searchContent.getInput());
        WebElement productImage = getWebDriver().findElement(By.xpath("//*[@id=\"product-grid\"]/ul/li/div"));
        productImage.click();

        ZoomComponant zoomImage = new ZoomComponant(getWebDriver());
        zoomImage.zoomImageFunction();

        Assert.assertTrue(zoomImage.getZoomedWidth() > zoomImage.getOriginalWidth());

    }
}
