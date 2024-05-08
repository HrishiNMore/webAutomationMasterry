package com.hrishi.webautomation.functions;

import com.hrishi.webautomation.actions.SearchContent;
import com.hrishi.webautomation.pages.BasePage;
import com.hrishi.webautomation.pages.accounts.ViewProPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ViewProduct extends BasePage {
    @FindBy(id = "product-grid")
    private WebElement allProductsList;

    private org.openqa.selenium.By By;
    List<WebElement> allProductsHeading=allProductsList.findElements(By.tagName("h3"));

    String searchContent= SearchContent.builder().build().selectDress();
    public ViewProPage selectProduct() {
        for(WebElement li: allProductsHeading){
            if(li.getText().contains(searchContent)){
                li.click();
                break;
            }
        }
        return new ViewProPage(webDriver);
    }

    public ViewProduct(WebDriver webDriver) {
        super(webDriver);
    }
}
