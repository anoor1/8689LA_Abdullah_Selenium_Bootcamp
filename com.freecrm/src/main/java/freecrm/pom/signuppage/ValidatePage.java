package freecrm.pom.signuppage;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.Driver;

public class ValidatePage extends BasePage {

    public ValidatePage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy (xpath = "//div[@class='ui message']")
    public WebElement checkYourEmailText;

}
