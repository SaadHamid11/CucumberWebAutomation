package com.pages.homepage;

import org.openqa.selenium.By;

public class HompageConstants {

    private static By loginPageLocator = By.xpath("//ul[@id='customer_menu_top']//a[text()='Login or register']");
    private static By contactUsPageLocator = By.xpath("//a[text()='Contact Us']");




    public static By getLoginPageLocator() {
        return loginPageLocator;
    }

    public static By getContactUsPageLocator(){
        return contactUsPageLocator;
    }
}
