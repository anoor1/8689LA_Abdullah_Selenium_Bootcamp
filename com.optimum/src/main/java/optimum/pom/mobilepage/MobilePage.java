package optimum.pom.mobilepage;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobilePage extends BasePage {

    public MobilePage(){
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//*[@id=\"main-content\"]/div[2]/div/div[2]/h2")
    public WebElement checkOurLatestPhones;

}
