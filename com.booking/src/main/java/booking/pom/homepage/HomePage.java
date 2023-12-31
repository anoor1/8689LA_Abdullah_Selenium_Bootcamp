package booking.pom.homepage;

import base.BasePage;
import booking.pom.attractionspage.AttractionsPage;
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


    @FindBy(xpath="//span[.='Flights']")
    public WebElement flightsButton;

    @FindBy(xpath="//button[3]/div[@class='css-ztjjo9']//span[@class='Text-module__root--variant-body_2___-3fYM Text-module__root--color-disabled___tERfD']")
    public WebElement whereToInputField;
    @FindBy(xpath="//input[@class='css-1ejj2j9']")
    public WebElement airportInputField;
    @FindBy(xpath = "//ul[@class='css-1eonra']//span[@class='css-3cj1dx']/span[contains(.,'CFU Corfu International Airport')]")
    public WebElement selectedAirport;
    @FindBy(css="[placeholder='Depart – Return']")
    public WebElement departReturnField;
    @FindBy(xpath = "//div[@class='Calendar-module__content___XsvtK']//tr[2]//span[@class='Calendar-module__date___FlMKj']/span[1]/span[.='11']")
    public WebElement firstDate;
    @FindBy(xpath="//div[@class='Calendar-module__content___XsvtK']//tr[2]//span[@class='Calendar-module__date___FlMKj']/span[1]/span[.='12']")
    public WebElement secondDate;

    @FindBy(xpath="//div[.='Showing 321 results']")
    public WebElement searchResults;

    @FindBy(xpath = "//label[@for='search_type_option_ROUNDTRIP']//span[@class='InputRadio-module__field___4Jbyo']")
    public WebElement roundTripRadioButton;
    @FindBy(xpath = "//label[@for='search_type_option_ONEWAY']//span[@class='InputRadio-module__field___4Jbyo']")
    public WebElement oneWayRadioButton;

    @FindBy(xpath = "//label[@for='search_type_option_MULTISTOP']//span[@class='InputRadio-module__field___4Jbyo']")
    public WebElement multiCityRadioButton;


    @FindBy(xpath = "//input[@id='newsletter_to']")
    public WebElement subscribeEmailBar;

    @FindBy(xpath = "//button[@id='newsletter_button_footer']")
    public WebElement subscribeButton;

    @FindBy(xpath = "//a[@id='attractions']")
    public WebElement attractionsButton;

   public AttractionsPage clickOnAttractionsButton(){
       safeClickOnElement(attractionsButton);

       return new AttractionsPage();
   }




    public void inputEmailForSubscription(String email){
        sendKeysToElement(subscribeEmailBar,email);
    }
    public void clickOnSubscribe(){
        safeClickOnElement(subscribeButton);
    }
    public void doSubscribeEmail(String email){
        inputEmailForSubscription(email);
        clickOnSubscribe();
    }


    public void clickOnRoundTripRadioButton(){
        safeClickOnElement(flightsButton);
        safeClickOnElement(roundTripRadioButton);
    }

    public void clickOnOneWayRadioButton(){
        safeClickOnElement(flightsButton);
        safeClickOnElement(oneWayRadioButton);
    }

    public void clickOnMultiCityRadioButton(){
        safeClickOnElement(flightsButton);
        safeClickOnElement(multiCityRadioButton);
    }



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


    public void clickOnFlightButton(){
        safeClickOnElement(flightsButton);
    }
    public void clickOnWhereToGoButton(){
        safeClickOnElement(whereToInputField);
    }
    public void enterDestinationName(String countryName){
        sendKeysToElement(airportInputField,countryName);
    }
    public void clickOnSelectedAirport(){
        safeClickOnElement(selectedAirport);
    }

    public void clickOnDepartReturnButton(){
        safeClickOnElement(departReturnField);
    }

    public void clickOnFirstDate(){
        safeClickOnElement(firstDate);
    }
    public void clickOnSecondDate(){
        safeClickOnElement(secondDate);
    }



    public void doSearchFlights(String countryName){
        clickOnFlightButton();
        clickOnWhereToGoButton();
        enterDestinationName(countryName);
        clickOnSelectedAirport();
        clickOnDepartReturnButton();
        clickOnFirstDate();
        clickOnSecondDate();
        clickOnSearchButton();
    }

}
