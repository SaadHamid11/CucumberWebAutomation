package com.pages.accountpage;

import com.pages.accountpage.navigation.NavigationbarHelpers;
import com.pages.homepage.HomePageHelpers;
import com.qa.util.ElementUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPageHelpers {

    private WebDriver driver;
    WebElement headerElement;
    WebElement navigationBarElement;
    WebElement homeElement;

    private ElementUI utils;

    public AccountPageHelpers(WebDriver driver){
        this.driver = driver;
    }


    public boolean isHeaderDisplayed(){
        headerElement = driver.findElement(AccountPageConstants.getAccountPageHeader());
        return headerElement.isDisplayed();
    }
public HomePageHelpers navigateHomePage(){
        homeElement = driver.findElement(AccountPageConstants.getHomeLocator());
        if(homeElement.isDisplayed()){
            homeElement.click();
            return new HomePageHelpers(driver);
        }
        else {
            System.out.println("Home page navigation link is not displayed");
            return null;
        }
}

    public NavigationbarHelpers getNavigationBar(){
        utils = new ElementUI(driver);
        if(utils.waitForElementToAppear(AccountPageConstants.getNavigationBarLocator())){
            navigationBarElement = driver.findElement(AccountPageConstants.getNavigationBarLocator());
            if(navigationBarElement.isDisplayed()){
                return new NavigationbarHelpers(driver);
            }
            else {
                return null;
            }
        }
        return null;
    }
}
