package ebay.pom.searchresultpage;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//div[@class='srp-controls__row-cells']//h1/span[2]")
    public WebElement textSearchTerm;

    @FindBy(xpath = "//span[contains(text(),'Add to cart')]")
    public WebElement addToCartButton;

    @FindBy(xpath = "//span[contains(text(),'Go to cart')]")
    public WebElement goToCartButton;

    @FindBy(xpath = "//button[normalize-space()='Go to checkout']")
    public WebElement goToCheckoutButton;

    @FindBy(xpath = "//ul[@class='srp-results srp-list clearfix']/li[2]//div[@class='s-item__image-wrapper image-treatment']")
    public WebElement desiredItem;

    public SearchResultPage() {
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getSearchResults() {
        return driver.findElements(By.xpath("//ul[@class='srp-results srp-list clearfix']/li[@data-viewport]"));
    }

    public void clickOnDesiredItem(){
        safeClickOnElement(desiredItem);
        switchToTab();
    }
    public void clickOnAddToCart() {
        safeClickOnElement(addToCartButton);
    }
    public void clickOnGoToCart(){
        safeClickOnElement(goToCartButton);
    }

    public void doAddCart(){
        clickOnDesiredItem();
        clickOnAddToCart();
        clickOnGoToCart();
    }
}


