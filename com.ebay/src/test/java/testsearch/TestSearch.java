package testsearch;

import base.BasePage;
import ebay.pom.homepage.HomePage;
import ebay.pom.searchresultpage.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelData;

import java.io.File;

public class TestSearch extends BasePage {


    @Test(groups = {"smoke", "broken"}, dataProvider = "testDoSearch")
    public void testDoSearch(String searchTerm, String validationTerm) {
        HomePage homePage = new HomePage();

        SearchResultPage searchResultPage = homePage.doSearch(searchTerm);

        Assert.assertEquals(searchResultPage.textSearchTerm.getText(), validationTerm);


    }



@DataProvider(name = "testDoSearch")
public Object[][] loginDataProvider() {
        System.out.println(System.getProperty("user.dir"));

    String path= System.getProperty("user.dir")+"\\src\\test\\resources\\test_data_ebay.xlsx";
    ExcelData ex = new ExcelData(path);
    String data[][] = ex.readStringArrays("testDoSearch");
    return data;
}


}

