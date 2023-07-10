package testsearchitemdataprovider;

import base.BasePage;
import luma.pom.itemsearchpage.ItemSearchPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelData;

import java.util.Base64;

public class TestSearchItemDataProvider extends BasePage {
    @Test(priority = 5, groups = {"BAT"},dataProvider = "searchItems")
    public void testSearchItemDataProvider(String item) {
        ItemSearchPage page = new ItemSearchPage();
        page.searchItem(item);
        String textactual = getTrimmedElementText(page.searchedheadertext);
        String expected="Search results for: '"+item+"'";
        Assert.assertEquals(textactual, expected);

    }



    @DataProvider(name="searchItems")
    public String[][] searchItemProvider()
    {

        String path= System.getProperty("user.dir")+"\\src\\test\\resources\\test_data.xlsx";
        ExcelData ex=new ExcelData(path);
        String data[][]=ex.readStringArrays("searchdata");
        return data;

    }
}
