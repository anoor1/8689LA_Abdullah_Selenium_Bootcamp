package luma.pom.createaccountpage;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage extends BasePage {

    @FindBy(id="firstname")
    public WebElement firstname;

    @FindBy(id="lastname")
    public WebElement lastname;


    @FindBy(name="is_subscribed")
    public WebElement signupnewsletter;

    @FindBy(name="email")
    public WebElement email;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(id="password-confirmation")
    public WebElement passwordconfirmation;


    @FindBy(xpath = "//button[@title='Create an Account']")
    public WebElement createaccount;

    @FindBy(xpath = "//div[contains(text(),'Thank you for registering with Main Website Store.')]")
    public WebElement registeruservalidation;

    @FindBy(xpath = "(//a[contains(text(),'Create an Account')])[1]")
    public WebElement createaccountLink;




    public CreateAccountPage(){
        PageFactory.initElements(driver, this);
    }

    public void createAccount()
    {
        clickOnElement(createaccountLink);
        sendKeysToElement(firstname, "abc1");
        sendKeysToElement(lastname, "xyz1");
        clickOnElement(signupnewsletter);
        //Please change email id before run
        sendKeysToElement(email, "abdullah.noor14@gmail.com");
        sendKeysToElement(password, "Qqwerty@123!");
        sendKeysToElement(passwordconfirmation, "QqwertyQ@123!");
        clickOnElement(createaccount);

    }

    public void createAccountwithParam(String fName,String lName,String emailId,String pass) {
        clickOnElement(createaccountLink);
        sendKeysToElement(firstname, fName);
        sendKeysToElement(lastname, lName);
        clickOnElement(signupnewsletter);
        sendKeysToElement(email, emailId);
        sendKeysToElement(password, pass);
        sendKeysToElement(passwordconfirmation, pass);
        clickOnElement(createaccount);
    }

    }
