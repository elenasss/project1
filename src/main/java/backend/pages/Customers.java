package backend.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.Browser;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Customers {
    private static List<Customer> customers;

    public Customers(List<Customer> customers) {
        this.customers = new ArrayList<>();
    }

    /**
     * Opens the customer groups page
     */
    public static void openCustomerGroupsPage() {
        Browser.driver.findElement(By.id("menu-customer")).click();
        Browser.driver.findElement(By.xpath("//a[text()='Customer Groups']")).click();
        assertEquals(Browser.driver.getTitle(), "Customer Groups", "You are not on the Customer Groups page");
    }

    /**
     * Opens the page Customers
     */
    public static void openCustomersPage() {
        Browser.driver.findElement(By.id("menu-customer")).click();
        Browser.driver.findElement(By.xpath("//li[@id='menu-customer']//a[text()='Customers']")).click();
        assertEquals(Browser.driver.getTitle(), "Customers", "You are not on the Customers page");
    }

    /**
     * adds new customer group
     */
    public static void addNewCustomerGroup(String groupName, String description) {
        Browser.driver.findElement(By.cssSelector("i.fa-plus")).click();
        Browser.driver.findElement(By.cssSelector("div.input-group>input.form-control")).sendKeys(groupName);
        Browser.driver.findElement(By.id("input-description1")).sendKeys(description);
        WebElement approval = Browser.driver.findElement(By.xpath("//input[@value=0]"));
        if (!approval.isSelected()) {
            approval.click();
        }
        Browser.driver.findElement(By.cssSelector("button.btn")).click();
    }

    /**
     * Asserts that the new customer group function is working
     *
     * @param addedNewCustomerGroupName the name of the added customer group
     * @param messageOnFailure          the message that will appear in the bug report in case of failure
     */
    public static void verifyAddNewGroupFunction(String addedNewCustomerGroupName, String messageOnFailure) {
        String customerDetails = Browser.driver.findElement(By.cssSelector("tbody")).getText();
        assertTrue(customerDetails.contains(addedNewCustomerGroupName), messageOnFailure);
    }

    /**
     * Adds new customer
     *
     * @param firstName        of the customer
     * @param lastName         of the customer
     * @param email            of the customer
     * @param phoneNumber      of the customer
     * @param password         of the customer
     * @param confirmPassword  of the customer
     * @param newsletterOption of the customer
     * @param statusOption     of the customer
     */
    public static void addNewCustomers(String groupName, String firstName, String lastName, String email, String phoneNumber,
                                       String password, String confirmPassword, String newsletterOption, String statusOption) {
        Browser.driver.findElement(By.cssSelector("i.fa-plus")).click();
        Select customerGroup = new Select(Browser.driver.findElement(By.id("input-customer-group")));
        customerGroup.selectByVisibleText(groupName);
        Browser.driver.findElement(By.id("input-firstname")).sendKeys(firstName);
        Browser.driver.findElement(By.id("input-lastname")).sendKeys(lastName);
        Browser.driver.findElement(By.id("input-email")).sendKeys(email);
        Browser.driver.findElement(By.id("input-telephone")).sendKeys(phoneNumber);
        Browser.driver.findElement(By.id("input-password")).sendKeys(password);
        Browser.driver.findElement(By.id("input-confirm")).sendKeys(confirmPassword);

        new Select(Browser.driver.findElement(By.id("input-newsletter"))).selectByVisibleText(newsletterOption);
        new Select(Browser.driver.findElement(By.id("input-status"))).selectByVisibleText(statusOption);

        Browser.driver.findElement(By.cssSelector("i.fa-save")).click();
    }


    /**
     * Asserts that the new customer was added successfully
     *
     * @param addedNewCustomerEmailAddress the email of the added customer
     * @param messageOnFailure             the message that will appear in the bug report in case of failure
     */
    public static void verifyAddNewCustomerFunction(String addedNewCustomerEmailAddress, String messageOnFailure) {

        if (Browser.driver.findElement(By.cssSelector(".alert-dismissible")).getText()
                .contains("E-Mail Address is already registered!")) {
            Browser.driver.findElement(By.cssSelector("i.fa-reply")).click();
            assertTrue(!Browser.driver.findElement(By.cssSelector(".fa-list")).isDisplayed(), "E-Mail Address is already registered");

        } else {
            Browser.driver.findElement(By.id("input-email")).sendKeys(addedNewCustomerEmailAddress);
            Browser.driver.findElement(By.id("button-filter")).click();
            String customerDetails = Browser.driver.findElement(By.cssSelector("tbody")).getText();
            assertTrue(customerDetails.contains(addedNewCustomerEmailAddress), messageOnFailure);
        }
    }


}
