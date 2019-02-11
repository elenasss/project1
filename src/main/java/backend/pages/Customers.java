package backend.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.Browser;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Customers {

    /**
     * Opens the customer groups page
     */
    public static void openCustomerGroupsPage() {
        FindElement.byId("menu-customer");
        FindElement.byXPathSelector("//a[text()='Customer Groups']");
        assertEquals(Browser.driver.getTitle(), "Customer Groups", "You are not on the Customer Groups page");
    }


    /**
     * adds new customer group
     */
    public static void addNewCustomerGroup(String groupName, String description) {
        FindElement.byCssSelector("i.fa-plus");
        Browser.driver.findElement(By.cssSelector("div.input-group>input.form-control")).sendKeys(groupName);
        Browser.driver.findElement(By.id("input-description1")).sendKeys(description);
        WebElement approval = Browser.driver.findElement(By.xpath("//input[@value=0]"));
        if (!approval.isSelected()) {
            approval.click();
        }
        FindElement.byCssSelector("button.btn");
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
     * Opens the page Customers
     */
    public static void openCustomersPage() {
        FindElement.byId("menu-customer");
        FindElement.byXPathSelector("//a[text()='Customers']");
        assertEquals(Browser.driver.getTitle(), "Customers", "You are not on the Customers page");
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
        FindElement.byCssSelector("i.fa-plus");
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

        FindElement.byCssSelector("i.fa-save");
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
            FindElement.byCssSelector("i.fa-reply");
            assertTrue(!Browser.driver.findElement(By.cssSelector(".fa-list")).isDisplayed(),
                    "E-Mail Address is already registered");
        } else {
            Browser.driver.findElement(By.id("input-email")).sendKeys(addedNewCustomerEmailAddress);
            FindElement.byId("button-filter");
            String customerDetails = Browser.driver.findElement(By.cssSelector("tbody")).getText();
            assertTrue(customerDetails.contains(addedNewCustomerEmailAddress), messageOnFailure);
        }
    }
}