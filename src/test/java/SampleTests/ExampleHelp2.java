package SampleTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class ExampleHelp2 {

    WebDriver driver;
    WebDriverWait wait;
    @Test
    public void Test1(){
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        wait = new WebDriverWait(driver, 10L);
        driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.navigate().to("https://demo.simmeth.net/DEV/V6/Supply.Monitor.FE/login?isLogout=true");
        performLogin("k.mehmood","SSG@1234@abc");
        if(isPageChanged()){
        List<WebElement> sideNavBars = getSideNavHeaders();
        List<String> headerNames = new ArrayList<String>() ;
            Actions action = new Actions(driver);
        if(sideNavBars != null){
            for(int i = 1; i < sideNavBars.size() ; i++){
                WebElement navItem =wait.until(ExpectedConditions.visibilityOf(sideNavBars.get(i)));
                headerNames.add(navItem.getText());
                action.moveToElement(navItem).click().build().perform();


            }
        }
        }




        driver.quit();

    }

    public void performLogin(String userName, String password){
        if(userName != null && password != null){
            WebElement userNameEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username']")));
            userNameEle.click();
            userNameEle.clear();
            userNameEle.sendKeys(userName);

            WebElement passwordEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Passwort']")));
            passwordEle.click();
            passwordEle.clear();
            passwordEle.sendKeys(password);
            WebElement submitButtom = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='login-app']")));
            submitButtom.click();
        }

    }

    public boolean isPageChanged(){
        WebElement  sideNav = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sidebar toggled ng-star-inserted']")));
        return sideNav.isDisplayed();
    }

    public List<WebElement> getSideNavHeaders(){
        List<WebElement> sideNaveHeadings = wait.
                until(ExpectedConditions.
                presenceOfAllElementsLocatedBy(
                        By.xpath("//div[@class='sidebar toggled ng-star-inserted']//a[@data-target='#collapseExample']//span[@class='tab-name']"))
                );
       if(sideNaveHeadings.size() > 0){
           return sideNaveHeadings;
       }
       else{
           System.out.println("Elements not found for side navigation. Please update the Xpath if required");
           return null;
       }
    }
}
