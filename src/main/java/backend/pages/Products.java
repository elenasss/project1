package backend.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import utils.Browser;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Products {

    public static void openProductsPage() {
        FindElement.byId("menu-catalog");
        FindElement.byXPathSelector("//a[text()='Products']");
        assertEquals(Browser.driver.getTitle(), "Products", "You are not on the Products page");
    }

    /**
     * This method will add new products
     *
     * @param name           the name of the product
     * @param description    the description of the product
     * @param tag            meta tag
     * @param model          The model of the product
     * @param outOfStock     Status shown when the product is out of stock
     * @param weight         the weight of the product
     * @param weightCategory the weight category - kg/gram/pound/ounce
     * @param image          the image to upload
     */
    public static void addNewProducts(String name, String description, String tag, String model,
                                      String price, String outOfStock, String weight, String weightCategory, String image) throws AWTException, InterruptedException {

        JavascriptExecutor jse = (JavascriptExecutor) Browser.driver;

//        Browser.driver.findElement(By.cssSelector("i.fa-plus")).click();
        FindElement.byCssSelector("i.fa-plus");
        Browser.driver.findElement(By.id("input-name1")).sendKeys(name);
        Browser.driver.findElement(By.cssSelector(".note-editable")).sendKeys(description);
        jse.executeScript("scroll(0, 250);");
        Browser.driver.findElement(By.id("input-meta-title1")).sendKeys(tag);

        jse.executeScript("scroll(0, -250);");
        Browser.driver.findElement(By.partialLinkText("Data")).click();
        Browser.driver.findElement(By.id("input-model")).sendKeys(model);
        Browser.driver.findElement(By.id("input-price")).sendKeys(price);
        jse.executeScript("scroll(0, 250);");
        Select outOfStockStatus = new Select(Browser.driver.findElement(By.id("input-stock-status")));
        outOfStockStatus.selectByVisibleText(outOfStock);
        jse.executeScript("scroll(0, 250);");
        Browser.driver.findElement(By.id("input-weight")).sendKeys(weight);
        Select weightClass = new Select(Browser.driver.findElement(By.id("input-weight-class")));
        weightClass.selectByVisibleText(weightCategory);
        jse.executeScript("scroll(0, 500);");

        Browser.driver.findElement(By.partialLinkText("Image")).click();
        FindElement.byId(".img-thumbnail");
        FindElement.byCssSelector("#button-image");
        FindElement.byId("button-upload");

        StringSelection ss = new StringSelection("D:\\QA\\Automation\\project1\\images\\1.JPG");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);

        Alert alert = Browser.driver.switchTo().alert();
        alert.accept();
        FindElement.byXPathSelector("//img[@title='1.jpg']");
        FindElement.byCssSelector("i.fa-save");
    }


    /**
     * Asserts that the product was added successfully
     *
     * @param displayedMessage displayed message
     * @param messageOnFailure the message that will appear in the bug report in case of failure
     */
    public static void verifyAddNewProductFunction(String displayedMessage, String messageOnFailure) {
        assertTrue(!Browser.driver.findElement(By.cssSelector(".alert-dismissible")).getText()
                .contains(displayedMessage), messageOnFailure);
    }
}

