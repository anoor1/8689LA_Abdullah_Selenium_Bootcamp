package optimum.pom.homepage;

import base.BasePage;
import optimum.pom.dealspage.DealsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    public HomePage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[@href='/deals'][normalize-space()='Deals']")
    public WebElement dealsButton;

    @FindBy(xpath = "//a[@href='/deals'][normalize-space()='All Deals']")
    public WebElement allDealsButton;

    @FindBy(xpath = "//input[@id='edit-add1--2']")
    public WebElement streetAddressSearchBar;

    @FindBy(xpath = "//input[@id='edit-zip--2']")
    public WebElement zipSearchBar;

    @FindBy(xpath = "//input[@id='edit-actions-submit--2']")
    public WebElement checkAvailabilityButton;

    @FindBy(xpath = "//div[@class='widget-count']")
    public WebElement addressResult;


    public DealsPage clickOnAllDealsButton(){
        safeClickOnElement(dealsButton);
        safeClickOnElement(allDealsButton);
        return new DealsPage();
    }


    public void inputStreetAddress(String address){
        sendKeysToElement(streetAddressSearchBar, address);
    }
    public void inputZip(String zip){
        sendKeysToElement(zipSearchBar, zip);
    }
    public void clickOnSearchButton(){
        safeClickOnElement(checkAvailabilityButton);
    }
    public void searchForAvailability(String address, String zip){
        inputStreetAddress(address);
        inputZip(zip);
        clickOnSearchButton();

    }
}

