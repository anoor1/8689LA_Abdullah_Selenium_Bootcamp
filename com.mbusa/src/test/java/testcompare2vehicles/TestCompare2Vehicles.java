package testcompare2vehicles;

import base.BasePage;
import mbusa.pom.homepage.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCompare2Vehicles extends BasePage {

    @Test(priority = 1, groups = {"Smoke"})
    public void testCompareVehicles(){
        HomePage homePage = new HomePage();
        homePage.compareTwoVehicles();
        Assert.assertTrue(isElementVisible(homePage.featureHighlightsHeader));
    }
}
