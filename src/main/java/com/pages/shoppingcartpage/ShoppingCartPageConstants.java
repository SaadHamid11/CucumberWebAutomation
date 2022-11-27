package com.pages.shoppingcartpage;

import org.openqa.selenium.By;

public class ShoppingCartPageConstants {
    private static By quantityLocator = By.xpath("//input[@id='cart_quantity50']");
    private static By productNameLocator = By.xpath("//div[@class='container-fluid cart-info product-list']//table[@class='table table-striped table-bordered']//td[@class='align_left']/a");
    private static By totalPriceLocator = By.xpath("//div[@class='container-fluid cart-info product-list']//table[@class='table table-striped table-bordered']//td[@class='align_right'][2]");


    public static By getQuantityLocator() {
        return quantityLocator;
    }

    public static By getProductNameLocator() {
        return productNameLocator;
    }

    public static By getTotalPriceLocator() {
        return totalPriceLocator;
    }
}
