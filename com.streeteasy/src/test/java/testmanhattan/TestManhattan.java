package testmanhattan;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import streeteasy.pom.homepage.HomePage;
import streeteasy.pom.manhattanpage.ManhattanPage;

public class TestManhattan extends BasePage {

    @Test(priority = 1, groups={"Smoke"})
    public void testManhattan(){
        HomePage homePage= new HomePage();
        homePage.goToManhattanPage();
        ManhattanPage manhattanPage = new ManhattanPage();
        manhattanPage.doSearchManhattan();
        Assert.assertTrue(isElementVisible(manhattanPage.assertSearchResult));
    }
}
