package testsubscribewithemail;

import base.BasePage;
import luma.pom.homepage.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSubscribeWithEmail extends BasePage {
    @Test(priority= 9, groups = {"BAT"})
    public void testSubscribeWithEmail(){
        HomePage page = new HomePage();
        String email = "Helloworld12345@yahoo.com";
        page.subscribeWithEmail(email);
        Assert.assertTrue(isElementVisible(page.confirmSubscriptionMessage));
    }
}
