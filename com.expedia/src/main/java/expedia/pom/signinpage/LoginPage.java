package expedia.pom.signinpage;

import base.BasePage;
import expedia.pom.homepage.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//input[@id='loginFormEmailInput']")
    public WebElement inputEmailField;

    @FindBy(xpath="//button[@id='loginFormSubmitButton']")
    public WebElement continueButton;

    @FindBy(xpath="//button[@id='passwordButton']")
    public WebElement enterPasswordInsteadButton;

    @FindBy(xpath="//input[@id='enterPasswordFormPasswordInput']")
    public WebElement passwordInputField;

    @FindBy(xpath = "//button[@id='enterPasswordFormSubmitButton']")
    public WebElement submitButton;


    public void enterEmailAddress(String email){
        sendKeysToElement(inputEmailField,email);
    }
    public void clickOnContinueButton(){
        jsClickOnElement(continueButton);
    }
    public void clickOnEnterPasswordOption(){
        safeClickOnElement(enterPasswordInsteadButton);
    }

    public void enterPassword(String password){
        sendKeysToElement(passwordInputField,password);
    }

    public void clickSubmitButton(){
        safeClickOnElement(submitButton);
    }

    public HomePage doSignIn(String email, String password){
        enterEmailAddress(email);
        clickOnContinueButton();
        clickOnEnterPasswordOption();
        enterPassword(password);
        clickSubmitButton();

        return new HomePage();
    }
}
