package com.pages.productpage;

import com.qa.util.ElementUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPageHelpers {
    private WebDriver driver;
    private ElementUI uiUtility;
    private WebElement priceElement;
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

}
