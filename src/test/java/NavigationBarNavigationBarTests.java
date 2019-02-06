import frontend.NavigationBar;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Browser;

public class NavigationBarNavigationBarTests {
    @BeforeMethod
    public void setup() {
        Browser.open();
    }

    @AfterMethod
    public void tearDown() {
        Browser.quit();
    }

    @Test
    public void testComponents() {
        NavigationBar.open();
        NavigationBar.checkComponents();
    }
}
