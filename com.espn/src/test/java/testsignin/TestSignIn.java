package testsignin;

import base.BasePage;
import espn.pom.homepage.HomePage;
import espn.pom.searchresultpage.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelData;

public class TestSignIn extends BasePage {

    @Test(priority= 1, groups= {"BAT"},dataProvider = "signindataprovider")
    public void testUserSignIn(String email,String password){

        HomePage homePage = new HomePage();
        homePage.doSignIn(email,password);


    }

    @DataProvider(name="signindataprovider")
    public Object[][] testSignInUserDataProvider()
    {

        String path= System.getProperty("user.dir")+"\\src\\test\\resources\\test_data.xlsx";
        ExcelData ex=new ExcelData(path);
        String data[][]=ex.readStringArrays("Signin_espn");
        return data;

    }
}



