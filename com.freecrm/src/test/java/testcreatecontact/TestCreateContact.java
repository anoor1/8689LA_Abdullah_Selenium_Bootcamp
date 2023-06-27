package testcreatecontact;

import base.BasePage;
import freecrm.pom.createcontactpage.CreateContactPage;
import freecrm.pom.homepage.HomePage;
import freecrm.pom.loginpage.DashboardPage;
import freecrm.pom.loginpage.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelData;

public class TestCreateContact extends BasePage {


    @Test(priority= 2, groups= {"BAT"},dataProvider = "createcontactdataprovider")

    public void testCreateContact(String email,String password,String firstName,String lastName,String middleName, String companyName, String tagName,
                                  String emailAddress,String description, String timeZone, String streetAddress, String city, String state, String zip){
        CreateContactPage createContactPage = new CreateContactPage();
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        HomePage homePage = new HomePage();
        homePage.clickOnLoginButton();
        loginPage.doSignIn(email,password);
        dashboardPage.doClickContactAddButton();
        createContactPage.createNewContact(firstName,lastName,middleName,companyName,tagName,emailAddress,description,timeZone,streetAddress,city,state,zip);


    }
    @DataProvider(name="createcontactdataprovider")
    public String[][] createNewContact()
    {

        String path= System.getProperty("user.dir")+"\\testdata\\test1.xlsx";
        ExcelData ex=new ExcelData(path);
        String data[][]=ex.readStringArrays("Create Contact for CRM");
        return data;

    }
}


