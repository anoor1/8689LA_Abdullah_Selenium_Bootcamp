package espn.pom.homepage;

import base.BasePage;
import espn.pom.searchresultpage.SearchResultPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@id='global-search-trigger']")
    public WebElement searchBarIcon;

    @FindBy(xpath = "//input[@id='global-search-input']")
    public WebElement searchBarInput;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement searchSubmitButton;



    public void clickOnSearchIconButton(){
        safeClickOnElement(searchBarIcon);
    }
    public void inputInSearchBar(String searchTerm){
        sendKeysToElement(searchBarInput, searchTerm);
    }
    public void clickOnSearchSubmitButton(){
        safeClickOnElement(searchSubmitButton);
    }

    public SearchResultPage searchForATerm(String searchTerm){
        clickOnSearchIconButton();
        inputInSearchBar(searchTerm);
        clickOnSearchSubmitButton();

        return new SearchResultPage();
    }

}
