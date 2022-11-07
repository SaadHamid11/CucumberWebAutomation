package com.pages.homepage;

import org.openqa.selenium.By;

public class HompageConstants {

    private static By loginPageLocator = By.xpath("//ul[@id='customer_menu_top']//a[text()='Login or register']");
    private static By contactUsPageLocator = By.xpath("//a[text()='Contact Us']");
    private static By featureProductSectionLocator = By.xpath("//section[@id='featured']");
    private static By featureProductNameLocator = By.xpath("//section[@id='featured']//a[@class='prdocutname']");
    private static By viewLinkLocator = By.xpath("//section[@id='featured']//a[@class='details']");

    public static By getViewLinkLocator() {
        return viewLinkLocator;
    }

    public static By getLoginPageLocator() {
        return loginPageLocator;
    }

    public static By getContactUsPageLocator(){
        return contactUsPageLocator;
    }

    public static By getFeatureProductSectionLocator() {
        return featureProductSectionLocator;
    }

    public static By getFeatureProductNameLocator() {
        return featureProductNameLocator;
    }
}
