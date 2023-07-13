package testsubmitfeedback;

import base.BasePage;
import expedia.pom.feedbackpage.FeedBackPage;
import expedia.pom.homepage.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSubmitFeedback extends BasePage {

    @Test(priority = 1, groups = {"Smoke"})
    public void testSubmitFeedback() {
        HomePage homePage = new HomePage();
        FeedBackPage feedBackPage = new FeedBackPage();

        homePage.clickOnFeedBackButton();
        feedBackPage.submitAFeedBack();
        Assert.assertTrue(isElementVisible(feedBackPage.assertFeedbackHeader));
    }



}
