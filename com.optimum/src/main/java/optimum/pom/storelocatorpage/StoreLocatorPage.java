package optimum.pom.storelocatorpage;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StoreLocatorPage extends BasePage {

    public StoreLocatorPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"js-locator\"]/div[5]/div/span[1]/text()")
    public WebElement storeWithinArea;
}
