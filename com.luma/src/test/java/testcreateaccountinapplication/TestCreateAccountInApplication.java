package testcreateaccountinapplication;

import base.BasePage;
import luma.pom.createaccountpage.CreateAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCreateAccountInApplication extends BasePage {
    @Test(priority = 1, groups = {"BAT"})
    public void testCreateAccountInApplication() {
        CreateAccountPage accountpage = new CreateAccountPage();
        accountpage.createAccount();
        Assert.assertTrue(isElementVisible(accountpage.registeruservalidation));
    }
}
