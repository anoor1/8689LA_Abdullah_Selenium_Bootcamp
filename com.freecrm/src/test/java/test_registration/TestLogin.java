package test_registration;

import base.BasePage;
import freecrm.pom.homepage.HomePage;
import freecrm.pom.loginpage.DashboardPage;
import freecrm.pom.loginpage.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin extends BasePage {
@Test(priority= 1, groups= {"BAT"})

public void testLogin(){
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    homePage.clickOnLoginButton();
    String email = "anoor37290@gmail.com";
    String password = "Abcd1234!";
    loginPage.doSignIn(email, password);

    Assert.assertTrue(isElementVisible(dashboardPage.nameHeader));

}

    }


