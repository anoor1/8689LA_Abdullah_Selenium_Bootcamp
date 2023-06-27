package apartments.pom.authenticationpage;

import apartments.pom.homepage.HomePage;
import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends BasePage {

    public SignInPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//iframe[contains(@id,'iFrameResizer')]")
    public WebElement loginFrame;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement emailAddressInput;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@id='loginButton']")
    public WebElement secondSignInButton;

    public void inputEmailAddress(String email){

        sendKeysToElement(emailAddressInput, email);
    }

    public void inputPassword(String password){
        sendKeysToElement(passwordInput,password);
    }
    public void clickSecondSignInButton(){
        safeClickOnElement(secondSignInButton);
    }

    public HomePage doSignIn(String email, String password){
        switchToFrameByElement(loginFrame);
        inputEmailAddress(email);
        inputPassword(password);
        clickSecondSignInButton();

        return new HomePage();
    }

}
