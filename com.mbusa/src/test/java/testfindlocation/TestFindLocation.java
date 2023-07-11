package testfindlocation;

import base.BasePage;
import mbusa.pom.homepage.HomePage;
import mbusa.pom.searchpage.SearchPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelData;

public class TestFindLocation extends BasePage {
    @Test(priority=5,groups={"BAT"},dataProvider = "findDealerLocationDataProvider")
    public void testFindDealer(String zipCode){
        HomePage homePage=new HomePage();
        SearchPage searchPage= homePage.doFindDealer(zipCode);
        searchPage.clickOnCollisionCenter();
        Assert.assertTrue(isElementVisible(searchPage.collisionCenterResult));
    }
    @DataProvider(name = "findDealerLocationDataProvider")
    public String[][] findDealerDataProvider() {

        String path = System.getProperty("user.dir") + "\\src\\test\\resources\\test_data.xlsx";
        ExcelData ex = new ExcelData(path);
        String data[][] = ex.readStringArrays("doFindDealer_city");
        return data;

    }
}
