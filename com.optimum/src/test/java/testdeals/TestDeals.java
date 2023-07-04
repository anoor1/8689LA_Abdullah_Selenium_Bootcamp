package testdeals;

import base.BasePage;
import optimum.pom.dealspage.DealsPage;
import optimum.pom.homepage.HomePage;
import org.testng.annotations.Test;

public class TestDeals extends BasePage {

    @Test(priority = 1, groups = {"smoke"})
    public void checkForDeals(){
        HomePage homePage = new HomePage();
        DealsPage dealsPage = new DealsPage();
        homePage.clickOnAllDealsButton();

    }
}
