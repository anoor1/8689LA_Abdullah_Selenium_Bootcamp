package testsearchflight;

import base.BasePage;
import expedia.pom.flightresultpage.FlightResultPage;
import expedia.pom.homepage.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestFlightSearch extends BasePage {

    @Test
    public void testSearchFlight(){
        HomePage homePage = new HomePage();
        FlightResultPage flightResultPage = new FlightResultPage();
        String leavingFrom = "New Orleans";
        String goingTo = "Greece";
        homePage.doFlightSearch(leavingFrom, goingTo);
        Assert.assertTrue(isElementVisible(flightResultPage.cheapestDepartingFlight));

    }
}
