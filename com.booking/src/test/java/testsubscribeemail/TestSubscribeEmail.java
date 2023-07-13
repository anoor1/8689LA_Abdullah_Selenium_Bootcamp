package testsubscribeemail;

import base.BasePage;
import booking.pom.homepage.HomePage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelData;

public class TestSubscribeEmail extends BasePage {

    @Test(priority = 1, groups={"Smoke"}, dataProvider = "emailDataProvider")
    public void testDoSubscribeEmail(String email) {
        HomePage homePage = new HomePage();
        homePage.doSubscribeEmail(email);

        //click the beginning prompt manually when running this test
    }


        @DataProvider(name = "emailDataProvider")
        public String[][] emailDataProvider() {

            String path= System.getProperty("user.dir")+"\\src\\test\\resources\\test_data.xlsx";
            ExcelData ex = new ExcelData(path);
            String data[][] = ex.readStringArrays("email subscribe");
            return data;
        }


}
