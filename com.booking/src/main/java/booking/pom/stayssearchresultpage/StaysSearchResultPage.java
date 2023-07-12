package booking.pom.stayssearchresultpage;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaysSearchResultPage extends BasePage {

    public StaysSearchResultPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h1[@aria-label='Search results updated. Myrtle Beach: 443 properties found.']")
    public WebElement propertiesFoundHeader;
}
