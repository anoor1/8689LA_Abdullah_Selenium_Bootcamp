package optimum.pom.addtocartpage;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage extends BasePage {
    public AddToCartPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@class='lineListColumn']//span[contains(text(),'Add to cart')]")
    public WebElement addToCartButton;

    @FindBy(xpath = "//span[normalize-space()='No, I am a new customer']")
    public WebElement newCustomerButton;

    @FindBy(xpath = "//a[normalize-space()='Skip']")
    public WebElement skipButton;

    @FindBy(xpath = "//input[@id='email-input']")
    public WebElement zipCodeInputField;

    @FindBy(xpath = "//span[.='Submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//button[@onclick=\"s_objectID = 'Continue'\"]")
    public WebElement continueButton;

    @FindBy(xpath = "//div[@class='title-xs']")
    public WebElement CartHeader;

    public void clickOnAddToCartButton(){
        safeClickOnElement(addToCartButton);
    }
    public void clickOnNewCustomerButton(){
        safeClickOnElement(newCustomerButton);
    }
    public void clickOnSkipButton(){
        safeClickOnElement(skipButton);
    }
    public void enterZipCode(String zipCode){
        sendKeysToElement(zipCodeInputField,zipCode);
    }
    public void clickOnSubmitButton(){
        safeClickOnElement(submitButton);
    }
    public void clickOnContinueButton(){
        safeClickOnElement(continueButton);
    }

    public void addToCart(String zipCode){
        clickOnAddToCartButton();
        clickOnNewCustomerButton();
        clickOnSkipButton();
        enterZipCode(zipCode);
        clickOnSubmitButton();
        clickOnContinueButton();
    }


}
