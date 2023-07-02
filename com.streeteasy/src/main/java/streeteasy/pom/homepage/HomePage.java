package streeteasy.pom.homepage;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import streeteasy.pom.marketdatapage.MarketDataPage;

public class HomePage extends BasePage {

    public HomePage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[@aria-label='Blog']")
    public WebElement blogDropdown;

    @FindBy(xpath = "//a[normalize-space()='Market Data']")
    public WebElement marketDataButton;



    public void hoverOverBlogDropdown() {
        hoverOverElement(blogDropdown);
    }

    public void clickOnMarketDataButton() {
        safeClickOnElement(marketDataButton);
    }

    public MarketDataPage checkForMarketHeader() {
        hoverOverBlogDropdown();
        clickOnMarketDataButton();

        return new MarketDataPage();

    }
}




