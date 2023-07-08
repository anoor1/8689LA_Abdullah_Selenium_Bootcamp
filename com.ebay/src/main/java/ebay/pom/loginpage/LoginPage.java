package ebay.pom.loginpage;

import base.BasePage;
import ebay.pom.homepage.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='userid']")
    public WebElement emailInput;

    @FindBy(xpath = "//button[@id='signin-continue-btn']")
    public WebElement continueButton;

    @FindBy(xpath = "//input[@id='pass']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@id='sgnBt']")
    public WebElement signInButton2;

    public void inputEmail(String email){
        sendKeysToElement(emailInput, email);
    }
    public void clickOnContinueButton(){
        safeClickOnElement(continueButton);
    }
    public void inputPassword(String password){
        sendKeysToElement(passwordInput, password);
    }

    public void clickOnSignInButton(){
        safeClickOnElement(signInButton2);
    }
    public HomePage doSignIn(String email,String password){
        inputEmail(email);
        clickOnContinueButton();
        inputPassword(password);
        clickOnSignInButton();

        return new HomePage();
    }
}
