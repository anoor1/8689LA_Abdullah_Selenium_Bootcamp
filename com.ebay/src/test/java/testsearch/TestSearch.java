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


    public class DataProviders {
//
//        String modulePath = System.getProperty("user.dir");
//        String dataPath = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "test_data.xlsx";
//        ExcelData excelData = new ExcelData(modulePath + File.separator + dataPath);
//
//        @DataProvider(name = "testDoSearch")
//        public Object[][] getDoSearchDataProvider() {
//            return excelData.readStringArrays("testDoSearch");
//        }
@DataProvider(name = "testDoSearch")
public Object[][] loginDataProvider() {

    String path= System.getProperty("user.dir")+"\\src\\test\\resources\\test_data.xlsx";
    ExcelData ex = new ExcelData(path);
    String data[][] = ex.readStringArrays("login_bmw");
    return data;
}

    }
}

