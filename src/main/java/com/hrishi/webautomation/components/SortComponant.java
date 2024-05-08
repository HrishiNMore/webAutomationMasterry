package com.hrishi.webautomation.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SortComponant extends HeaderComponent{

    @FindBy(xpath = "//*[@id=\"SortBy\"]")
    private WebElement sortDropdown;

    public WebElement getSortDropdown() {
        return sortDropdown;
    }

    @FindBy(xpath = "//*[@id=\"SortBy\"]/option[5]")
    private WebElement dropdownoption;

    public WebElement getDropdownoption() {
        return dropdownoption;
    }

    @FindBy(xpath = "//*[@id=\"product-grid\"]/ul/li[1]/div/div[1]/div/h3/a")
    private WebElement picture;
    public SortComponant(WebDriver webDriver) {
        super(webDriver);
    }
}
