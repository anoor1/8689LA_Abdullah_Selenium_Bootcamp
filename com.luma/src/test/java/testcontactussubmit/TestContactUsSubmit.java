package testcontactussubmit;

import base.BasePage;
import luma.pom.contactuspage.ContactUsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestContactUsSubmit extends BasePage {

    @Test(priority = 10, groups = {"BAT"})
    public void testContactUsSubmit(){
        ContactUsPage page = new ContactUsPage();
        String name = "Abdullah Noor";
        String email = "Helloworld12345@yahoo.com";
        String phoneNumber = "1234567890";
        String whatOnYourMindComment = "Hello, World";
        page.doContactUs(name, email, phoneNumber, whatOnYourMindComment);
        Assert.assertTrue(isElementVisible(page.thankYouForContactMessage));

    }
}
