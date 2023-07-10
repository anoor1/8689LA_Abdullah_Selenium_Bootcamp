package testnavigationtoapplication;

import base.BasePage;
import luma.pom.homepage.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNavigationToApplication extends BasePage {
    @Test(priority = 0, groups = {"BAT"})
    public void testNavigationToApplication() {
        HomePage homepage = new HomePage();

        Assert.assertTrue(isElementVisible(homepage.logo));
    }
}
