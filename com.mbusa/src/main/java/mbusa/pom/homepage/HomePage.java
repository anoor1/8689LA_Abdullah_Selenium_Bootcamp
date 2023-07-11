package mbusa.pom.homepage;

import base.BasePage;
import mbusa.pom.loginpage.LoginPage;
import mbusa.pom.searchpage.SearchPage;
import mbusa.pom.shoppartspage.ShopPartsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[contains(@aria-label,'OK')]")
    public WebElement okButton;

    @FindBy(xpath = "//span[@class='global-header__button-label global-header__button-utility-inner']")
    public WebElement myAccountButton;

    @FindBy(id = "text-zoom-tracker")
    public WebElement iframe;

    @FindBy(xpath = "//button[@class='nav-profile__login nav-profile__button button button_primary button--wide ']")
    public WebElement loginButton;

    @FindBy(xpath = "//span[@class='global-header__button-label global-header__button-utility-inner']")
    public WebElement usernameHeader;


    @FindBy(xpath = "//span[normalize-space()='Vehicles']")
    public WebElement vehiclesButton;

    @FindBy(xpath = "//ul[@class='primary-global-header__vehicles-link-list']//a[@role='menuitem'][normalize-space()='Compare Models']")
    public WebElement compareModels;

    @FindBy(xpath = "//div[@class='wrapper compare-header__sticky-component']//div[1]//button[1]//div[1]")
    public WebElement addAVehicleButton;

    @FindBy(xpath = "//label[@for='filter-checkbox-control_A220W4']")
    public WebElement sedanButton1;

    @FindBy(xpath = "//label[@for='filter-checkbox-control_A220W']")
    public WebElement sedanButton2;

    @FindBy(xpath = "//button[@class='button button_primary button--wide']")
    public WebElement compareVehiclesButton;

    @FindBy(xpath = "//h2[normalize-space()='Feature Highlights']")
    public WebElement featureHighlightsHeader;

    @FindBy(xpath="//div[@class='full-height-hero__image-container full-height-hero__image-container--width']//a[.='Explore']")
    public WebElement exploreButton;

    @FindBy(xpath = "//span[.='Shopping']")
    public WebElement shoppingLink;

    @FindBy(xpath="//span[.='Find a Dealer']")
    public WebElement findDealer;
    @FindBy(xpath = "//div[@class='form__input form__input--inline']/input[@class='form__input-field form__input-field--can-reset']")
    public WebElement zipCodeInputField;
    @FindBy(xpath = "//button[@class='button button_primary']")
    public WebElement searchButton;

    @FindBy(xpath= "//ul[@class='location-search__list']/li[contains(.,'Philadelphia, PA')]")
    public WebElement firstOption;



    public void clickOnMyAccountButton(){

        safeClickOnElement(myAccountButton);
    }
    public void switchToIframe(){

        driver.switchTo().frame(iframe);
    }
    public void clickOnLoginButton(){
        safeClickOnElement(loginButton);

    }
    public void clickOnOkButton()
    {

        safeClickOnElement(okButton);

    }
    public LoginPage workFlowLogin(){
        getVisibleElement(myAccountButton);
        clickOnByTabKey();
        clickOnMyAccountButton();
        clickOnLoginButton();

        return new LoginPage();
    }

    public void clickOnVehiclesButton(){
        safeClickOnElement(vehiclesButton);
    }

    public void clickOnCompareModels(){
        safeClickOnElement(compareModels);
    }

    public void clickOnAddAVehicle(){
        safeClickOnElement(addAVehicleButton);
    }

    public void clickOnSedan1(){
        safeClickOnElement(sedanButton1);
    }

    public void clickOnSedan2(){
        safeClickOnElement(sedanButton2);
    }

    public void clickOnCompare(){
        safeClickOnElement(compareVehiclesButton);

    }

    public void compareTwoVehicles(){
        clickOnVehiclesButton();
        clickOnCompareModels();
        clickOnAddAVehicle();
        clickOnSedan1();
        clickOnSedan2();
        clickOnCompare();
    }

    public ShopPartsPage clickOnShoppingLink(){
        safeClickOnElement(shoppingLink);
        return new ShopPartsPage();
    }


    public void clickOnFindDealer(){
        safeClickOnElement(findDealer);
    }
    public void enterZipCode(String zipCode){
        sendKeysToElement(zipCodeInputField,zipCode);
    }
    public void clickOnFirstOption(){
        safeClickOnElement(firstOption);
    }
    public void clickOnSearchButton(){
        safeClickOnElement(searchButton);
    }

    public SearchPage doFindDealer(String zipCode){
        clickOnFindDealer();
        enterZipCode(zipCode);
        clickOnFirstOption();
        clickOnSearchButton();
        return new SearchPage();
    }



}
