package com.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUI {

    private WebDriver driver;
    private WebDriverWait wait;

    public ElementUI(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void clickElement(WebElement element){
        element.click();
    }

    public boolean waitForElementToAppear(By locator){
        WebElement element =  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        if(element.isDisplayed()){
            return true;
        }
        else{
            System.out.println("Element is not displayed");
            return false;
        }
    }

    public void sendKeys(WebElement element , String text){
        if(element !=null && text !=null){
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }

    public WebElement waitForElementToAppearOnDOM(By locator){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return element;
    }

    public WebElement waitForElementToBeClickAble(By locator){
        WebElement ele =  wait.until(ExpectedConditions.elementToBeClickable(locator));
        return ele;
    }

    public boolean validatePageTitle(String title){

        return wait.until(ExpectedConditions.titleContains(title));
    }

    public String removeCurrencySymbolFromString(String data){
        String amount = null;
        if(data!=null){

            int indexOFCurrency = data.indexOf("$");
            if(indexOFCurrency >=0){
               amount = data.replace("$","").trim();
            }
        }
        return amount;

    }


    public double convertStringToDouble(String amount){

        try{
            return Double.parseDouble(amount);
        }
        catch (Exception e){
            System.out.println("Cannot convert "+amount+ " to double due to: "+e.getMessage());
        }

        return -1;

    }

}
