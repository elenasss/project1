//import backend.pages.AdminLogin;
//import backend.pages.Products;
//import org.testng.annotations.*;
//import utils.Browser;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class AddNewProductsTests {
//
//    @BeforeTest
//    public void setup() throws IOException {
//        Browser.open();
//    }
//
//    @DataProvider
//    public Object[][] testData() throws IOException {
//        return getTestData(
//                "D:\\QA\\Automation\\project1\\datafile.csv");
//    }
//
//    public String[][] getTestData(String fileName) throws IOException {
//        List<String[]> records = new ArrayList<>();
//        String record;
//
//        BufferedReader file = new BufferedReader(new FileReader(fileName));
//        record = file.readLine();
//        while (record != null) {
//            String fields[] = record.split(",");
//            records.add(fields);
//            record = file.readLine();
//        }
//        file.close();
//
//        return records.toArray(new String[records.size()][]);
//    }
//
//    @Test(dataProvider = "testData")
//    public void addNewProducts(String name, String description, String tag, String model, String price,
//                               String outOfStock, String weight, String weightCategory,String image) throws Exception {
//
//        AdminLogin.open("http://shop.pragmatic.bg/admin");
//        AdminLogin.login("admin", "parola123!");
//        Products.openProductsPage();
//
//        Products.addNewProducts(name, description, tag, model, price, outOfStock, weight, weightCategory, image);
//        Products.verifyAddNewProductFunction("You have modified products",
//                "Add new product function is not working");
//    }
//
//    @AfterTest
//    public void tearDown() {
//        Browser.quit();
//    }
//}
//
