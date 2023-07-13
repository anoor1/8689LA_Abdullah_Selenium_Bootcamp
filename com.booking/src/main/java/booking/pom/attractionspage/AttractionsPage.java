package booking.pom.attractionspage;

import base.BasePage;
import booking.pom.coronaviruspage.CoronaVirusPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AttractionsPage extends BasePage {

    public AttractionsPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title='New York']//div[@class='css-sk1ghe']")
    public WebElement desiredAttraction;

    @FindBy(xpath = "//h1[@class='e1f827110f css-1uk1gs8']")
    public WebElement attractionsHeaderAssert;



    @FindBy(xpath = "//*[name()='path' and contains(@d,'M9.75 9a2.')]")
    public WebElement questionAttractionIcon;

    @FindBy(xpath = "//div[normalize-space()='How could the coronavirus (COVID-19) affect my visit?']")
    public WebElement coronavirusDropdown;

    @FindBy(xpath = "//a[normalize-space()='here']")
    public WebElement hereButton;


    public void clickOnQuestionAttractionIcon(){
        safeClickOnElement(questionAttractionIcon);
    }
    public void clickOnCoronaDropdown(){
        safeClickOnElement(coronavirusDropdown);
    }
    public void clickOnHereButton(){
        safeClickOnElement(hereButton);
    }

    public CoronaVirusPage doSearchForCoronaInfo(){
        clickOnQuestionAttractionIcon();
        clickOnCoronaDropdown();
        clickOnHereButton();
        return new CoronaVirusPage();
    }

    public void clickOnDesiredAttraction(){
        safeClickOnElement(desiredAttraction);

    }






}
