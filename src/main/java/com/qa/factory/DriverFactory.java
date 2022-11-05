package com.qa.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    protected static WebDriver driver;
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

    protected static WebDriverWait wait;

    //Initialize Browser and Driver Instance
    public WebDriver initializeDriver(String browser) {
        if(browser.isEmpty()){
            System.out.println("Please provide a valid browser name in config.properties file");
            return null;
        }
        else

        {
            if(browser.equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                tlDriver.set(new ChromeDriver());

            }

            else if (browser.equals("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                tlDriver.set(new FirefoxDriver());
            }

            else {
                System.out.println("Please provide valid browser information in config.properties file. Available options are chrome and firefox only");
            }


            getDriver().manage().deleteAllCookies();
            getDriver().manage().window().maximize();


            driver = getDriver();

            return driver;


        }
    }

    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }


}
