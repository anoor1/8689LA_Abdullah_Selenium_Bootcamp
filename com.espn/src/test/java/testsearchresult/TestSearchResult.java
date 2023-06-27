package testsearchresult;

import base.BasePage;
import espn.pom.homepage.HomePage;
import espn.pom.searchresultpage.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSearchResult extends BasePage {

    @Test(priority= 1, groups= {"BAT"})
    public void testDoSearch(){
        HomePage homePage = new HomePage();
        SearchResultPage searchResultPage = new SearchResultPage();
        String searchTerm = "Tennis";
        homePage.searchForATerm(searchTerm);

        Assert.assertTrue(isElementVisible(searchResultPage.topResultHeader));

    }

}
