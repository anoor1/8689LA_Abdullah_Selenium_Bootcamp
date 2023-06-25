package freecrm.pom.loginpage;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BasePage {

    public DashboardPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@role='listbox']")
    public WebElement settingsButton;

    @FindBy(xpath = "//span[normalize-space()='Log Out']")
    public WebElement logOutButton;

    @FindBy(xpath = "//span[@class='user-display']")
    public WebElement nameHeader;

    public void clickONSettingsButton(){
        safeClickOnElement(settingsButton);
    }
    public void clickOnLogOutButton(){
        safeClickOnElement(logOutButton);
    }

}
