package apartments.pom.homepage;

import apartments.pom.authenticationpage.SignInPage;
import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[@title='Sign Up']")
    public WebElement signupButton;

    @FindBy(xpath = "//div[@id='username']/button/span")
    public WebElement loggedInUsername;

    @FindBy(xpath="//a[@title='Sign In']")
    public WebElement firstSignInButton;


    public SignInPage clickFirstSignInButton(){;
        safeClickOnElement(firstSignInButton);

        return new SignInPage();
    }

    }



