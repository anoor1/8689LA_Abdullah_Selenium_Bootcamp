package testsearchflight;

import base.BasePage;
import booking.pom.homepage.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSearchFlight extends BasePage {
    @Test(priority= 4,groups={"BAT"})
    public void testSearchForFlight(){
        HomePage homePage= new HomePage();

        String countryName="Greece";
        homePage.doSearchFlights(countryName);

        Assert.assertTrue(isElementVisible(homePage.searchResults));
    }


}
