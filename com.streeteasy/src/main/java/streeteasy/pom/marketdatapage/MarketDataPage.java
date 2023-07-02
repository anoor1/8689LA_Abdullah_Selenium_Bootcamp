package streeteasy.pom.marketdatapage;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static base.BasePage.driver;

public class MarketDataPage extends BasePage {

    public MarketDataPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h1[normalize-space()='Market Data']")
    public WebElement marketDataHeader;
}
