package investing.pom.futureschartpage;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FuturesChartPage extends BasePage {
    public FuturesChartPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='newBtn portfolio LightGray']")
    public WebElement addToWatchlistButton;

    @FindBy(xpath = "//input[@class='checkbox']")
    public WebElement myWatchlistCheckBox;

    @FindBy(xpath = "//a[@class='newBtn Orange2 noIcon float_lang_base_2 js-addto-portfolios disabled']")
    public WebElement applyButton;

    @FindBy(xpath = "//div[normalize-space()='Added successfully']")
    public WebElement addedSuccessfullyPrompt;

    public void clickAddToWatchlist(){
        safeClickOnElement(addToWatchlistButton);
    }
    public void selectMyWatchlistCheckbox(){
        safeClickOnElement(myWatchlistCheckBox);
    }

    public void clickOnApply(){
        safeClickOnElement(applyButton);
    }
    public void addToWatchlist(){
        clickAddToWatchlist();
        selectMyWatchlistCheckbox();
        clickOnApply();
    }
}
