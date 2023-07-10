package testcreateaccountusingdataprovider;

import base.BasePage;
import luma.pom.createaccountpage.CreateAccountPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelData;

public class TestCreateAccountUsingDataProvider extends BasePage {

    @Test(priority = 3, groups = {"BAT"},dataProvider = "datacreateaccount")
    public void testCreateAccountUsingDataProvider(String fName,String lName,String emailId,String pass) {
        CreateAccountPage accountpage = new CreateAccountPage();
        accountpage.createAccountwithParam(fName, lName, emailId, pass);

        Assert.assertTrue(isElementVisible(accountpage.registeruservalidation));
    }



    @DataProvider(name="datacreateaccount")
    public String[][] createAccountDataProvider()
    {

        String path= System.getProperty("user.dir")+"\\src\\test\\resources\\test_data.xlsx";
        ExcelData ex=new ExcelData(path);
        String data[][]=ex.readStringArrays("createaccount");
        return data;

    }
}
