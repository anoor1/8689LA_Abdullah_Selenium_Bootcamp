package testdynamictable;

import base.BasePage;
import investing.pom.homepage.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestStocksTab extends BasePage {
    @Test
    public void testStocksTab(){
        HomePage homePage = new HomePage();
        homePage.clickOnStocksTab();
        Assert.assertTrue(isElementVisible(homePage.stocksTable));

    }
}
