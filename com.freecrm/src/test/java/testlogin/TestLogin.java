package testlogin;

import base.BasePage;
import freecrm.pom.homepage.HomePage;
import freecrm.pom.loginpage.DashboardPage;
import freecrm.pom.loginpage.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelData;

public class TestLogin extends BasePage {
@Test(priority= 1, groups= {"BAT"},dataProvider = "logindataprovider")

public void testLogin(String email,String pass){
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    homePage.clickOnLoginButton();

    loginPage.doSignIn(email, pass);

    Assert.assertTrue(isElementVisible(dashboardPage.nameHeader));

}
    @DataProvider(name="logindataprovider")
    public String[][] loginDataProvider()
    {

        String path= System.getProperty("user.dir")+"\\testdata\\test_data.xlsx";
        ExcelData ex=new ExcelData(path);
        String data[][]=ex.readStringArrays("login_crm");
        return data;

    }
    @Test(priority = 2, groups={"smoke"}, dataProvider = "logindataprovider")

    public void testLogOut(String email,String pass){
        HomePage homePage= new HomePage();
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage=new DashboardPage();

        homePage.clickOnLoginButton();


        loginPage.doSignIn(email,pass);
        dashboardPage.doLogOut();

        Assert.assertTrue(isElementVisible(loginPage.loginButton));
    }
    }



