package testauthentification;

import base.BasePage;
import expedia.pom.homepage.HomePage;
import expedia.pom.signinpage.LoginPage;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import utils.ExcelData;

public class TestLogin extends BasePage {

    @Test(priority = 1, groups = {"BAT"}, dataProvider = "logindataprovider")

    public void testLogin(String email, String password) {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();


        homePage.clickOnSignInLink();
        homePage.clickOnSignIButton1();
        loginPage.doSignIn(email, password);


        //Assert.assertTrue(isElementVisible(dashboardPage.nameHeader));

    }

    @DataProvider(name = "logindataprovider")
    public String[][] loginDataProvider() {

        String path = System.getProperty("user.dir") + "\\src\\test\\resources\\test_data_expedia.xlsx";
        ExcelData ex = new ExcelData(path);
        String data[][] = ex.readStringArrays("Sign in_expedia");
        return data;

    }
}
//    @Test(priority = 2, groups={"smoke"}, dataProvider = "logindataprovider")
//
//    public void testLogOut(String email,String pass){
//        HomePage homePage= new HomePage();
//        LoginPage loginPage = new LoginPage();
//
//
//        homePage.clickOnLoginButton();
//
//
//        loginPage.doSignIn(email,pass);
//        dashboardPage.doLogOut();
//
//        Assert.assertTrue(isElementVisible(loginPage.loginButton));
//    }
//
//
//}
