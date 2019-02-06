package backend.pages;

import org.openqa.selenium.By;
import utils.Browser;

public class NavigationPages {

    /**
     * This method will open a page from a Navigation using CSS Selector
     * @param pageCssSelectors Css Selector for the certain page
     */
    public static void goToPageWithCssSelector(String pageCssSelectors){
        Browser.driver.findElement(By.cssSelector(pageCssSelectors)).click();
    }

    /**
     * This method will open a page from a Navigation using XPath Location
     * @param pagePathLocating XPath Location for the certain page
     */
    public static void goToPageWithXPathSelector(String pagePathLocating){
        Browser.driver.findElement(By.xpath(pagePathLocating)).click();
    }


}
