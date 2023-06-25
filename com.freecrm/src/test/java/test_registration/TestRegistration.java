package test_registration;

import base.BasePage;
import freecrm.pom.homepage.HomePage;
import freecrm.pom.signuppage.SignUpPage;
import freecrm.pom.signuppage.ValidatePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelData;

public class TestRegistration extends BasePage {
@Test(priority= 1, groups= {"BAT"})

public void TestSignUp(){
    HomePage homepage= new HomePage();
    SignUpPage signUpPage=new SignUpPage();
    ValidatePage validationPage = new ValidatePage();
    String emailAddress= "abd123@gmail.com";
    String email = emailAddress;

    homepage.clickSignUpButton();
    signUpPage.signUp(email);
    Assert.assertTrue(isElementVisible(validationPage.checkYourEmailText));
}

    }


