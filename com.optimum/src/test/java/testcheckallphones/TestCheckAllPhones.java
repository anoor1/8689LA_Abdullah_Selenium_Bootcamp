package testcheckallphones;

import base.BasePage;
import optimum.pom.homepage.HomePage;
import optimum.pom.mobilepage.MobilePage;
import org.testng.annotations.Test;

public class TestCheckAllPhones extends BasePage {

    @Test
    public void checkForPhones(){
        HomePage homePage = new HomePage();
        MobilePage mobilePage = new MobilePage();
        homePage.clickOnAllPhonesButton();
    }
}
