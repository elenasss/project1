import backend.pages.AdminLogin;
import backend.pages.Customers;
import org.testng.annotations.*;
import utils.Browser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddNewCustomersTests {

     @BeforeClass
    public void setup() {
        Browser.open();
    }

    @Test
    public void addNewCustomerGroup() {
        AdminLogin.open();
        AdminLogin.login("admin", "parola123!");
        Customers.openCustomerGroupsPage();
        Customers.addNewCustomerGroup("New Group", "Group's description");
        Customers.verifyAddNewGroupFunction("New Group",
                "The add new customer group function is not working");
    }

    @DataProvider
    public Object[][] testData() throws IOException{
        return getTestData(
                "D:\\QA\\Automation\\project1\\datafile2.csv");
    }

    public String[][]getTestData(String fileName)throws IOException{
        List<String[]>records = new ArrayList<>();
        String record;

        BufferedReader file = new BufferedReader(new FileReader(fileName));
        record = file.readLine();
        while(record!=null){
            String fields[]=record.split(",");
            records.add(fields);
            record=file.readLine();
        }
        file.close();

        return records.toArray(new String[records.size()][]);
    }

    @Test (dataProvider = "testData")
    public void addNewCustomers(String groupName, String firstName, String lastName, String email, String phoneNumber,
                               String password, String confPassword, String option1, String option2,
                               String expectedEmail) throws Exception {
        AdminLogin.open();
        AdminLogin.login("admin", "parola123!");
        Customers.openCustomersPage();
        Customers.addNewCustomers(groupName,firstName, lastName, email, phoneNumber,
                password, confPassword, option1, option2);
        Customers.verifyAddNewCustomerFunction(expectedEmail,"Add new customer function is not working");
    }

    @AfterClass
    public void tearDown() {
        Browser.quit();
    }
}
