package testaddtocart;

import base.BasePage;
import ebay.pom.homepage.HomePage;
import ebay.pom.searchresultpage.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAddToCart extends BasePage {

    @Test(priority=1, groups={"smoke"})
    public void testAddToCart(){
        HomePage homePage = new HomePage();
        SearchResultPage searchResultPage = new SearchResultPage();
        String searchTerm = "cat food";
        homePage.doSearch(searchTerm);
        searchResultPage.doAddCart();
        //Assert.assertTrue(isElementVisible(searchResultPage.goToCheckoutButton));
    }


}
