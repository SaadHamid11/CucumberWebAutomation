package com.pages.productpage;

import com.pages.shoppingcartpage.ShoppingCartPageHelper;
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
    private WebElement addToCartElement;
    private String quantity;

    private double totalPriceOfProduct;



    public ProductPageHelpers(WebDriver driver){
        this.driver = driver;
        this.uiUtility = new ElementUI(driver);
    }

    public double getQuantity() {
        return uiUtility.convertStringToDouble(quantity);
    }



    public double getTotalPriceOfProduct() {
        return totalPriceOfProduct;
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
        String total = uiUtility.removeCurrencySymbolFromString(productPriceElement.getText());

        double price = uiUtility.convertStringToDouble(total);

        totalPriceOfProduct = price * qty;
        return totalPriceOfProduct;


   }

   public double getTotalPriceFromUI(){
        totalPriceElement = driver.findElement(ProductPageConstants.getTotalPrice());
        String totalPriceText = totalPriceElement.getText();
        return uiUtility.convertStringToDouble(uiUtility.removeCurrencySymbolFromString(totalPriceText));
   }

   public ShoppingCartPageHelper clickAddToCart(){
        addToCartElement = driver.findElement(ProductPageConstants.getAddToCart());
        uiUtility.clickElement(addToCartElement);
        if(uiUtility.isPageTitleUpdated("Shopping Cart")){
            return new ShoppingCartPageHelper(driver);
       }
       else{
            System.out.println("Page title not updated");
           return null;
       }

   }

}
