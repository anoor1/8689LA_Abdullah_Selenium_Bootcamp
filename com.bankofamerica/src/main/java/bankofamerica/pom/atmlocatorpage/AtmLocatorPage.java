package bankofamerica.pom.atmlocatorpage;

import bankofamerica.pom.bankofamericapage.BankOfAmericaPage;
import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AtmLocatorPage extends BasePage {

    public AtmLocatorPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@id='q']")
    public WebElement searchBar;

    @FindBy(xpath = "//button[@id='search-button']")
    public WebElement searchButton;

    @FindBy(xpath = "//div[@id='aria-map-list-header']")
    public WebElement resultForATM;

    public void enterZipOnSearchBar(String zip){
        sendKeysToElement(searchBar, zip);
    }
    public void clickOnSearchButton(){
        safeClickOnElement(searchButton);
    }
    public void searchForAtm(String zip){
        enterZipOnSearchBar(zip);
        clickOnSearchButton();
    }
}
