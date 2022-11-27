package com.pages.checkoutconfirmationpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutConfirmationHelpers {
    private WebDriver driver;
    private WebElement userNameElement;
    private WebElement productNameElement;
    private WebElement productQuantityElement;
    private WebElement subtotalElement;
    private WebElement shippingRateElement;

    private WebElement totalProductPriceElement;
    private WebElement confirmOrderElement;



    public CheckoutConfirmationHelpers(WebDriver driver) {
        this.driver = driver;
    }
}
