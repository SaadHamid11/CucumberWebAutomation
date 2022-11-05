package com.pages.loginpage;

import org.openqa.selenium.By;

public class LoginPageConstants {
    private static By accountLoginHeader = By.xpath("//h1[@class='heading1']//span[@class='maintext']");
    private static By returningCustomerHeader = By.xpath("//h2[text()='Returning Customer']");



    public static By getAccountLoginHeader() {
        return accountLoginHeader;
    }

    public static By getReturningCustomerHeader(){
        return returningCustomerHeader;
    }
}
