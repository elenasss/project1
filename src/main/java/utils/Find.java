package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Find {
    public static WebElement byXpath(String xpath) {
        return Browser.driver.findElement(By.xpath(xpath));
    }

    public static WebElement byCss(String css) {
        return Browser.driver.findElement(By.cssSelector(css));
    }

    public static WebElement byId(String id) {
        return Browser.driver.findElement(By.id(id));
    }

    public static WebElement byClassName(String className) {
        return Browser.driver.findElement(By.className(className));
    }

    public static WebElement byPartialLink(String link) {
        return Browser.driver.findElement(By.partialLinkText(link));
    }

    public static WebElement byTagName(String tag) {
        return Browser.driver.findElement(By.tagName(tag));
    }
}
