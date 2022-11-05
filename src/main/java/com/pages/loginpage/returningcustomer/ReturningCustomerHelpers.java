package com.pages.loginpage.returningcustomer;

import com.pages.accountpage.AccountPageHelpers;
import com.qa.util.ElementUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReturningCustomerHelpers {
    private WebDriver driver;
    private ElementUI uiUtils;

    private WebElement loginField;
    private WebElement passwordField;
    private WebElement loginButton ;

    public ReturningCustomerHelpers(WebDriver driver){
        this.driver = driver;
        uiUtils = new ElementUI(driver);
    }

    public  void enterLogin(String userName){
        loginField = driver.findElement(ReturningCustomerConstants.getLoginName());
        uiUtils.sendKeys(loginField, userName);

    }

    public void enterPassword(String password){
        passwordField = driver.findElement(ReturningCustomerConstants.getPassword());
        uiUtils.sendKeys(passwordField, password);
    }

    public void clickLogin(){

        loginButton = driver.findElement(ReturningCustomerConstants.getLoginButton());
        uiUtils.clickElement(loginButton);
    }


    public AccountPageHelpers doLogin(String username, String password){
        enterLogin(username);
        enterPassword(password);
        clickLogin();
        AccountPageHelpers accountPage = new AccountPageHelpers(driver);
        if(accountPage.isHeaderDisplayed()){
            return accountPage;
        }
        else {
            accountPage = null;
            return accountPage;
        }
    }

}
