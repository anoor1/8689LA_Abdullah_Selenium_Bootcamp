package espn.pom.tennispage;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TennisPage extends BasePage {
    public TennisPage(){
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath = "//img[contains(@data-default-src,'https')]")
    public WebElement embeddedMediaSource;
}
