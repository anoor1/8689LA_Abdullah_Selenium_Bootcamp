package testauthentication;

import apartments.pom.homepage.HomePage;
import apartments.pom.authenticationpage.SignUpPage;
import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelData;

public class TestSignUp extends BasePage {

    @Test(priority= 1, groups= {"BAT"},dataProvider = "signupdataprovider")
    public void testUserSignUp(String firstname,String lastname,String email,String password){
        SignUpPage signUpPage = new SignUpPage();
        HomePage homePage = new HomePage();
        signUpPage.doSignUp(firstname,lastname,email,password);
        Assert.assertTrue(checkElementPresent(homePage.loggedInUsername));
    }

    @DataProvider(name="signupdataprovider")
    public String[][] testSignupUserDataProvider()
    {

        String path= System.getProperty("user.dir")+"\\testdata\\test_data.xlsx";
        ExcelData ex=new ExcelData(path);
        String data[][]=ex.readStringArrays("signup_aparments.com");
        return data;

    }
}
