package stepdefinitions;

import com.pages.contactuspage.ContactUsHelpers;
import com.pages.homepage.HomePageHelpers;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ContactUsSteps {

    HomePageHelpers homePage = new HomePageHelpers(DriverFactory.getDriver());
    ContactUsHelpers contactUs;
    @Given("User navigates to Contact us Page")
    public void user_navigates_to_contact_us_page() {
        // Write code here that turns the phrase above into concrete actions
        homePage.gotoHomePage();
       contactUs =  homePage.navigateContactUsPage();


    }

    @When("user enters data from {string} ,{string}, {string}")
    public void user_enters_data_from(String name, String email, String enquiryText) {
        // Write code here that turns the phrase above into concrete actions
       contactUs.fillOutContactForm(name, email, enquiryText);
    }

    @And("submit the form")
    public void submit_the_form() {
        // Write code here that turns the phrase above into concrete actions
            contactUs.clickSubmitButton();
    }

    @Then("user gets the message as {string}")
    public void user_gets_the_message_as(String confirmationMessage) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(contactUs.validateTextMessage(confirmationMessage));
    }


}
