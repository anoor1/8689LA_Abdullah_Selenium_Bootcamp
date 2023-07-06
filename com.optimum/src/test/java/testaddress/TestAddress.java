package testaddress;

import base.BasePage;
import optimum.pom.homepage.HomePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelData;

public class TestAddress extends BasePage {

    @Test(priority = 1, groups = {"smoke"}, dataProvider = "searchdataprovider")
     public void testAddressResult(String address, String zip){
        HomePage homePage = new HomePage();
        homePage.searchForAvailability(address, zip);
        Assert.assertTrue(isElementVisible(homePage.addressResult));
    }

    @DataProvider(name = "searchdataprovider")
    public String[][] streetAddressDataProvider() {

        String path= System.getProperty("user.dir")+"\\src\\test\\resources\\test_data.xlsx";
        ExcelData ex = new ExcelData(path);
        String data[][] = ex.readStringArrays("search_optimum");
        return data;
    }


}
