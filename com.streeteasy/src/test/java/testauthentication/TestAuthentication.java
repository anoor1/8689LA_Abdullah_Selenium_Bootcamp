package testauthentication;

import base.BasePage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import streeteasy.pom.homepage.HomePage;
import utils.ExcelData;

public class TestAuthentication extends BasePage {

    @Test(priority = 1, groups = {"BAT"}, dataProvider = "LoginDataProvider")
    public void testLogin(String email, String password) {
        HomePage homePage = new HomePage();
        homePage.DoSignIn(email, password);

    }


    @DataProvider(name = "LoginDataProvider")
    public String[][] loginDataProvider() {

        String path= System.getProperty("user.dir")+"\\src\\test\\resources\\test_data.xlsx";
        ExcelData ex = new ExcelData(path);
        String data[][] = ex.readStringArrays("signin_streeteasy");
        return data;
    }
}
