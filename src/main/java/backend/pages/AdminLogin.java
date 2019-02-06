package backend.pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import utils.Browser;

public class AdminLogin {

    /**
     * Opens the administration login page of our project
     * http://shop.pragmatic.bg/admin
     */
    public static void open() {
        Browser.driver.get("http://shop.pragmatic.bg/admin");
    }

    /**
     * Logs into our administration area using the provided credentials, have in mind
     * that it also clicks the login button
     *
     * @param username the username you would like to login with
     * @param password the password you would like to login with
     */
    public static void login(String username, String password) {
        Browser.driver.findElement(By.id("input-username")).sendKeys(username);
        Browser.driver.findElement(By.id("input-password")).sendKeys(password);
        Browser.driver.findElement(By.cssSelector(".btn-primary")).click();
    }

    /**
     * Asserts that the login was unsuccessful
     * @param expectedLoginFormValidationMessage the message that you expect to be presented above the login form
     * @param messageOnFailure                   the message that will appear in the bug report in case of failure
     */
    public static void verifyLoginFormValidationMessage(String expectedLoginFormValidationMessage, String messageOnFailure) {
        String actualLoginFormValidationMessage = Browser.driver.findElement(By.cssSelector(".alert-danger")).getText();

        Assert.assertTrue(actualLoginFormValidationMessage.contains(expectedLoginFormValidationMessage), messageOnFailure);
    }
}
