package freecrm.pom.loginpage;

import base.BasePage;
import freecrm.pom.homepage.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//input[@placeholder='Email']")
    public WebElement emailInput;

    @FindBy (xpath = "//input[@placeholder='Password']")
    public WebElement passwordInput;

    @FindBy (xpath = "//div[@class='ui fluid large blue submit button']")
    public WebElement loginButton;

    public void setEmailInput(String email){
        sendKeysToElement(emailInput, email);
    }
    public void setPasswordInput(String password){
        sendKeysToElement(passwordInput, password);
    }
    public void clickLoginButton(){
        safeClickOnElement(loginButton);
    }

    public DashboardPage doSignIn(String email, String password) {
        setEmailInput(email);
        setPasswordInput(password);
        clickLoginButton();

        return new DashboardPage();
    }

}
