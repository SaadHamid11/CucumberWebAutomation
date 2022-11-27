package com.pages.shoppingcartpage;

import com.pages.productpage.ProductPageHelpers;
import com.qa.util.ElementUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPageHelper {
    private WebDriver driver;
    private ElementUI uiUtils;
    private WebElement quanityElement;
    private WebElement productNameElement;
    private WebElement totalPriceElement;

    public ShoppingCartPageHelper(WebDriver driver) {
        this.driver = driver;
        uiUtils = new ElementUI(driver);

    }

    public double getQuantityFromShoppingCart(){
        quanityElement = driver.findElement(ShoppingCartPageConstants.getQuantityLocator());
        String qty = quanityElement.getAttribute("value");
        return uiUtils.convertStringToDouble(qty);
    }

    public String getProductName(){
        productNameElement = driver.findElement(ShoppingCartPageConstants.getProductNameLocator());
        return productNameElement.getText();
    }

    public double getTotalPrice(){

        totalPriceElement = driver.findElement(ShoppingCartPageConstants.getTotalPriceLocator());

        return uiUtils.convertStringToDouble(uiUtils.removeCurrencySymbolFromString(totalPriceElement.getText()));

    }




}
