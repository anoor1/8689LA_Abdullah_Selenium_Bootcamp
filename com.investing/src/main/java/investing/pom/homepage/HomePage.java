package investing.pom.homepage;

import base.BasePage;
import investing.pom.futureschartpage.FuturesChartPage;
import investing.pom.resultpage.ResultPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage(){
        PageFactory.initElements(driver, this );

    }
    @FindBy(xpath = "//a[@class='login bold']")
    public WebElement signInButton;

    @FindBy(xpath ="//iframe[@src='https://www.google.com/recaptcha/api2/aframe']")
    public WebElement iframe;

    @FindBy(xpath = "//input[@id='loginFormUser_email']")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@id='loginForm_password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//a[@class='newButton orange']")
    public WebElement signInButton2;

    @FindBy(xpath = "//span[@class='myAccount topBarText']")
    public WebElement myAccountHeader;

    @FindBy(xpath = "//input[@class='searchText arial_12 lightgrayFont js-main-search-bar']")
    public WebElement searchBar;

    @FindBy(xpath = "//label[@class='searchGlassIcon js-magnifying-glass-icon']")
    public WebElement searchIcon;


    @FindBy(xpath = "//span[@class='myAccount topBarText']")
    public WebElement usernameDropdown;

    @FindBy(xpath = "//a[normalize-space()='Sign out']")
    public WebElement signOutButton;



    @FindBy(xpath = "//a[@href='//www.investing.com/charts/']")
    public WebElement chartDropdown;

    @FindBy(xpath = "//a[.='Futures Chart']")
    public WebElement futuresChartButton;








    public void clickOnSignInButton(){
        safeClickOnElement(signInButton);
    }
    public void inputEmail(String email){
        safeClickOnElement(emailInput);
        sendKeysToElement(emailInput, email);
    }

    public void inputPassword(String password){
        sendKeysToElement(passwordInput, password);
    }

    public void clickOnSignIn(){
        safeClickOnElement(signInButton2);
    }



    public void doSignIn(String email, String password){

        clickOnSignInButton();
             inputEmail(email);
        inputPassword(password);
        clickOnSignIn();
    }

    public void inputSearchBar(String searchTerm){
        sendKeysToElement(searchBar, searchTerm);
    }
    public void clickOnSearchIcon(){
        safeClickOnElement(searchIcon);
    }

    public ResultPage searchForSomething(String searchTerm){
        inputSearchBar(searchTerm);
        clickOnSearchIcon();

        return new ResultPage();

    }

    public void hoverOverUsernameDropdown(){
        hoverOverElement(usernameDropdown);
    }

    public void clickOnSignOutButton(){
        safeClickOnElement(signOutButton);
    }

    public void doSignOut(){
        hoverOverUsernameDropdown();
        clickOnSignOutButton();
    }


    public void hoverOverChartsDropdown(){
        hoverOverElement(chartDropdown);
    }

    public void clickOnFuturesChart(){
        safeClickOnElement(futuresChartButton);
    }

    public FuturesChartPage searchForChart(){
        hoverOverChartsDropdown();
        clickOnFuturesChart();

        return new FuturesChartPage();
    }



}
