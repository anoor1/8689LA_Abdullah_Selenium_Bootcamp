package test_search;
import base.BasePage;
import investing.pom.homepage.HomePage;
import investing.pom.resultpage.ResultPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.ExcelData;

public class TestSearch extends BasePage {

    @Test(priority= 1, groups= {"BAT"},dataProvider = "searchDataProvider")

    public void testSearchFlightData(String searchTerm){

        HomePage homePage=new HomePage();
        ResultPage resultPage= homePage.searchForSomething(searchTerm);

        Assert.assertTrue(isElementVisible(resultPage.resultsSum));
    }
    @DataProvider(name="searchDataProvider")
    public Object [][] searchFlightsDataProvider()
    {

        String path= System.getProperty("user.dir")+"\\src\\test\\resources\\test_data.xlsx";
        ExcelData ex=new ExcelData(path);
        String data[][]=ex.readStringArrays("search term_investing");
        return data;

    }

}