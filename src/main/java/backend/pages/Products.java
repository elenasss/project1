package backend.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.Browser;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Products {

    public static void openProductsPage() {
        Browser.driver.findElement(By.id("menu-catalog")).click();
        Browser.driver.findElement(By.xpath("//a[text()='Products']")).click();
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
                                      String price,String outOfStock, String weight, String weightCategory, String image) {

        JavascriptExecutor jse = (JavascriptExecutor) Browser.driver;

        Browser.driver.findElement(By.cssSelector("i.fa-plus")).click();
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
        Browser.driver.findElement(By.cssSelector(".img-thumbnail")).click();
        Browser.driver.findElement(By.cssSelector(".button-image")).click();
        WebElement UploadImg = Browser.driver.findElement(By.id("fa-upload"));
        UploadImg.sendKeys("D:\\QA\\Automation\\project1\\images\\" + image);

        Browser.driver.findElement(By.cssSelector("i.fa-save")).click();
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

