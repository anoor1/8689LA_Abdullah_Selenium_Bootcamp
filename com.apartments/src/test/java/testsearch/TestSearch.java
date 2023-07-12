package testsearch;

import apartments.pom.authenticationpage.SignInPage;
import apartments.pom.homepage.HomePage;
import apartments.pom.resultsearchpage.ResultSearchPage;
import apartments.pom.searchpage.SearchPage;
import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelData;

public class TestSearch extends BasePage {
    @Test(priority= 3, groups= {"BAT"},dataProvider = "searchDataProvider")

    public void testDoSearch(String searchTerm){
        HomePage homePage = new HomePage();
        SignInPage signInPage = new SignInPage();
        SearchPage searchPage= new SearchPage();
        ResultSearchPage resultSearchPage= new ResultSearchPage();

        homePage.clickFirstSignInButton();
        String email="anoor1@gmail.com";
        String password="Piit123!";

        signInPage.doSignIn(email,password);

        searchPage.searchTerm(searchTerm);
        resultSearchPage.doSearch();


        Assert.assertTrue(isElementVisible(resultSearchPage.searchResult));

    }
    @DataProvider(name="searchDataProvider")
    public Object[][] searchDataProvider()
    {

        String path= System.getProperty("user.dir")+"\\src\\test\\resources\\test_data.xlsx";
        ExcelData ex=new ExcelData(path);
        String data[][]=ex.readStringArrays("doSearch");
        return data;

    }


    @Test(priority= 4, groups= {"BAT"})
    public void testAddToFavorite(){
        HomePage homePage = new HomePage();
        SignInPage signInPage = new SignInPage();
        SearchPage searchPage= new SearchPage();
        ResultSearchPage resultSearchPage= new ResultSearchPage();


        homePage.clickFirstSignInButton();
        String email="anoor1@gmail.com";
        String password="Piit123!";

        signInPage.doSignIn(email,password);
        String searchTerm="70122 LA, New Orleans";
        searchPage.searchTerm(searchTerm);
        resultSearchPage.doSearch();
        resultSearchPage.clickOnHearts();
        Assert.assertTrue(isElementVisible(resultSearchPage.favoriteResult));

    }
}
