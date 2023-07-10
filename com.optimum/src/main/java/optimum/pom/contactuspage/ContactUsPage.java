package optimum.pom.contactuspage;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage extends BasePage {
    public ContactUsPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@class='button blue open-chat']")
    public WebElement chatNowButton;

    @FindBy(xpath = "//button[@id='asapp-chat-sdk-badge']")
    public WebElement chatWithUsPrompt;

    public void clickOnChatNowButton(){
        safeClickOnElement(chatNowButton);
    }
}
