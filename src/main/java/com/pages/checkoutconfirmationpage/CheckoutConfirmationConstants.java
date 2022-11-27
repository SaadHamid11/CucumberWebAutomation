package com.pages.checkoutconfirmationpage;

import org.openqa.selenium.By;

public class CheckoutConfirmationConstants {


     private static By productNameLocator = By.xpath("//div[@class='column_right col-md-3 col-xs-12 mt20']//td[@class='align_left valign_top']//a");
     private static By productQuantityLocator = By.xpath("//table[@class='table confirm_products']//td[4]");
     private static By subtotalLocator = By.xpath("");
     private static By shippingRateLocator = By.xpath("");
     private static By totalProductPriceLocator = By.xpath("");
     private static By confirmOrderLocator = By.xpath("");

    public static By getProductNameLocator() {
        return productNameLocator;
    }

    public static By getProductQuantityLocator() {
        return productQuantityLocator;
    }

    public static By getSubtotalLocator() {
        return subtotalLocator;
    }

    public static By getShippingRateLocator() {
        return shippingRateLocator;
    }

    public static By getTotalProductPriceLocator() {
        return totalProductPriceLocator;
    }

    public static By getConfirmOrderLocator() {
        return confirmOrderLocator;
    }
}
