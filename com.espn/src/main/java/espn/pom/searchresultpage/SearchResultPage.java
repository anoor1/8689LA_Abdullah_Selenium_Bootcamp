package espn.pom.searchresultpage;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends BasePage {

    public SearchResultPage(){
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath = "//a[@aria-label='Top Results']")
    public WebElement topResultHeader;
}
