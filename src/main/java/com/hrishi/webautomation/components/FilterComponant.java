package com.hrishi.webautomation.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilterComponant extends HeaderComponent{

    public WebElement getBrand() {
        return Brand;
    }

    public WebElement getSize() {
        return Size;
    }

    public WebElement getBrandEle() {
        return BrandEle;
    }

    public WebElement getSizeEle() {
        return SizeEle;
    }

    public WebElement getLabelEle() {
        return LabelEle;
    }

    public WebElement getSizeText() {
        return SizeText;
    }

    public WebElement getBrandText() {
        return BrandText;
    }

    public WebElement getPict() {
        return Pict;
    }

    //header brand and size
    @FindBy(xpath = "//*[@id=\"FacetsWrapperDesktop\"]/details[4]/summary/div/span")
    private WebElement Brand;

    @FindBy(xpath = "//*[@id=\"FacetsWrapperDesktop\"]/details[5]/summary/div/span")
    private WebElement Size;

    //Chekbox
    @FindBy(xpath = "//*[@id=\"FacetsWrapperDesktop\"]/details[4]/div/ul/li[1]/label")
    private WebElement BrandEle;
    @FindBy(xpath = "//*[@id=\"FacetsWrapperDesktop\"]/details[5]/div/ul/li[1]/label")
    private WebElement SizeEle;

    @FindBy(xpath = "//*[@id=\"FacetsWrapperDesktop\"]/details[5]/div/ul/li[5]/label")
    private WebElement SizeEle1;

    public WebElement getSizeEle1() {
        return SizeEle1;
    }

    @FindBy(xpath = "//*[@id=\"FacetFiltersForm\"]/div[2]/facet-remove[1]/a/span[1]")
    private WebElement LabelEle;

  //after click picture
    @FindBy(xpath = "//*[@id=\"ProductInfo-template--15328405717213__main\"]/variant-radios/fieldset[2]/label[1]")
    private WebElement SizeText;

    @FindBy(xpath = "//*[@id=\"ProductInfo-template--15328405717213__main\"]/p[1]")
    private WebElement BrandText;
 //picture
    @FindBy(xpath = "//*[@id=\"product-grid\"]/li[1]/div/div[1]/div/h3/a")
    private WebElement Pict;



    public FilterComponant(WebDriver webDriver) {
        super(webDriver);
    }
}
