package testembeddedmedia;

import base.BasePage;
import espn.pom.homepage.HomePage;
import espn.pom.tennispage.TennisPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestEmbeddedMedia extends BasePage {

    @Test(priority = 1, groups = {"Smoke"})
    public void testEmbeddedMediaPlayer(){
        HomePage homePage = new HomePage();
        TennisPage tennisPage = new TennisPage();
        homePage.hoverOverTennisDropdown();
        homePage.clickOnTennisHomeButton();
        Assert.assertTrue(isElementVisible(tennisPage.embeddedMediaSource));
    }
}
