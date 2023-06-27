package testauthentication;

import apartments.pom.authenticationpage.SignInPage;
import apartments.pom.authenticationpage.SignUpPage;
import apartments.pom.homepage.HomePage;
import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelData;

public class TestSignIn extends BasePage {

    @Test(priority= 2, groups= {"BAT"},dataProvider = "signindataprovider")
    public void testUserSignIn(String firstname,String lastname,String email,String password){
        SignInPage signInPage = new SignInPage();
        HomePage homePage = new HomePage();
        homePage.clickFirstSignInButton();
        signInPage.doSignIn(email,password);
        Assert.assertTrue(checkElementPresent(homePage.loggedInUsername));
    }

    @DataProvider(name="signindataprovider")
    public Object[][] testSignInUserDataProvider()
    {

        String path= System.getProperty("user.dir")+"\\testdata\\test_data.xlsx";
        ExcelData ex=new ExcelData(path);
        String data[][]=ex.readStringArrays("signin_aparments.com");
        return data;

    }
}
