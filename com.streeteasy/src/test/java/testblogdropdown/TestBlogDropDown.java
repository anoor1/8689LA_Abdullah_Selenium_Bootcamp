package testblogdropdown;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import streeteasy.pom.homepage.HomePage;
import streeteasy.pom.marketdatapage.MarketDataPage;

public class TestBlogDropDown extends BasePage {

    @Test(priority= 1, groups= {"smoke"})
    public void testBlogDropdown(){
        HomePage homePage = new HomePage();
        MarketDataPage marketDataPage = new MarketDataPage();
        homePage.checkForMarketHeader();
        Assert.assertTrue(isElementVisible(marketDataPage.marketDataHeader));
    }



}
