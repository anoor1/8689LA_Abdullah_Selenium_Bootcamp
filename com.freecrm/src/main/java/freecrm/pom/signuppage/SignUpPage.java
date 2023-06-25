package freecrm.pom.signuppage;

import base.BasePage;
import freecrm.pom.homepage.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends BasePage {

    public SignUpPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='email']")
    public WebElement inputEmail;

    @FindBy(xpath = "//input[@id='terms']")
    public WebElement termsOfUseButton;

    @FindBy(xpath = "//*[@id=\"recaptcha-anchor\"]/div[1]")
    public WebElement amNotARobotButton;

    @FindBy(xpath = "//button[@name='action']")
    public WebElement signUpButton;


    public void setInputEmail(String email) {
        sendKeysToElement(inputEmail, email);
    }

    public void clickTermsOfUseButton() {
        safeClickOnElement(termsOfUseButton);
    }

    public void clickIAmNotARobotButton() {
        safeClickOnElement(amNotARobotButton);
    }

    public void clickSignUpButton() {
        safeClickOnElement(signUpButton);
    }

    public ValidatePage signUp(String email) {

        setInputEmail(email);
        clickTermsOfUseButton();
        clickIAmNotARobotButton();
        clickSignUpButton();

        return new ValidatePage();


    }
}


