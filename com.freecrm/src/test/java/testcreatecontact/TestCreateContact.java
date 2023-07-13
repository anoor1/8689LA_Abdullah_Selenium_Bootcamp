package testcreatecontact;

import base.BasePage;
import freecrm.pom.createcontactpage.ContactsAddedPage;
import freecrm.pom.createcontactpage.CreateContactPage;
import freecrm.pom.homepage.HomePage;
import freecrm.pom.loginpage.DashboardPage;
import freecrm.pom.loginpage.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelData;

public class TestCreateContact extends BasePage {




//    public void testCreateContact(String email,String password,String firstName,String lastName,String middleName, String companyName, String tagName,
//                                  String emailAddress,String description, String timeZone, String streetAddress, String city, String state, String zip){
//        CreateContactPage createContactPage = new CreateContactPage();
//        LoginPage loginPage = new LoginPage();
//        DashboardPage dashboardPage = new DashboardPage();
//        HomePage homePage = new HomePage();
//        homePage.clickOnLoginButton();
//        loginPage.doSignIn(email,password);
//        dashboardPage.doClickContactAddButton();
//        createContactPage.createNewContact(firstName,lastName,middleName,companyName,tagName,emailAddress,description,timeZone,streetAddress,city,state,zip);
//
//
//    }
//    @DataProvider(name="createcontactdataprovider")
//    public String[][] createNewContact()
//    {
//
//        String path= System.getProperty("user.dir")+"\\src\\test\\resources\\test1.xlsx";
//        ExcelData ex=new ExcelData(path);
//        String data[][]=ex.readStringArrays("Create Contact for CRM");
//        return data;
//
//    }
    @Test(priority= 2, groups= {"BAT"},dataProvider = "createContactDataProvider")
    public void testDoAddNewContact(String firstName, String lastName,String companyName,String email,
                                    String description, String streetAddress,  String city, String state,String phoneNumber){


        HomePage homePage =new HomePage();

        LoginPage loginPage= new LoginPage();
        homePage.clickOnLoginButton();
        String email1 = "abdullah.noor14@gmail.com";
        String password="Abcd1234!";
        DashboardPage dashboardUserPage= loginPage.doSignIn(email1,password);
        CreateContactPage createNewContactPage= dashboardUserPage.doClickAddButton();

        ContactsAddedPage contactsAddedPage= createNewContactPage.doAddContact(firstName,lastName,companyName,email,description,streetAddress,city,state,phoneNumber);

        Assert.assertTrue(isElementVisible(contactsAddedPage.redIcon));

    }
    @DataProvider(name="createContactDataProvider")
    public Object [][] addContactDataProvider() {

        String path= System.getProperty("user.dir")+"\\src\\test\\resources\\test_data.xlsx";
        ExcelData ex=new ExcelData(path);
        String data[][]=ex.readStringArrays("createContact_crm1");
        return data;

    }
}


