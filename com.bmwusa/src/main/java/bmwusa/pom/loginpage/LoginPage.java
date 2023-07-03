package bmwusa.pom.loginpage;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@class='custom-button __b primary']")
    public WebElement loginButton;


    public void inputEmail(String email){
        sendKeysToElement(emailInput, email);
    }
    public void inputPassword(String password){
        sendKeysToElement(passwordInput, password);
    }
    public void clickOnLoginButton(){
        safeClickOnElement(loginButton);
    }
    public void doLogin(String email, String password){
        inputEmail(email);
        inputPassword(password);
        clickOnLoginButton();
    }
}
