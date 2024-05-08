package com.hrishi.webautomation.modals;

import com.hrishi.webautomation.components.HeaderComponent;
import com.hrishi.webautomation.pages.SearchProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Searchmodal extends HeaderComponent {
    @FindBy(id = "Search-In-Modal")
    private WebElement inputBoxEle;
    public Searchmodal(WebDriver webDriver) {
        super(webDriver);
    }

    public SearchProductsPage searchResult(String input){
        textBox.type(inputBoxEle,input);
        inputBoxEle.submit();
        return new SearchProductsPage(webDriver);
    }
}
