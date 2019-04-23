import backend.pages.AdminDashboard;
import backend.pages.AdminLogin;
import backend.pages.AdminLogout;
import org.testng.annotations.*;
import utils.Browser;

import java.io.IOException;

public class AdminLoginLogoutTests {

    @BeforeTest
    public void setup() throws IOException {
        Browser.open();
    }


    @Test //(groups={"Smoke"})
    public void unsuccessfulLogin(){
        AdminLogin.open("http://shop.pragmatic.bg/admin");
        AdminLogin.login("admin", "parola");
        AdminLogin.verifyLoginFormValidationMessage(
                ".",
                "There is no such message");
    }


    @Test //dependsOnMethods={"unsuccessfulLogin"}) -> will perform after test unsuccessfulLogin
    public void successfulLogin(){
        AdminLogin.open("http://shop.pragmatic.bg/admin");
        AdminLogin.login("admin", "parola123!");
        AdminDashboard.verifyUserFullName("Milen Strahinski", "The login was unsuccessful!");
    }


    @Test //(enabled=false)->will skip the test
    public void adminLogout() {
        AdminLogin.open("http://shop.pragmatic.bg/admin");
        AdminLogin.login("admin", "parola123!");
        AdminLogout.logout();
        AdminLogout.adminLogoutVerification("The logout was unsuccessful", "Administration");

    }

//    @Parameters({"username", "password"}) //can be run only through testNG
//    @Test(timeOut=4000)
//    public void newTest(String username, String password){
//        AdminLogin.open("http://shop.pragmatic.bg/admin");
//        AdminLogin.login(username, password);
//    }

    @AfterTest
    public void tearDown() {
        Browser.quit();
    }
}
