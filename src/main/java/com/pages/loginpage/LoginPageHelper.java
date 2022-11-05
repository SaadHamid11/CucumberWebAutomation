package com.pages.loginpage;

import com.pages.loginpage.returningcustomer.ReturningCustomerHelpers;
import com.qa.util.ElementUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageHelper {

    private WebDriver driver;
    private ElementUI uiUtils;


    public LoginPageHelper(WebDriver driver){
        this.driver = driver;
        uiUtils = new ElementUI(driver);
    }


    public String getPageTitle(){
        return driver.getTitle();
    }

    public boolean isLoginPageDisplayed(){
        return uiUtils.waitForElementToAppear(LoginPageConstants.getAccountLoginHeader());
    }
    public ReturningCustomerHelpers navigateToReturningCustomers(){
       boolean isReturningCustomerDisplayed =  uiUtils.waitForElementToAppear(LoginPageConstants.getReturningCustomerHeader());
       if(isReturningCustomerDisplayed){
           return new ReturningCustomerHelpers(driver);
       }
       else{
           System.out.println("Returning customer is not displayed");
           return null;
       }
    }

}
