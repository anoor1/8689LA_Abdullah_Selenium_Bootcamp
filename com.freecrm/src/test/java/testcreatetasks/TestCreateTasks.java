package testcreatetasks;

import base.BasePage;
import freecrm.pom.homepage.HomePage;
import freecrm.pom.loginpage.DashboardPage;
import freecrm.pom.loginpage.LoginPage;
import freecrm.pom.taskpage.TaskPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelData;

public class TestCreateTasks extends BasePage {

    @Test(priority = 1,groups={"smoke"},dataProvider = "createTaskDataProvider")
    public void testCreateTask(String title){

        HomePage homePage =new HomePage();
        LoginPage loginPage=new LoginPage();
        homePage.clickOnLoginButton();
        String email1 = "abdullah.noor14@gmail.com";
        String password="Abcd1234!";
        DashboardPage dashboardUserPage= loginPage.doSignIn(email1,password);

        TaskPage tasksPage=dashboardUserPage.hoverClickOnTasksIcon();

        tasksPage.doAddNewTask(title);
        Assert.assertTrue(isElementVisible(tasksPage.titleOfCreatedTask));

    }

    @DataProvider(name="createTaskDataProvider")
    public Object [][] addContactDataProvider() {

        String path= System.getProperty("user.dir")+"\\src\\test\\resources\\test_data.xlsx";
        ExcelData ex=new ExcelData(path);
        String data[][]=ex.readStringArrays("doAddTasks");
        return data;

    }
}
