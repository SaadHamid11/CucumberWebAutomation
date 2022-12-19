package stepdefinitions;

import com.pages.accountpage.AccountPageHelpers;
import com.pages.accountpage.navigation.NavigationbarHelpers;
import com.pages.homepage.HomePageHelpers;
import com.pages.loginpage.LoginPageHelper;
import com.pages.loginpage.returningcustomer.ReturningCustomerHelpers;
import com.qa.factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class AccountPageSteps {

    private WebDriver driver = DriverFactory.getDriver();
    private HomePageHelpers homePage;
    private LoginPageHelper loginPage;
    private AccountPageHelpers accountPage;
    private ReturningCustomerHelpers accountHolder;
    private NavigationbarHelpers navigationBar;
    @Given("User is on My Account page")
    public void user_is_on_my_account_page() {
        // Write code here that turns the phrase above into concrete actions
        homePage = new HomePageHelpers(driver);
        homePage.gotoHomePage();
        loginPage = homePage.navigateLoginPage();
        accountHolder = loginPage.navigateToReturningCustomers();
        accountPage = accountHolder.doLogin("testuser.1","test1234");

    }

    @When("user hover over all Navigation items")
    public void user_hover_over_all_navigation_items() {
        // Write code here that turns the phrase above into concrete actions
        navigationBar = accountPage.getNavigationBar();
        navigationBar.getNavigationMenuItems();

    }

    @Then("tool tips appears for all navigation items")
    public void tool_tips_appears_for_all_navigation_items() {
        // Write code here that turns the phrase above into concrete actions
            navigationBar.hoverOverNavigationitem();
    }

    @And("tool tips text for all navigation items should be correct")
    public void tool_tips_text_for_all_navigation_items_should_be_correct(DataTable dataTable) {
               List<String> toolTips =  dataTable.asList();
               for(String text : toolTips){
                   Assert.assertTrue(navigationBar.isTooltipAvailable(text));
               }
    }

}
