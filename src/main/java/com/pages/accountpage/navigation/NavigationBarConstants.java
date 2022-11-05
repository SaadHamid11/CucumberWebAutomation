package com.pages.accountpage.navigation;

import org.openqa.selenium.By;

public class NavigationBarConstants {

    private static By navigationLocators = By.xpath("//ul[@class='nav-dash']//a[@data-toggle='tooltip']");
    private static By toolTipLocator = By.xpath("//div[@class='tooltip fade top in']/div[@class='tooltip-inner']");

    public static By getNavigationLocators(){
        return navigationLocators;
    }

    public static By getToolTipLocator(){
        return toolTipLocator;
    }

}
