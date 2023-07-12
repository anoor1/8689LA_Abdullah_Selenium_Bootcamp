package espn.pom.homepage;

import base.BasePage;
import espn.pom.searchresultpage.SearchResultPage;
import espn.pom.tennispage.TennisPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@id='global-search-trigger']")
    public WebElement searchBarIcon;

    @FindBy(xpath = "//input[@id='global-search-input']")
    public WebElement searchBarInput;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement searchSubmitButton;


    @FindBy(xpath = "//article[@id='sideLogin-left-rail']//button[@class='button-alt med'][normalize-space()='Log In']")
    public WebElement loginButton;


    @FindBy(xpath="//input[@id=\"InputIdentityFlowValue\"]")
    public WebElement emailInput;

    @FindBy(xpath = "//button[@id='BtnSubmit']")
    public WebElement emailSubmitButton;

    @FindBy(xpath = "//input[@id='InputPassword']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@id='BtnSubmit']")
    public WebElement passwordSubmitButton;

    @FindBy(xpath = "//span[@class='link-text'][normalize-space()='Tennis']")
    public WebElement tennisDropdown;

    @FindBy(xpath = "//a[@name='&lpos=sitenavdefault+tennis_tennisindex']")
    public WebElement tennisHomeButton;

    public void hoverOverTennisDropdown(){
        hoverOverElement(tennisDropdown);
    }

    public void clickOnTennisHomeButton(){
        safeClickOnElement(tennisHomeButton);
    }

    public TennisPage doTennisHomePage(){
        hoverOverTennisDropdown();
        clickOnTennisHomeButton();

        return new TennisPage();
    }




    public void clickOnSearchIconButton(){
        safeClickOnElement(searchBarIcon);
    }
    public void inputInSearchBar(String searchTerm){
        sendKeysToElement(searchBarInput, searchTerm);
    }
    public void clickOnSearchSubmitButton(){
        safeClickOnElement(searchSubmitButton);
    }

    public SearchResultPage searchForATerm(String searchTerm){
        clickOnSearchIconButton();
        inputInSearchBar(searchTerm);
        clickOnSearchSubmitButton();

        return new SearchResultPage();
    }

    public void clickOnLoginButton(){
        safeClickOnElement(loginButton);
    }
    public void inputEmailAddress(String email){

        driver.switchTo().frame("oneid-iframe");
        sendKeysToElement(emailInput, email);
    }
    public void clickOnContinueButton(){
        safeClickOnElement(emailSubmitButton);
    }

    public void inputPassword(String password){
        sendKeysToElement(passwordInput, password);
    }

    public void clickOnSubmitButton(){
        safeClickOnElement(passwordSubmitButton);
    }

    public void doSignIn(String email, String password){
        clickOnLoginButton();
        inputEmailAddress(email);
        clickOnContinueButton();
        inputPassword(password);
        clickOnSubmitButton();
    }





}
