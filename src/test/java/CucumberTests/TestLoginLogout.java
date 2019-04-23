package CucumberTests;

import backend.pages.AdminLogin;
import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

import utils.Browser;

import java.io.IOException;

public class TestLoginLogout {
    @Before
    public void setup() throws IOException {
        Browser.open();
    }

    @After
    public void tearDown() {
        Browser.quit();
    }

    @Given("the user is on the landing page")
    public void the_user_is_on_the_landing_page() {
        Browser.openSite("http://shop.pragmatic.bg/admin");
    }

    @When("user login with correct {string} and {string}")
    public void the_user_login_with_correct_username_and_password(String username, String password) {
        AdminLogin.login(username, password);
    }
    @When("^the user login with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void theUserLoginWithUsernameAndPassword(String username, String password){
        AdminLogin.login(username, password);
    }

    @Then("the user is transferred to main admin page")
    public void the_user_is_transferred_to_main_admin_page() {
        AdminLogin.verifyLoginFormValidationMessage("Milen Strahinski", "The login was unsuccessful!");
    }


}


