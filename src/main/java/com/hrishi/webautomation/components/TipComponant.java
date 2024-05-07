package com.hrishi.webautomation.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TipComponant extends HeaderComponent {
    @FindBy(xpath = "//*[@id=\"tipping_list-tipping_list_options-collapsible\"]/div/div/div/div[1]/div/div/button[1]")
    WebElement FivePercrntTip;
    @FindBy(xpath = "//*[@id=\"tipping_list-tipping_list_options-collapsible\"]/div/div/div/div[1]/div/div/button[2]")
    WebElement TenPercrntTip;
    @FindBy(xpath = "//*[@id=\"tipping_list-tipping_list_options-collapsible\"]/div/div/div/div[1]/div/div/button[3]")
    WebElement FifteenPercrntTip;
    @FindBy(xpath = "//*[@id=\"tipping_list-tipping_list_options-collapsible\"]/div/div/div/div[1]/div/div/button[4]")
    WebElement NoneTip;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div/div[1]/div[2]/div[2]/div/aside/div/section/div/section/div[2]/div[1]/div[2]/span")
    WebElement Subtotal;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div/div[1]/div[2]/div[2]/div/aside/div/section/div/section/div[2]/div[3]/div[2]/span")
    WebElement PercrntDiscout;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div/div[1]/div[2]/div[2]/div/aside/div/section/div/section/div[2]/div[5]/div[2]/div/div/span")
    WebElement Tax;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div/div[1]/div[2]/div[2]/div/aside/div/section/div/section/div[2]/div[6]/div[2]/span")
    WebElement Tip;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div/div[1]/div[2]/div[2]/div/aside/div/section/div/section/div[2]/div[7]/div[2]/div/div/strong")
    WebElement Total;

    public double result() {
        double p = getnum(this.Total);
        return p;
    }

    public TipComponant(WebDriver webDriver) {
        super(webDriver);
    }

    public double getnum(WebElement webElement) {
        String a = webElement.getText();


        a = a.replaceAll("[^\\d.]", "");


        if (a == null || a.isEmpty()) {
            throw new IllegalArgumentException("Input string is empty or null");
        }

        double value;

        try {

            value = Double.parseDouble(a);
        } catch (NumberFormatException e) {

            throw new IllegalArgumentException("Failed to parse input string as double", e);
        }

        return value;
    }

    public double demo() {
        double p = getnum(this.Subtotal);
        //System.out.println(p);
        double q = getnum(this.PercrntDiscout);
        //System.out.println(q);
        double r = getnum(this.Tax);
        //System.out.println(r);
        double s = getnum(this.Tip);
        //System.out.println(s);
        double t = (p + r + s) - q;
        //System.out.println(t);
        return t;
    }

    public void clickontip() {
        this.FivePercrntTip.click();
        // this.TenPercrntTip.click();
        //this.FifteenPercrntTip.click();
    }

    public void tipcheckout() {
        double p = getnum(this.Subtotal);
        double q = getnum(this.PercrntDiscout);
    }


}
