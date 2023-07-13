package freecrm.pom.createcontactpage;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsAddedPage extends BasePage {

    public ContactsAddedPage(){
        PageFactory.initElements(driver,this);


    }
    @FindBy(xpath = "//i[@class='large user red icon']")
    public WebElement redIcon;
}
