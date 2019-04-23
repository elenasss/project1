package utils;

import org.openqa.selenium.WebElement;

public class Command {
    public static void click(WebElement webelement) {
        webelement.click();
    }

    public static String getText(WebElement webelement) {
        return webelement.getText();
    }

    public static void sendKeys(WebElement webelement, String text) {
        webelement.sendKeys(text);
    }
}
