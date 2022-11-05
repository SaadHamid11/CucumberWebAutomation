package com.pages.contactuspage;

import com.qa.util.ElementUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactUsHelpers {

    private WebDriver driver;
    private ElementUI utils;

    public ContactUsHelpers(WebDriver driver){
        this.driver = driver;
        utils = new ElementUI(driver);
    }


    private void enterName(String name){

            WebElement nameElement = utils.waitForElementToAppearOnDOM(ContactUsConstants.getFirstNameLocator());
            utils.sendKeys(nameElement,name);


    }

    private void enterEmail(String email){


                WebElement emailElement = utils.waitForElementToAppearOnDOM(ContactUsConstants.getEmailLocator());
                utils.sendKeys(emailElement, email);


    }

    private void enterEnquiryTextArea(String text){

            WebElement enquiryTextAreaElement = utils.waitForElementToAppearOnDOM(ContactUsConstants.getEnquiryMessageBoxLocator());
            utils.sendKeys(enquiryTextAreaElement,text);

    }

    public void clickSubmitButton(){
        WebElement submitButtonElement = utils.waitForElementToAppearOnDOM(ContactUsConstants.getSubmitButtonLocator());
        utils.clickElement(submitButtonElement);
    }

    private boolean getTextMessage(String message){
        WebElement confirmationTextElement = utils.waitForElementToAppearOnDOM(ContactUsConstants.getMessageLocator());
        if(confirmationTextElement.getText().equals(message)){
            return true;
        }
        else {
            return false;
        }
    }


    public void fillOutContactForm(String name, String email, String enquiryText ){
        enterName(name);
        enterEmail(email);
        enterEnquiryTextArea(enquiryText);


    }




    public boolean validateTextMessage(String confirmationText){
        return getTextMessage(confirmationText);
    }

}
