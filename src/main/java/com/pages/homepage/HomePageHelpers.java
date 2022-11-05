package com.pages.homepage;

import com.pages.contactuspage.ContactUsConstants;
import com.pages.contactuspage.ContactUsHelpers;
import com.pages.loginpage.LoginPageConstants;
import com.pages.loginpage.LoginPageHelper;
import com.qa.util.ElementUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageHelpers {
    private WebDriver driver;
    private ElementUI uiUtility;
    private   WebElement loginPageLink;
    private WebElement  contactUsPageLink;

    public HomePageHelpers(WebDriver driver){
        this.driver = driver;
        this.uiUtility = new ElementUI(driver);
    }

    public void gotoHomePage(){
        String url = "https://automationteststore.com/";
        driver.navigate().to(url);
    }

    public LoginPageHelper navigateLoginPage(){
        loginPageLink = driver.findElement(HompageConstants.getLoginPageLocator());
        uiUtility.clickElement(loginPageLink);
        boolean isLoginPageDisplayed = uiUtility.waitForElementToAppear(LoginPageConstants.getAccountLoginHeader());
        if(isLoginPageDisplayed){
            return new LoginPageHelper(driver);
        }
        else {
            return null;
        }
    }


    public ContactUsHelpers navigateContactUsPage(){
        contactUsPageLink = driver.findElement(HompageConstants.getContactUsPageLocator());
        uiUtility.clickElement(contactUsPageLink);
        if(uiUtility.waitForElementToAppear(ContactUsConstants.getMainHeadingLocator())){
            return new ContactUsHelpers(driver);
        }
        return null;
    }

}
