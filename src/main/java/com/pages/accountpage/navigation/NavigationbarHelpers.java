package com.pages.accountpage.navigation;

import com.qa.util.ElementUI;
import io.cucumber.java.en_old.Ac;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.*;

public class NavigationbarHelpers {
    private WebDriver driver;
    private WebElement navigationBar;
    private ElementUI utils;
    private WebElement toolTipElement ;
    List<WebElement> navigationItems ;
    Set<String> navigationItemNames  = new HashSet<String>() ;

    List<String> toolTipsText = new ArrayList<String>();

    public NavigationbarHelpers(WebDriver driver){
        this.driver = driver;
            }


    public void getNavigationMenuItems(){
        navigationItems = driver.findElements(NavigationBarConstants.getNavigationLocators());
        for(WebElement ele : navigationItems){

            navigationItemNames.add(ele.getAttribute("data-original-title"));




        }
    }

    public void hoverOverNavigationitem(){
        Actions action = new Actions(driver);
        utils = new ElementUI(driver);
        if(navigationItems != null){
            for(WebElement ele : navigationItems){
                action.moveToElement(ele).build().perform();
                WebElement toolTip = utils.waitForElementToAppearOnDOM(NavigationBarConstants.getToolTipLocator());
                toolTipsText.add(toolTip.getText());
            }



        }

    }


    public boolean isTooltipAvailable(String text){
        if(text != null){
            if(toolTipsText.contains(text)){
                return true;
            }

        }
        return false;
    }




}
