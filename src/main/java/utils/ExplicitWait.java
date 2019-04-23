package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
    public static void getText(String expectedLoginFormValidationMessage, String locator) {

        new WebDriverWait(Browser.driver, 5).until((WebDriver d) -> d.findElement(By.cssSelector(locator))
                .getText().contains(expectedLoginFormValidationMessage));
    }
}