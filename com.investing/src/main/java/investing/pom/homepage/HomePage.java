package investing.pom.homepage;

import base.BasePage;
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






}
