package test_registration;

import apartments.pom.signuppage.SignUpPage;
import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelData;

public class TestRegistration extends BasePage {

    @Test(priority= 1, groups= {"BAT"},dataProvider = "signupdataprovider")
    public void userSignUp(String firstname,String lastname,String email,String password){
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.doSignUp(firstname,lastname,email,password);
        Assert.assertTrue(checkElementPresent(signUpPage.loggedInUsername));
    }

    @DataProvider(name="signupdataprovider")
    public String[][] signupUserDataProvider()
    {

        String path= System.getProperty("user.dir")+"\\testdata\\test_data.xlsx";
        ExcelData ex=new ExcelData(path);
        String data[][]=ex.readStringArrays("signup_aparments.com");
        return data;

    }
}
