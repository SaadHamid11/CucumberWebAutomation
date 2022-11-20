package SampleTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExampleHelp {

    @Test
    public void Demo(){
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, 10L);
        driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.navigate().to("https://demo.simmeth.net/DEV/V6/Supply.Monitor.FE/login?isLogout=true");
        WebElement resetPassword = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=' Passwort zurücksetzen ']")));
        resetPassword.click();

        WebElement resetPageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='pr_id_3-label']")));
        if(resetPageTitle.isDisplayed()){
            WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='reset-user']")));
            inputField.click();
            inputField.clear();
            inputField.sendKeys("SampleText");
            WebElement submit =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='btn-send-reset']")));
            submit.click();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }
}
