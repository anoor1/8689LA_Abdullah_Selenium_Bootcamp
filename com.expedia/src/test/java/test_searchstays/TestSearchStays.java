package test_searchstays;

import base.BasePage;
import stayssearchpage.StaysSearchPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelData;

public class TestSearchStays extends BasePage {



    @Test(priority= 1, groups= {"BAT"},dataProvider = "searchFlightDataProvider")

    public void testSearchFlightData(String goingToCity,String fromDate,String toDate){

        StaysSearchPage flightSearchPage=new StaysSearchPage();
        flightSearchPage.searchFlight(goingToCity,fromDate,toDate);
        Assert.assertTrue(checkElementPresent(flightSearchPage.searchHotelData));
        Assert.assertTrue(checkElementPresent(flightSearchPage.showmoreResults));

    }
    @DataProvider(name="searchFlightDataProvider")
    public String[][] searchFlightsDataProvider()
    {

        String path= System.getProperty("user.dir")+"\\src\\test\\resources\\test_data_expedia.xlsx";
        ExcelData ex=new ExcelData(path);
        String data[][]=ex.readStringArrays("expedia_search");
        return data;

    }

}