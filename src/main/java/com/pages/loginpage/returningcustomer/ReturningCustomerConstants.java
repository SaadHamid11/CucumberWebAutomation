package com.pages.loginpage.returningcustomer;

import org.openqa.selenium.By;

public class ReturningCustomerConstants {

    private static By loginName = By.xpath("//input[@id='loginFrm_loginname']");
    private static By password = By.xpath("//input[@id='loginFrm_password']");
    private static By loginButton = By.xpath("//button[@title='Login']");


    public static By getLoginName() {
        return loginName;
    }

    public static By getPassword() {
        return password;
    }

    public static By getLoginButton() {
        return loginButton;
    }
}
