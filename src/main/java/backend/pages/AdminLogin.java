package backend.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.Browser;
import utils.Command;
import utils.ExplicitWait;
import utils.Find;

import java.io.File;

public class AdminLogin {

    /**
     * Opens the administration login page of our project
     * http://shop.pragmatic.bg/admin
     */
    public static void open(String website) {
        Browser.openSite(website);
    }

    /**
     * Logs into our administration area using the provided credentials
     * @param username the username you would like to login with
     * @param password the password you would like to login with
     */
    public static void login(String username, String password) {
        Command.sendKeys(Find.byId("input-username"), username);
        Command.sendKeys(Find.byId("input-password"), password);
        Command.click(Find.byCss(".btn-primary"));
    }

    /**
     * Asserts that the login was unsuccessful
     * @param expectedLoginFormValidationMessage the message that you expect to be presented above the login form
     * @param messageOnFailure                   the message that will appear in the bug report in case of failure
     */
    public static void verifyLoginFormValidationMessage(String expectedLoginFormValidationMessage, String messageOnFailure) {
        String actualLoginFormValidationMessage = Command.getText(Find.byCss(".alert-danger"));
        Assert.assertTrue(actualLoginFormValidationMessage.contains(expectedLoginFormValidationMessage), messageOnFailure);
    }
}
