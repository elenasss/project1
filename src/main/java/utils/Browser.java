package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Browser {

    public static WebDriver driver;


    /**
     * This method opens a browser and sets an implicit wait of
     * 10 seconds
     */
    public static void open() {
        System.setProperty("webdriver.chrome.driver", "D:\\QA\\Automation\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    /**
     * Quits the opened browser
     */
    public static void quit() {
        Browser.driver.quit();
    }
}
