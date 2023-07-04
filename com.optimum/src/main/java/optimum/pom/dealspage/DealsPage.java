package optimum.pom.dealspage;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DealsPage extends BasePage {

    public DealsPage(){
        PageFactory.initElements(driver, this);

    }
 @FindBy(xpath = "//div[@class='swiper-slide compare-plans-item swiper-slide-visible swiper-slide-active']//a[@class='button orange'][normalize-space()='Check availability']")
    public WebElement checkAvailability;
}
