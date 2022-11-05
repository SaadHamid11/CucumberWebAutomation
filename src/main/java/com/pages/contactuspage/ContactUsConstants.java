package com.pages.contactuspage;

import org.openqa.selenium.By;

public class ContactUsConstants {

    private static By mainHeadingLocator = By.xpath("//h1[@class='heading1']");

    private static By firstNameLocator = By.xpath("//input[@name='first_name']");
    private static By emailLocator = By.xpath("//input[@id='ContactUsFrm_email']");
    private static By enquiryMessageBoxLocator = By.xpath("//textarea[@id='ContactUsFrm_enquiry']");

    private static By submitButtonLocator = By.xpath("//button[@title='Submit']");

    private static By messageLocator = By.xpath("//p[text()='Your enquiry has been successfully sent to the store owner!']");

    public static By getFirstNameLocator() {
        return firstNameLocator;
    }

    public static By getEmailLocator() {
        return emailLocator;
    }

    public static By getEnquiryMessageBoxLocator() {
        return enquiryMessageBoxLocator;
    }

    public static By getSubmitButtonLocator() {
        return submitButtonLocator;
    }

    public static By getMessageLocator() {
        return messageLocator;
    }

    public static By getMainHeadingLocator(){
        return mainHeadingLocator;
    }




}