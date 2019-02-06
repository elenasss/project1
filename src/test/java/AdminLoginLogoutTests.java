import backend.pages.AdminDashboard;
import backend.pages.AdminLogin;
import backend.pages.AdminLogout;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Browser;

public class AdminLoginLogoutTests {

    @BeforeMethod
    public void setup() {
        Browser.open();
    }

    @Test
    public void unsuccessfulLogin() {
        AdminLogin.open();
        AdminLogin.login("admin", "parola");

        AdminLogin.verifyLoginFormValidationMessage(
                "No match for Username and/or Password.",
                "There is no such message");
    }

    @Test
    public void successfulLogin() {
        AdminLogin.open();
        AdminLogin.login("admin", "parola123!");
        AdminDashboard.verifyUserFullName("Milen Strahinski", "The login was unsuccessful!");
    }


    @Test
    public void adminLogout() {
        AdminLogin.open();
        AdminLogin.login("admin", "parola123!");
        AdminLogout.logout();
        AdminLogout.adminLogoutVerification("The logout was unsuccessful", "Administration");

    }

    @AfterMethod
    public void tearDown() {
        Browser.quit();
    }
}
