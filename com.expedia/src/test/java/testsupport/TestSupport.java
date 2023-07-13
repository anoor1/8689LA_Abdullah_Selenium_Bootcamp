package testsupport;

import base.BasePage;
import expedia.pom.homepage.HomePage;
import expedia.pom.supportpage.SupportPage;
import org.jsoup.Connection;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSupport extends BasePage {

    @Test(priority=4,groups={"BAT"})
    public void testSupport(){
        HomePage homePage=new HomePage();
        SupportPage supportPage=homePage.clickOnSupportButton();
        supportPage.clickOnChangeBookingButton();
        Assert.assertTrue(isElementVisible(supportPage.enterBookingDetails));
    }
}
