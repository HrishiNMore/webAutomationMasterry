package com.hrishi.webautomation.components;

import com.hrishi.webautomation.pages.SearchProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchModal extends HeaderComponent{
    @FindBy(id = "Search-In-Modal")
    private WebElement inputBoxEle;
    public SearchModal(WebDriver webDriver) {
        super(webDriver);
    }

    public SearchProductsPage searchResult(String input){
        textBox.type(inputBoxEle,input);
        inputBoxEle.submit();
        return new SearchProductsPage(webDriver);
    }

}
