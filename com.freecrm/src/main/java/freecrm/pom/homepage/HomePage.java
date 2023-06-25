package freecrm.pom.homepage;

import base.BasePage;
import freecrm.pom.signuppage.SignUpPage;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage() {

        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[contains(text(),'Sign Up')]")
    public WebElement signUpButton;

    public SignUpPage clickSignUpButton(){
        safeClickOnElement(signUpButton);

        return new SignUpPage();

    }

}
