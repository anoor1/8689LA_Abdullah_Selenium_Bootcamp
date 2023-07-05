package testauthentication;

import base.BasePage;

import investing.pom.homepage.HomePage;
import investing.pom.resultpage.ResultPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelData;

public class TestAuthentication extends BasePage {

    @Test(priority = 1, groups = {"BAT"}, dataProvider = "logindataprovider")
    public void testLogin(String email, String password) {
        HomePage homePage= new HomePage();
        ResultPage resultPage = new ResultPage();
        homePage.doSignIn(email, password);
        Assert.assertTrue(isElementVisible(resultPage.resultsSum));


    }


    @DataProvider(name = "logindataprovider")
    public String[][] loginDataProvider() {

        String path= System.getProperty("user.dir")+"\\src\\test\\resources\\test_data.xlsx";
        ExcelData ex = new ExcelData(path);
        String data[][] = ex.readStringArrays("signin_investing");
        return data;
    }


    @Test(priority = 2, groups = {"BAT"}, dataProvider = "logoutdataprovider")
    public void testLogout(String email, String password) {
        HomePage homePage= new HomePage();
        homePage.doSignIn(email, password);
        homePage.doSignOut();
        Assert.assertTrue(isElementVisible(homePage.signInButton));


    }


    @DataProvider(name = "logoutdataprovider")
    public String[][] logoutDataProvider() {

        String path= System.getProperty("user.dir")+"\\src\\test\\resources\\test_data.xlsx";
        ExcelData ex = new ExcelData(path);
        String data[][] = ex.readStringArrays("signin_investing");
        return data;
    }
}
