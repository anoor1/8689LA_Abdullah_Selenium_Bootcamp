package expedia.pom.flightresultpage;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightResultPage extends BasePage {

    public FlightResultPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h6[@class='uitk-heading uitk-heading-7']")
    public WebElement cheapestDepartingFlight;

}
