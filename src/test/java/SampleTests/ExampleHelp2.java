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
    Actions action;
    @Test
    public void Test1(){
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        wait = new WebDriverWait(driver, 10L);
        driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        action = new Actions(driver);
        driver.navigate().to("https://demo.simmeth.net/DEV/V6/Supply.Monitor.FE/login?isLogout=true");
        try {
            performLogin("k.mehmood","SSG@1234@abc");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(isPageChanged()){
        List<WebElement> sideNavBars = getSideNavHeaders();
        List<String> headerNames = new ArrayList<String>() ;

        if(sideNavBars != null){
            for(int i = 1; i < sideNavBars.size() ; i++){
                WebElement navItem =wait.until(ExpectedConditions.visibilityOf(sideNavBars.get(i)));
                headerNames.add(navItem.getText());
                action.moveToElement(navItem).click().build().perform();


            }
        }
        }


        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();

    }

    public void performLogin(String userName, String password) throws InterruptedException {
        if(userName != null && password != null){

            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='login-app']")));

            button.click();
            Thread.sleep(2000);
            WebElement userNameEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Username']")));
            action.moveToElement(userNameEle).click().sendKeys(userName).build().perform();

            WebElement passwordEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Password']")));
            action.moveToElement(passwordEle).click().sendKeys(password).build().perform();
            WebElement submitButtom = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='ActionSubmit']")));
            action.moveToElement(submitButtom).click().build().perform();
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
