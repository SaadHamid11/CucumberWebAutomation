package com.pages.productpage;

import com.qa.util.ElementUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPageHelpers {
    private WebDriver driver;
    private ElementUI uiUtility;
    private WebElement priceElement;
    private WebElement productQuantity;
    private WebElement productPriceElement;
    private WebElement totalPriceElement;
    private String quantity;
    public ProductPageHelpers(WebDriver driver){
        this.driver = driver;
        this.uiUtility = new ElementUI(driver);
    }

   public String getPageTitle(){
        return driver.getTitle();
   }


   public double getPriceOfProduct(){
        priceElement = driver.findElement(ProductPageConstants.getPriceLocator());
        String amount = uiUtility.removeCurrencySymbolFromString(priceElement.getText());
        if(amount != null){
            return uiUtility.convertStringToDouble(amount);
        }
        else{
            return -1;
        }
   }

   public void addQuantityOfProduct(String quantity){
        this.quantity = quantity;
        productQuantity = driver.findElement(ProductPageConstants.getProductQty());
        uiUtility.sendKeys(productQuantity, quantity);
   }

   public double calculateTotalPrice(){
        int qty = uiUtility.convertStringToInteger(quantity);
        productPriceElement = driver.findElement(ProductPageConstants.getProductPrice());
        String priceText = productPriceElement.getText();
        double price = uiUtility.convertStringToDouble(uiUtility.removeCurrencySymbolFromString(priceText));

        double totalPriceOfProduct = price * qty;
        return totalPriceOfProduct;


   }

   public double getTotalPriceFromUI(){
        totalPriceElement = driver.findElement(ProductPageConstants.getTotalPrice());
        String totalPriceText = totalPriceElement.getText();
        return uiUtility.convertStringToDouble(uiUtility.removeCurrencySymbolFromString(totalPriceText));
   }

}
