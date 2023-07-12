package testsearchstays;

import base.BasePage;
import booking.pom.homepage.HomePage;
import booking.pom.stayssearchresultpage.StaysSearchResultPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSearchHotels extends BasePage {

    @Test(priority = 1, groups = {"Smoke"})
    public void testSearchHotels(){
        HomePage homePage = new HomePage();
        StaysSearchResultPage staysSearchResultPage = new StaysSearchResultPage();
        homePage.doSearchStays();
        Assert.assertTrue(isElementVisible(staysSearchResultPage.propertiesFoundHeader));
    }
}
