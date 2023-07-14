package streeteasy.pom.homepage;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import streeteasy.pom.manhattanpage.ManhattanPage;
import streeteasy.pom.marketdatapage.MarketDataPage;

public class HomePage extends BasePage {

    public HomePage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[@aria-label='Blog']")
    public WebElement blogDropdown;

    @FindBy(xpath = "//a[normalize-space()='Market Data']")
    public WebElement marketDataButton;


    @FindBy(xpath = "//button[@aria-label='Sign In / Register']")
    public WebElement signInButton;

    @FindBy(xpath = "//iframe[@id='universal_pixel_rfdw4bs']")
    public WebElement iframe;

    @FindBy(xpath = "//input[@id='login-email-input']")
    public WebElement emailInput;

    @FindBy(xpath = "//button[normalize-space()='Submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[normalize-space()='Log in']")
    public WebElement loginButton;


    @FindBy(xpath = "//button[@aria-label='Buy']")
    public WebElement buyButton;

    @FindBy(xpath = "//a[@data-gtm-header-menu='Sales'][normalize-space()='Manhattan']")
    public WebElement manhattanButton;

    public void clickOnBuyButton(){
        safeClickOnElement(buyButton);
    }
    public void clickOnManhattanButton(){
        safeClickOnElement(manhattanButton);

    }
    public ManhattanPage goToManhattanPage(){
        clickOnBuyButton();
        clickOnManhattanButton();

        return new ManhattanPage();
    }







    public void hoverOverBlogDropdown() {
        hoverOverElement(blogDropdown);
    }

    public void clickOnMarketDataButton() {
        safeClickOnElement(marketDataButton);
    }

    public MarketDataPage checkForMarketHeader() {
        hoverOverBlogDropdown();
        clickOnMarketDataButton();

        return new MarketDataPage();

    }

    public void clickOnSignInButton(){
        safeClickOnElement(signInButton);
    }

    public void switchToIframe(){
        driver.switchTo().frame(iframe);
    }

    public void inputEmail(String email){
        sendKeysToElement(emailInput, email);
    }

    public void clickOnSubmitButton(){
        safeClickOnElement(submitButton);
    }

    public void inputPassword(String password){
        sendKeysToElement(passwordInput, password);
    }

    public void clickOnLoginButton(){
        safeClickOnElement(loginButton);
    }

    public void DoSignIn(String email, String password){
        clickOnSignInButton();
       // switchToIframe();
        inputEmail(email);
        clickOnSubmitButton();
        inputPassword(password);
        clickOnLoginButton();

    }

}




