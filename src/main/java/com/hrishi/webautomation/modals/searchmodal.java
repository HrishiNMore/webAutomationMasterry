package com.hrishi.webautomation.modals;

import com.hrishi.webautomation.components.HeaderComponent;
import com.hrishi.webautomation.pages.SProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class searchmodal extends HeaderComponent {
    @FindBy(id = "Search-In-Modal")
    private WebElement inputBoxEle;
    public searchmodal(WebDriver webDriver) {
        super(webDriver);
    }

    public SProductsPage searchResult(String input){
        textBox.type(inputBoxEle,input);
        inputBoxEle.submit();
        return new SProductsPage(webDriver);
    }
}
