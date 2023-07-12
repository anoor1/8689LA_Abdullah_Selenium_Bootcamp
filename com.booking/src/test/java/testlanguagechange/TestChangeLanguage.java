package testlanguagechange;

import base.BasePage;
import booking.pom.homepage.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestChangeLanguage extends BasePage {

    @Test(priority = 1, groups = {"Smoke"})
    public void testChangeLanguage(){
        HomePage homePage = new HomePage();
        homePage.doChangeLanguage();
        Assert.assertTrue(isElementVisible(homePage.seConnecterButton));

    }
}
