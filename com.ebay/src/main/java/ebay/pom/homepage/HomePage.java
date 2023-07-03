package ebay.pom.homepage;

import base.BasePage;
import ebay.pom.searchresultpage.SearchResultPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    @FindBy(id = "gh-ac")
    public WebElement inputSearchBar;

    @FindBy (id = "gh-btn")
    public WebElement buttonSearchSubmit;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void inputSearchTerm(String searchTerm) {
        sendKeysToElement(inputSearchBar, searchTerm);
    }

    public void clickSearchSubmitButton() {
        safeClickOnElement(buttonSearchSubmit);
    }

    public SearchResultPage doSearch(String searchTerm) {
        inputSearchTerm(searchTerm);
        clickSearchSubmitButton();

        return new SearchResultPage();
    }


}
