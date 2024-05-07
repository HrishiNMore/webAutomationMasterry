package com.hrishi.webautomation.modals;

import com.hrishi.webautomation.models.User;
import com.hrishi.webautomation.pages.BasePage;
import com.hrishi.webautomation.pages.HomePage;
import com.hrishi.webautomation.pages.StorePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductList extends BasePage {

    public String text;

    @FindBy(xpath = "//*[@id=\"product-form-template--15328405717213__main\"]/div/button")
    WebElement addToCart;

    public String getAddToCart() {
        return addToCart.getText();
    }

    @FindBy(xpath = "//*[@id=\"product-form-template--15328405717213__main\"]/div/button")
    WebElement soldOut;

    public String getSoldOut() {
        return soldOut.getText();
    }

    public ProductList(WebDriver webDriver) {
        super(webDriver);

    }

    public String printGridItemsInStock(){
        User user = User.builder().build().userWithValidCredentials();
        HomePage homePage = new HomePage(this.webDriver);
        StorePage storePage = homePage.getHeader().navToStore();
        StorePage avilPage = homePage.getHeader().navToAvil();
        WebElement chek = webDriver.findElement(By.xpath("//*[@id=\"FacetsWrapperDesktop\"]/details[1]/div/ul/li[1]/label"));
        chek.click();
        List<WebElement> wb = webDriver.findElements(By.tagName("h3"));

        if (!wb.isEmpty()) {
            WebElement firstElement = wb.get(0);
            text = firstElement.getText();
        } else {
            System.out.println("No elements found in the list.");
        }
        return text;
    }

    public String printGridItemsOutofStock(){
        User user = User.builder().build().userWithValidCredentials();
        HomePage homePage = new HomePage(this.webDriver);
        StorePage storePage = homePage.getHeader().navToStore();
        StorePage avilPage = homePage.getHeader().navToAvil();
        WebElement chek = webDriver.findElement(By.xpath("//*[@id=\"FacetsWrapperDesktop\"]/details[1]/div/ul/li[2]/label"));
        chek.click();
        List<WebElement> wb = webDriver.findElements(By.tagName("h3"));

        if (!wb.isEmpty()) {
            WebElement firstElement = wb.get(0);
            text = firstElement.getText();
        } else {
            System.out.println("No elements found in the list.");
        }
        return text;
    }

    public String filterInStockProduct() {
        User user = User.builder().build().userWithValidCredentials();
        HomePage homePage = new HomePage(this.webDriver);
        StorePage storePage = homePage.getHeader().navToStore();
        StorePage avilPage = homePage.getHeader().navToAvil();
        WebElement chek = webDriver.findElement(By.xpath("//*[@id=\"FacetsWrapperDesktop\"]/details[1]/div/ul/li[1]/label"));
        chek.click();
        WebElement pict=webDriver.findElement(By.xpath("//*[@id=\"product-grid\"]/li[1]/div/div[1]/div/h3/a"));
        Actions actions = new Actions(webDriver);
        actions.doubleClick(pict).build().perform();
        WebElement butt=webDriver.findElement(By.xpath("//*[@id=\"product-form-template--15328405717213__main\"]/div/button"));
        text=butt.getText();

        return text;


    }

    public String filterOutOfStockProduct() {
        User user = User.builder().build().userWithValidCredentials();
        HomePage homePage = new HomePage(this.webDriver);
        StorePage storePage = homePage.getHeader().navToStore();
        StorePage avilPage = homePage.getHeader().navToAvil();
        WebElement chek = webDriver.findElement(By.xpath("//*[@id=\"FacetsWrapperDesktop\"]/details[1]/div/ul/li[2]/label"));
        chek.click();
        WebElement pict=webDriver.findElement(By.xpath("//*[@id=\"product-grid\"]/li[1]/div/div[1]/div/h3/a"));
        Actions actions = new Actions(webDriver);
        actions.doubleClick(pict).build().perform();
        WebElement butt=webDriver.findElement(By.xpath("//*[@id=\"product-form-template--15328405717213__main\"]/div/button"));
        text=butt.getText();

        return text;


    }

    public String printGridPrice(){
        User user = User.builder().build().userWithValidCredentials();
        HomePage homePage = new HomePage(this.webDriver);
        StorePage storePage = homePage.getHeader().navToStore();
        StorePage avilPage = homePage.getHeader().navToAvil();
        WebElement chek = webDriver.findElement(By.xpath("//*[@id=\"FacetsWrapperDesktop\"]/details[1]/div/ul/li[1]/label"));
        chek.click();
        List<WebElement> wb = webDriver.findElements(By.xpath("//*[@id=\"product-grid\"]/li[2]/div/div[1]/div/div/div/div[1]"));

        if (!wb.isEmpty()) {
            WebElement firstElement = wb.get(1);
            text = firstElement.getText();
        } else {
            System.out.println("No elements found in the list.");
        }
        return text;
    }

}
