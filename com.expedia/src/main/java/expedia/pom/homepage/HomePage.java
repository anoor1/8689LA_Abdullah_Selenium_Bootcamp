package expedia.pom.homepage;

import base.BasePage;
import expedia.pom.feedbackpage.FeedBackPage;
import expedia.pom.flightresultpage.FlightResultPage;
import expedia.pom.supportpage.SupportPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    public HomePage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//button[.='Sign in']")
    public WebElement signInLink;

    @FindBy(xpath ="//*[@id=\"app-layer-base\"]/div[1]/div[1]/header/div/section/div/div/div[2]/div[2]/div/div/div/div[3]/a")
    public WebElement signInButton1;

    @FindBy(xpath = "//span[normalize-space()='Flights']")
    public WebElement flightsTab;

    @FindBy(xpath = "//button[@aria-label='Leaving from']")
    public WebElement inputLeavingFromBar;

    @FindBy(xpath = "//button[@aria-label='New Orleans (MSY - Louis Armstrong New Orleans Intl.) Louisiana, United States']")
    public WebElement leavingFromOption;

    @FindBy(xpath = "//button[@aria-label='Going to']")
    public WebElement inputGoingToBar;

    @FindBy(xpath = "//button[@aria-label='Athens (ATH - Eleftherios Venizelos) Greece']")
    public WebElement goingToOption;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement flightsSearchButton;

    @FindBy(xpath = "//div[contains(text(),'Support')]")
    public WebElement supportButton;



    @FindBy(xpath = "//div[contains(text(),'English')]")
    public WebElement englishLanguageButton;

    @FindBy(xpath = "//select[@id='language-selector']")
    public WebElement languageDropdown;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    public WebElement saveButtonLanguage;

    @FindBy(xpath = "//div[contains(text(),'Español')]")
    public WebElement assertSpanishLanguageChange;



    @FindBy(xpath = "//a[@aria-label='Feedback']")
    public WebElement feedbackButton;

    @FindBy(xpath = "//div[@class='sub-box websitefeedback sub-box-three-elements']//a[1]")
    public WebElement websiteFeedback;

    @FindBy(xpath = "//label[@for='page-rating-1']//span[@data-localization='ratings-icon'][contains(text(),'★')]")
    public WebElement satisfactionButton;

    @FindBy(xpath = "//textarea[@id='verbatim']")
    public WebElement commentBox;

    @FindBy(xpath = "//button[@id='submit-button']")
    public WebElement submitCommentButton;

    public FeedBackPage clickOnFeedBackButton(){
        safeClickOnElement(feedbackButton);

        return new FeedBackPage();
    }
    public void clickOnWebSiteFeedBack(){
        safeClickOnElement(websiteFeedback);
    }
    public void clickOnSatisfactionButton(){
        safeClickOnElement(satisfactionButton);
    }
    public void typeInCommentBox(){
        sendKeysToElement(commentBox, "");
    }



    public void clickOnEnglishLanguageButton(){
        safeClickOnElement(englishLanguageButton);
    }

    public void clickOnLanguageDropDown(){
        selectFromDropdownByVisibleText(languageDropdown, "Español");
    }

    public void clickOnSaveButton(){
        safeClickOnElement(saveButtonLanguage);
    }

    public void changeLanguage(){
        clickOnEnglishLanguageButton();
        clickOnLanguageDropDown();
        clickOnSaveButton();
    }











    public SupportPage clickOnSupportButton(){
        safeClickOnElement(supportButton);
        return new SupportPage();
    }

    public void clickOnFlightsTab(){
        safeClickOnElement(flightsTab);
    }
    public void sendKeysInputLeavingFromBar(String leavingFrom){
        safeClickOnElement(inputLeavingFromBar);
        sendKeysToElement(inputLeavingFromBar, leavingFrom);
    }
    public void clickOnLeavingFromOption(){
        safeClickOnElement(leavingFromOption);
    }

    public void sendKeysGoingToBar(String goingTo){
        safeClickOnElement(inputGoingToBar);
        sendKeysToElement(inputGoingToBar, goingTo);
    }

    public void clickOnGoingToOption(){
        safeClickOnElement(goingToOption);
    }

    public void clickOnFlightSearchButton(){
        safeClickOnElement(flightsSearchButton);
    }

    public FlightResultPage doFlightSearch(String leavingFrom, String goingTo){
        clickOnFlightsTab();
        sendKeysInputLeavingFromBar(leavingFrom);
        clickOnLeavingFromOption();
        sendKeysGoingToBar(goingTo);
        clickOnGoingToOption();
        clickOnFlightSearchButton();

        return new FlightResultPage();
    }






    public void clickOnSignInLink(){
        safeClickOnElement(signInLink);
    }
    public void clickOnSignIButton1(){
        safeClickOnElement(signInButton1);
    }



}
