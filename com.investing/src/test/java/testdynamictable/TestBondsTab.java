package testdynamictable;

import base.BasePage;
import config.BaseConfig;
import investing.pom.homepage.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestBondsTab extends BasePage {

    @Test
    public void testBondsTab(){
        HomePage homePage = new HomePage();
        homePage.clickOnBondsTab();
        Assert.assertTrue(isElementVisible(homePage.bondsTable));

    }
}
