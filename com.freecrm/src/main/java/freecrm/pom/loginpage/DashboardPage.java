package freecrm.pom.loginpage;

import base.BasePage;
import freecrm.pom.createcontactpage.CreateContactPage;
import freecrm.pom.taskpage.TaskPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BasePage {

    public DashboardPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@role='listbox']")
    public WebElement settingsButton;

//    @FindBy(xpath = "//span[normalize-space()='Log Out']")
//    public WebElement logOutButton;

    @FindBy(xpath = "//span[@class='user-display']")
    public WebElement nameHeader;

    @FindBy(xpath = "//i[@class='users icon']")
    public WebElement contactIcon;

    @FindBy(xpath = "//div[@id='main-nav']/div[3]/button[@class='ui mini basic icon button']")
    public WebElement contactAddButton;

    @FindBy(xpath = "//span[.='Log Out']")
    public WebElement logOutButton;

    @FindBy(xpath = "//div[@class='ui basic button floating item dropdown']/i[@class='settings icon']")
    public WebElement settingIcon;


    @FindBy(xpath ="//i[@class='tasks icon']")
    public  WebElement tasksIcon;
    @FindBy(xpath ="//div[@id='main-nav']/div[6]/button[@class='ui mini basic icon button']")
    public  WebElement addTasksIcon;



    public void clickONSettingsButton(){
        safeClickOnElement(settingsButton);
    }
    public void clickOnLogOutButton(){
        safeClickOnElement(logOutButton);
    }

    public void hoverOverContactIcon(){
        hoverOverElement(contactIcon);

    }
    public void clickContactAddButton(){
        safeClickOnElement(contactAddButton);
    }

    public CreateContactPage doClickContactAddButton(){
        hoverOverElement(contactIcon);
        safeClickOnElement(contactAddButton);

        return new CreateContactPage();

    }
    public void clickOnSettingButton(){
        safeClickOnElement(settingIcon);
    }
    public void clickOnLogoutButton(){
        safeClickOnElement(logOutButton);
    }
    public LoginPage doLogOut(){
        clickOnSettingButton();
        clickOnLogOutButton();
        return new LoginPage();
    }

    public void hoverOverTasksIcon(){
        hoverOverElement(tasksIcon);
    }
    public void clickOnAddTasksIcon(){
        safeClickOnElement(addTasksIcon);
    }

    public TaskPage hoverClickOnTasksIcon(){
        hoverOverTasksIcon();
        clickOnAddTasksIcon();
        return new TaskPage();
    }

    public CreateContactPage doClickAddButton(){
        hoverOverContactIcon();
        clickContactAddButton();
        return new CreateContactPage();
    }

}
