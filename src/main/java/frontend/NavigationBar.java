package frontend;

import org.openqa.selenium.By;
import utils.Browser;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class NavigationBar {

    /**
     * Opens the website
     * http://shop.pragmatic.bg
     */
    public static void open() {
        Browser.driver.get("http://shop.pragmatic.bg");
    }

    /**
     * Checks and verifies components in the navigation bar
     */
    public static void checkComponents() {
        List<String> components = Arrays.asList("Mice and Trackballs", "Monitors", "Printers", "Scanners", "Web Cameras");
        for (int i = 0; i < components.size(); i++) {
            Browser.driver.findElement(By.partialLinkText("Components")).click();
            Browser.driver.findElement(By.partialLinkText(components.get(i))).click();
            assertTrue(Browser.driver.getTitle().equalsIgnoreCase(components.get(i)), components.get(i) + "was not found");
        }
    }
}
