package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Browser {

    public static WebDriver driver;

    /**
     * This method opens a browser and sets an implicit wait of
     * 10 seconds
     */
    public static void open() throws IOException {
        Properties properties = new Properties();
        FileInputStream file = new FileInputStream("D:\\Elena\\project1\\datadriven.properties");
        properties.load(file);

        if (properties.getProperty("browser").contains("chrome")) {
            System.setProperty("webdriver.chrome.driver", "D:\\Elena\\Automation\\Drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } else {
            System.setProperty("webdriver.gecko.driver", "D:\\Elena\\Automation\\Drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    /**
     * Open the website
     *
     * @param website - the website that should be opened
     */

    public static void openSite(String website) {
        driver.get(website);
    }

    /**
     * Quits the opened browser
     */
    public static void quit() {
        driver.quit();
    }

    public static void getScreenshots(String result) throws IOException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Date date = new Date();
        String screenshot = dateFormat.format(date);
        File scrFile = ((TakesScreenshot) Browser.driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("D://" + result + " " + screenshot + ".png"));
    }
}
