package booking.pom.homepage;

import base.BasePage;
import booking.pom.stayssearchresultpage.StaysSearchResultPage;
import config.BaseConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
      public HomePage(){ PageFactory.initElements(driver,this);
}

    @FindBy(xpath="//a[@id='accommodations']")
    public WebElement staysButton;
    @FindBy(xpath="//input[@name='ss']")
    public WebElement whereAreYouGoingButton;

    @FindBy(xpath = "//div[@class='f9afbb0024'][normalize-space()='Myrtle Beach']")
    public WebElement firstOption;

    @FindBy(xpath = "//div[@class='b91c144835']")
    public WebElement dateSelectField;

    @FindBy(xpath = "//button[@aria-controls=\"flexible-searchboxdatepicker\"]")
    public WebElement iAmFlexibleTab;

    @FindBy(xpath = "//label[@for=':r5q:']//span[@class='e50b5c7936']")
    public WebElement stayAWeekendButton;

    @FindBy(xpath = "//label[@class='eb47fad9b8 d2687489f6 e6e2d43004']//span[@class='b6cee19e2e'][normalize-space()='2023']")
    public WebElement monthButton;

    @FindBy(xpath = "//span[normalize-space()='Select dates']")
    public WebElement selectDatesButton;

    @FindBy(xpath = "//span[@aria-label='27 July 2023']//span[contains(text(),'27')]")
    public WebElement checkInDate;

    @FindBy(xpath = "//span[@aria-label='29 July 2023']//span[contains(text(),'29')]")
    public WebElement checkOutDate;


    @FindBy(xpath = "//img[@class='c3194e6c89 e5eb7fb6cb e418d76df7']")
    public WebElement languageButton;

    @FindBy(xpath = "//span[normalize-space()='Français']")
    public WebElement frenchLanguage;

    @FindBy(xpath = "//div[@class='bb0b3e18ca d9b0185ac2']/a[.='Se connecter']")
    public WebElement seConnecterButton;


    @FindBy(xpath = "//button[@type='submit']")
    public WebElement searchButton;


    public void clickOnStaysButton(){
        safeClickOnElement(staysButton);
    }

    public void clickOnWhereYouGo(){
        safeClickOnElement(whereAreYouGoingButton);
    }

    public void clickOnFirstOptionButton(){
        safeClickOnElement(firstOption);
    }

    public void pickDates(){
        safeClickOnElement(dateSelectField);
        safeClickOnElement(iAmFlexibleTab);
        safeClickOnElement(stayAWeekendButton);
        safeClickOnElement(monthButton);
        safeClickOnElement(selectDatesButton);
        //safeClickOnElement(checkInDate);
        //safeClickOnElement(checkOutDate);
    }

    public void clickOnSearchButton(){
        safeClickOnElement(searchButton);
    }

    public StaysSearchResultPage doSearchStays(){
        clickOnStaysButton();
        clickOnWhereYouGo();
        clickOnFirstOptionButton();
        pickDates();
        clickOnSearchButton();

        return new StaysSearchResultPage();
    }

    public void clickOnLanguageButton(){
        safeClickOnElement(languageButton);
    }

    public void clickOnFrenchLanguage(){
        safeClickOnElement(frenchLanguage);
    }

    public void doChangeLanguage(){
        clickOnLanguageButton();
        clickOnFrenchLanguage();
    }
}
