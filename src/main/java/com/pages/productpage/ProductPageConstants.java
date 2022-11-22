package com.pages.productpage;

import org.openqa.selenium.By;

public class ProductPageConstants {

    private static By priceLocator = By.xpath("//div[@class='productfilneprice']");
    private static By productQty = By.xpath("//input[@id='product_quantity']");
    private static By totalPrice = By.xpath("//span[@class='total-price']");
    private static By addToCart  = By.xpath("//a[@class='cart']");
    private static By productPrice = By.xpath("//div[@class='productfilneprice']");
    public static By getPriceLocator() {
        return priceLocator;
    }

    public static By getProductQty() {
        return productQty;
    }

    public static By getTotalPrice() {
        return totalPrice;
    }

    public static By getAddToCart() {
        return addToCart;
    }

    public static By getProductPrice() {
        return productPrice;
    }
}
