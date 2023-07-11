package testshopparts;

import base.BasePage;
import mbusa.pom.homepage.HomePage;
import mbusa.pom.shoppartspage.ShopPartsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestShopParts extends BasePage {

    @Test(priority = 3,groups={"BAT"})
    public void testDoShopParts(){
        HomePage homePage=new HomePage();
        ShopPartsPage shopPartsPage=homePage.clickOnShoppingLink();
        shopPartsPage.doShopParts();
        Assert.assertTrue(isElementVisible(shopPartsPage.descriptiveText));

    }
}
