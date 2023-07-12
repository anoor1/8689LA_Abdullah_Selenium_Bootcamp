package testdynamictable;

import base.BasePage;
import investing.pom.homepage.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestIndicesTab extends BasePage {

    @Test(priority = 1, groups = {"Smoke"})
    public void testIndicesTabIsPresent(){
        HomePage  homePage = new HomePage();
        Assert.assertTrue(isElementVisible(homePage.indicesTable));
    }
}
