package com.pages.productpage;

import org.openqa.selenium.By;

public class ProductPageConstants {

    private static By priceLocator = By.xpath("//div[@class='productfilneprice']");


    public static By getPriceLocator() {
        return priceLocator;
    }
}
