package testlogin;

import base.BasePage;

import investing.pom.homepage.HomePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelData;

public class TestLogin extends BasePage {

    @Test(priority = 1, groups = {"BAT"}, dataProvider = "logindataprovider")
    public void testLogin(String email, String password) {
        HomePage homePage= new HomePage();
        homePage.doSignIn(email, password);


    }


    @DataProvider(name = "logindataprovider")
    public String[][] loginDataProvider() {

        String path= System.getProperty("user.dir")+"\\src\\test\\resources\\test_data.xlsx";
        ExcelData ex = new ExcelData(path);
        String data[][] = ex.readStringArrays("signin_investing");
        return data;
    }
}
