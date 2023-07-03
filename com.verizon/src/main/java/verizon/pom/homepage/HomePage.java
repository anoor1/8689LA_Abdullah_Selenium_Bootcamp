package verizon.pom.homepage;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import verizon.pom.searchpage.SearchPage;

public class HomePage extends BasePage {
    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@id='gnav20-search-icon']")
    public WebElement searchButton;

    @FindBy(xpath = "//input[@id='search_box_gnav_input']")
    public WebElement inputSearchBox;

    @FindBy(xpath = "//a[@aria-label='iPhone 1 of 9']//span[contains(text(),'iPhone')]")
    public WebElement iPhoneSearchTerm;

    public void clickOnSearchButton(){
        safeClickOnElement(searchButton);

    }

    public void enterSearchTerm(){
        String searchTerm = "iphone";
        sendKeysToElement(inputSearchBox, searchTerm);
    }

    public void hoverOveriPhone(){
        hoverOverElement(iPhoneSearchTerm);
    }

    public void clickOnSearchTerm(){
        safeClickOnElement(iPhoneSearchTerm);
    }

    public void searchTerm(){
        clickOnSearchButton();
        enterSearchTerm();
        hoverOveriPhone();
        clickOnSearchTerm();
    }

}






