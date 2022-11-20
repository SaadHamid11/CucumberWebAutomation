package com.pages.homepage;

import com.pages.contactuspage.ContactUsConstants;
import com.pages.contactuspage.ContactUsHelpers;
import com.pages.loginpage.LoginPageConstants;
import com.pages.loginpage.LoginPageHelper;
import com.pages.productpage.ProductPageHelpers;
import com.qa.util.ElementUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class HomePageHelpers {
    private WebDriver driver;
    private ElementUI uiUtility;
    private   WebElement loginPageLink;
    private WebElement  contactUsPageLink;
    private List<WebElement> featuredProducts;
    private WebElement featureProductSection;
    private String searchedProduct;
    private List<String> listOfFeaturedProducts = new ArrayList<String>();

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

    public boolean isFeaturedSectionDisplayed(){
        featureProductSection = uiUtility.waitForElementToAppearOnDOM(HompageConstants.getFeatureProductSectionLocator());
        return featureProductSection.isDisplayed();
    }


    public  void createFeatureProductList(){
        featuredProducts = driver.findElements(HompageConstants.getFeatureProductNameLocator());

        for(WebElement product : featuredProducts){

            listOfFeaturedProducts.add(product.getText().trim().toLowerCase());

        }
    }
    public boolean verifyProductAvailability(String productName){
        searchedProduct = productName;

        if(listOfFeaturedProducts != null){
            return listOfFeaturedProducts.contains(searchedProduct.trim().toLowerCase());
        }
        return false;
    }


    public void clickOnViewProduct(){
        for(int i = 0 ; i < featuredProducts.size() ; i++){
            if(featuredProducts.get(i).getText().trim().equalsIgnoreCase(searchedProduct.trim())){

            WebElement productEle = featuredProducts.get(i);
            uiUtility.clickElement(productEle);
            break;
            }
        }
    }


    public ProductPageHelpers getProductPage(){

        if(uiUtility.validatePageTitle(searchedProduct)){
            return new ProductPageHelpers(driver);
        }
        return null;

    }




}
