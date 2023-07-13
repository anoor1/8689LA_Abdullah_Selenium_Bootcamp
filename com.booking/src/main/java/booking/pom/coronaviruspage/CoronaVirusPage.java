package booking.pom.coronaviruspage;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoronaVirusPage extends BasePage {

    public CoronaVirusPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"bodyconstraint-inner\"]/section[1]/div/h1")
    public WebElement coronaHelpPrompt;
}
