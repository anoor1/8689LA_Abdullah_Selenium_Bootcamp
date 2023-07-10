package testlogin;

import base.BasePage;
import luma.pom.homepage.HomePage;
import luma.pom.loginpage.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin extends BasePage {
    @Test(priority = 2, groups = {"BAT"})
    public void testLogin() {
        LoginPage loginpage = new LoginPage();
        loginpage.login();
        Assert.assertTrue(isElementVisible(loginpage.welcompagetext));
        HomePage homepage = new HomePage();
        Assert.assertTrue(isElementVisible(homepage.logo));
    }
}
