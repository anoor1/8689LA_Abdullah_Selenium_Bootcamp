package testcoronapage;

import base.BasePage;
import booking.pom.attractionspage.AttractionsPage;
import booking.pom.coronaviruspage.CoronaVirusPage;
import booking.pom.homepage.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCoronaPage extends BasePage {

    @Test(priority = 1, groups = {"Smoke"})
    public void testCoronaPage(){
        AttractionsPage attractionsPage = new AttractionsPage();
        CoronaVirusPage coronaVirusPage = new CoronaVirusPage();
        HomePage homePage = new HomePage();
        homePage.clickOnAttractionsButton();
        attractionsPage.doSearchForCoronaInfo();
        switchToTab();
        Assert.assertTrue(isElementVisible(coronaVirusPage.coronaHelpPrompt));
    }
}
