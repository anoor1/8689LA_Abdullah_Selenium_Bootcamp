package freecrm.pom.homepage;

import base.BasePage;
import freecrm.pom.loginpage.DashboardPage;
import freecrm.pom.loginpage.LoginPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public LoginPage clickOnLoginButton;

    public HomePage() {

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[normalize-space()='Log In']")
    public WebElement loginButton;

    public DashboardPage clickOnLoginButton() {
        safeClickOnElement(loginButton);

        return new DashboardPage();
    }







    }


