package stepdefinitions;

import com.pages.accountpage.AccountPageHelpers;
import com.pages.homepage.HomePageHelpers;
import com.pages.loginpage.LoginPageHelper;
import com.pages.productpage.ProductPageHelpers;
import com.pages.shoppingcartpage.ShoppingCartPageHelper;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class FeatureProductOrderSteps {

    private WebDriver driver = DriverFactory.getDriver();
    private HomePageHelpers homepage;
    private LoginPageHelper loginpage;
    private AccountPageHelpers accountPage;
    private ShoppingCartPageHelper shoppingCart;
    private double productPrice;

    private ProductPageHelpers productPage;
    @Given("user navigates to home page")
    public void user_navigates_to_home_page() {
        // Write code here that turns the phrase above into concrete actions
       homepage = new HomePageHelpers(driver);
       homepage.gotoHomePage();
    }

    @And("user is logged in the application")
    public void user_is_logged_in_the_application() {
        // Write code here that turns the phrase above into concrete actions
        loginpage = homepage.navigateLoginPage();
        accountPage =  loginpage.navigateToReturningCustomers().doLogin("testuser.1","TestPassword1");
        homepage = accountPage.navigateHomePage();

    }

    @Then("user verify feature section is visible")
    public void user_verify_feature_section_is_visible() {
        Assert.assertTrue("Featured Section is displayed", homepage.isFeaturedSectionDisplayed());

    }

    @When("User select a {string} from featured products")
    public void user_select_a_from_featured_products(String productName) {
        // Write code here that turns the phrase above into concrete actions
        homepage.createFeatureProductList();
        boolean isProductAvailable = homepage.verifyProductAvailability(productName);
        if(isProductAvailable){
            System.out.println("Required product: "+productName+" is available in Featured products list");
        }
        else{
            System.out.println("Required product: "+productName+" is not available in Featured products list");
        }
    }

    @And("user click on view button")
    public void user_click_on_view_button() {
        // Write code here that turns the phrase above into concrete actions
        homepage.clickOnViewProduct();
    }

    @Then("product page is displayed with {string}")
    public void product_page_is_displayed_with(String title) {
        // Write code here that turns the phrase above into concrete actions
        String pageTitle = title.trim();
       productPage= homepage.getProductPage();
       Assert.assertEquals(pageTitle,productPage.getPageTitle());
    }

    @And("product price is displayed")
    public void product_price_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
       productPrice = productPage.getPriceOfProduct();
       Assert.assertTrue("Product price is "+productPage, productPrice >=0);
    }

    @When("user add quantity as {string}")
    public void user_add_quantity_as(String qty) {
        // Write code here that turns the phrase above into concrete actions
        productPage.addQuantityOfProduct(qty);
    }

    @Then("total price is calculated")
    public void total_price_is_calculated() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(productPage.getTotalPriceFromUI(),productPage.calculateTotalPrice(),productPage.getTotalPriceFromUI());
    }

    @When("user clicks on Add to cart Button")
    public void user_clicks_on_add_to_cart_button() {
        // Write code here that turns the phrase above into concrete actions
        shoppingCart = productPage.clickAddToCart();
    }

    @Then("Shopping cart page is displayed")
    public void shopping_cart_page_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(shoppingCart!=null);
    }

    @And("Quantity is displayed as {string}")
    public void quantity_is_displayed_as(String qty) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(Double.parseDouble(qty),shoppingCart.getQuantityFromShoppingCart(), productPage.getQuantity());
    }

    @And("total price is displayed correctly")
    public void total_price_is_displayed_correctly() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(productPage.getTotalPriceOfProduct(), shoppingCart.getTotalPrice(), productPage.getTotalPriceOfProduct());
    }

    @And("product name is displayed correctly")
    public void product_name_is_displayed_correctly() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(homepage.getSearchedProduct(),shoppingCart.getProductName());
    }

    @When("user click on Checkout button")
    public void user_click_on_checkout_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Checkout confirmation page is displayed")
    public void checkout_confirmation_page_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user click on confirm order")
    public void user_click_on_confirm_order() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("order process page is displayed")
    public void order_process_page_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @And("{string} is displayed")
    public void is_displayed(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
