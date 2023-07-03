package bmwusa.pom.homepage;

import base.BasePage;
import bmwusa.pom.loginpage.LoginPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[@class='globalnav-primary-my-bmw__portal-link label-2--bold']")
    public WebElement myBmwButton;


    public LoginPage clickOnMyBmwButton() {
        safeClickOnElement(myBmwButton);

        return new LoginPage();
    }


}
