package testdynamictable;

import base.BasePage;
import investing.pom.homepage.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCommoditiesTab extends BasePage {


    @Test
    public void testCommoditiesTab(){
        HomePage homePage = new HomePage();
        homePage.clickOnCommoditiesTab();
        Assert.assertTrue(isElementVisible(homePage.commoditiesTable));

    }
}
