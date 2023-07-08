package mbusa.pom.homepage;

import base.BasePage;
import mbusa.pom.loginpage.LoginPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[contains(@aria-label,'OK')]")
    public WebElement okButton;

    @FindBy(xpath = "//span[@class='global-header__button-label global-header__button-utility-inner']")
    public WebElement myAccountButton;

    @FindBy(id = "text-zoom-tracker")
    public WebElement iframe;

    @FindBy(xpath = "//button[@class='nav-profile__login nav-profile__button button button_primary button--wide ']")
    public WebElement loginButton;

    @FindBy(xpath = "//span[@class='global-header__button-label global-header__button-utility-inner']")
    public WebElement usernameHeader;

    public void clickOnMyAccountButton(){

        safeClickOnElement(myAccountButton);
    }
    public void switchToIframe(){

        driver.switchTo().frame(iframe);
    }
    public void clickOnLoginButton(){
        safeClickOnElement(loginButton);

    }
    public void clickOnOkButton()
    {

        safeClickOnElement(okButton);

    }
    public LoginPage workFlowLogin(){
        getVisibleElement(myAccountButton);
        clickOnByTabKey();
        clickOnMyAccountButton();
        clickOnLoginButton();

        return new LoginPage();
    }
}
