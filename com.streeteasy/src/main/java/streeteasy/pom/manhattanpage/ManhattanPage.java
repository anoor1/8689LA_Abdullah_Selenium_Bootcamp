package streeteasy.pom.manhattanpage;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManhattanPage extends BasePage {

    public ManhattanPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@aria-label='Pets']")
    public WebElement petsButton;

    @FindBy(xpath = "//input[@id='radio-button-list-petPolicy-1']")
    public WebElement petsAllowed;

    @FindBy(xpath = "//button[@aria-label='Done']")
    public WebElement doneButton;

    @FindBy(xpath = "//h1[@class='srp-result-count']")
    public WebElement assertSearchResult;

    public void clickOnPetsButtons(){
        safeClickOnElement(petsButton);
    }
    public void clickOnPetsAllowedSquare(){
        safeClickOnElement(petsAllowed);

    }
    public void clickOnDoneButton(){
        safeClickOnElement(doneButton);
    }
    public void doSearchManhattan(){
        clickOnPetsButtons();
        clickOnPetsAllowedSquare();
        clickOnDoneButton();
    }
}
