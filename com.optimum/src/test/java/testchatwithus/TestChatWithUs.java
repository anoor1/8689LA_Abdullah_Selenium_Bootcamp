package testchatwithus;

import base.BasePage;
import optimum.pom.contactuspage.ContactUsPage;
import optimum.pom.homepage.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestChatWithUs extends BasePage {

    @Test(priority = 1, groups = "Smoke")
    public void testChatWithUs(){
        HomePage homePage = new HomePage();
        ContactUsPage contactUsPage = new ContactUsPage();

        homePage.clickOnContactsButton();
        contactUsPage.clickOnChatNowButton();
        Assert.assertTrue(isElementVisible(contactUsPage.chatWithUsPrompt));
    }
}
