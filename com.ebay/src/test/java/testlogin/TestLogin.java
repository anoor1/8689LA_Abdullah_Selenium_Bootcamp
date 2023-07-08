package testlogin;

import base.BasePage;
import ebay.pom.homepage.HomePage;
import ebay.pom.loginpage.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelData;

public class TestLogin extends BasePage {

    @Test(priority = 1, groups = {"BAT"}, dataProvider = "logindataprovider")
    public void testLogin(String email, String password) {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        homePage.clickOnSignInButton();
        loginPage.doSignIn(email, password);

        Assert.assertTrue(isElementVisible(homePage.welcomeUserDropdown));

    }


    @DataProvider(name = "logindataprovider")
    public String[][] loginDataProvider() {

        String path= System.getProperty("user.dir")+"\\src\\test\\resources\\test_data_ebay.xlsx";
        ExcelData ex = new ExcelData(path);
        String data[][] = ex.readStringArrays("login_ebay");
        return data;
    }
}
