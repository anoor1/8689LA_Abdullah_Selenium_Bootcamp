package testatmlocatorpage;

import bankofamerica.pom.atmlocatorpage.AtmLocatorPage;
import bankofamerica.pom.bankofamericapage.BankOfAmericaPage;
import bankofamerica.pom.homepage.HomePage;
import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelData;

import java.util.Set;

public class TestAtmLocatorPage extends BasePage {

    @Test(priority = 1, groups = {"BAT"}, dataProvider = "searchatmlocatordataprovider")

    public void testSearchAtmLocator(String zip) {

        HomePage homePage = new HomePage();
        BankOfAmericaPage bankOfAmericaPage = new BankOfAmericaPage();
        AtmLocatorPage atmLocatorPage = new AtmLocatorPage();

                    bankOfAmericaPage.clickOnAtmButton();
                    atmLocatorPage.searchForAtm(zip);
                    Assert.assertTrue(isElementVisible(atmLocatorPage.resultForATM));
                }



        @DataProvider(name = "searchatmlocatordataprovider")
        public String[][] atmLocatorDataProvider ()
        {

            String path = System.getProperty("user.dir") + "\\src\\test\\resources\\test_data.xlsx";
            ExcelData ex = new ExcelData(path);
            String data[][] = ex.readStringArrays("bankofamerica_zip");
            return data;

        }
    }

