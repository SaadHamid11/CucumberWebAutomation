package com.pages.accountpage;

import org.openqa.selenium.By;

public class AccountPageConstants {
    private static By accountPageHeader = By.xpath("//h1[@class='heading1']");

    private static By navigationBarLocator = By.xpath("//ul[@class='nav-dash']");
    private static By homeLocator = By.xpath("//a[@class='active menu_home']");


    public static By getHomeLocator() {
        return homeLocator;
    }


    public static By getAccountPageHeader(){
        return accountPageHeader;
    }

    public static By getNavigationBarLocator(){
        return navigationBarLocator;
    }
}
