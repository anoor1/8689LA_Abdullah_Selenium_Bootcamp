package testattractionsbutton;

import base.BasePage;
import booking.pom.attractionspage.AttractionsPage;
import booking.pom.homepage.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAttractionsButton extends BasePage {

    @Test(priority = 1, groups = {"Smoke"})
    public void testAttractionsPage(){
        HomePage homePage = new HomePage();
        AttractionsPage attractionsPage = new AttractionsPage();
        homePage.clickOnAttractionsButton();
        attractionsPage.clickOnDesiredAttraction();
        Assert.assertTrue(isElementVisible(attractionsPage.attractionsHeaderAssert));

    }
}
