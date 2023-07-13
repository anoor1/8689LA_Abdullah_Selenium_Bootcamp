package expedia.pom.feedbackpage;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FeedBackPage extends BasePage {
    public FeedBackPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@class='sub-box websitefeedback sub-box-three-elements']//a[1]")
    public WebElement websiteFeedback;

    @FindBy(xpath = "//label[@for='page-rating-1']//span[@data-localization='ratings-icon'][contains(text(),'★')]")
    public WebElement satisfactionButton;

    @FindBy(xpath = "//textarea[@id='verbatim']")
    public WebElement commentBox;

    @FindBy(xpath = "//button[@id='submit-button']")
    public WebElement submitCommentButton;

    @FindBy(xpath = "//p[@class='question-header']")
    public WebElement assertFeedbackHeader;


    public void clickOnWebSiteFeedBack(){
        safeClickOnElement(websiteFeedback);
    }
    public void clickOnSatisfactionButton(){
        safeClickOnElement(satisfactionButton);
    }
    public void typeInCommentBox(){
        sendKeysToElement(commentBox, "Hello World");
    }

    public void submitComment(){
        safeClickOnElement(submitCommentButton);
    }

    public void submitAFeedBack(){
        clickOnWebSiteFeedBack();
        clickOnSatisfactionButton();
        typeInCommentBox();
        submitComment();
    }
}
