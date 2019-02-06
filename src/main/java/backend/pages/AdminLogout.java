package backend.pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import utils.Browser;

/**
 * Logout from the administration area
 */
public class AdminLogout {
    public static void logout () {
        Browser.driver.findElement(By.partialLinkText("Logout")).click();

    }
    public static void adminLogoutVerification(String failingMessage, String TabTitle) {
        Assert.assertTrue(Browser.driver.getTitle().contains(TabTitle), failingMessage);
    }
}
