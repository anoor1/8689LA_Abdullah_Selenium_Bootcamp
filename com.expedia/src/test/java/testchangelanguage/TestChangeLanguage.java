package testchangelanguage;

import base.BasePage;
import expedia.pom.homepage.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestChangeLanguage extends BasePage {

    @Test(priority = 1, groups={"Smoke"})
    public void testChangeLanguage(){
        HomePage homePage = new HomePage();
        homePage.changeLanguage();
        Assert.assertTrue(isElementVisible(homePage.assertSpanishLanguageChange));

    }
}
