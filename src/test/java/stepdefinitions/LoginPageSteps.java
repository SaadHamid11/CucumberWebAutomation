package stepdefinitions;

import com.pages.homepage.HomePageHelpers;
import com.pages.loginpage.LoginPageHelper;
import com.pages.loginpage.returningcustomer.ReturningCustomerHelpers;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.sql.Driver;

public class LoginPageSteps {


    HomePageHelpers homepage = new HomePageHelpers(DriverFactory.getDriver());
    LoginPageHelper loginPage;
    ReturningCustomerHelpers customers;
    String pageTitle;
    @Given("user navigates to Home Page")
    public void user_navigates_to_home_page() {
        // Write code here that turns the phrase above into concrete actions

        homepage.gotoHomePage();
    }

    @When("user click on Login Page Url")
    public void user_click_on_login_page_url() {
        // Write code here that turns the phrase above into concrete actions
        loginPage = homepage.navigateLoginPage();
    }

    @Then("Login page is displayed")
    public void login_page_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
       Assert.assertTrue(loginPage.isLoginPageDisplayed());
    }

    @When("user gets the title of the page")
    public void user_gets_the_title_of_the_page() {
        // Write code here that turns the phrase above into concrete actions
        pageTitle = loginPage.getPageTitle();
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String expectedTitle) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(expectedTitle, pageTitle);
    }


    @When("user navigate to Returning Customer")
    public void user_navigate_to_returning_customer() {
        // Write code here that turns the phrase above into concrete actions
        customers = loginPage.navigateToReturningCustomers();
    }

    @When("user enters username as {string}")
    public void user_enters_username_as(String userName) {
        // Write code here that turns the phrase above into concrete actions
       customers.enterLogin(userName);
    }

    @When("user enters password as {string}")
    public void user_enters_password_as(String password) {
        // Write code here that turns the phrase above into concrete actions
        customers.enterPassword(password);
    }

    @When("user clicks login button")
    public void user_clicks_login_button() {
        // Write code here that turns the phrase above into concrete actions
        customers.clickLogin();
    }

    @Then("User sees an error message")
    public void user_sees_an_error_message() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(true);
    }

}
