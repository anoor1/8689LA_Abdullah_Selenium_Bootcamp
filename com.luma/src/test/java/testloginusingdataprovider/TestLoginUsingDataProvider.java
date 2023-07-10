package testloginusingdataprovider;

import base.BasePage;
import luma.pom.homepage.HomePage;
import luma.pom.loginpage.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelData;

public class TestLoginUsingDataProvider extends BasePage {
    @Test(priority = 4, groups = {"BAT"},dataProvider = "datalogin")
    public void testLoginUsingDataProvider(String emailId,String password) {
        LoginPage loginpage = new LoginPage();
        loginpage.loginwithparam(emailId, password);
        HomePage homepage = new HomePage();

        Assert.assertTrue(isElementVisible(homepage.logo));
    }



    @DataProvider(name="datalogin")
    public String[][] loginDataProvider()
    {

        String path= System.getProperty("user.dir")+"\\src\\test\\resources\\test_data.xlsx";;
        ExcelData ex=new ExcelData(path);
        String data[][]=ex.readStringArrays("signin");
        return data;

    }
}
