package optimum.pom.homepage;

import base.BasePage;
import optimum.pom.addtocartpage.AddToCartPage;
import optimum.pom.contactuspage.ContactUsPage;
import optimum.pom.dealspage.DealsPage;
import optimum.pom.mobilepage.MobilePage;
import optimum.pom.storelocatorpage.StoreLocatorPage;
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

    @FindBy(xpath = "//a[normalize-space()='Shop plans']")
    public WebElement shopPlansButton;

    public AddToCartPage clickOnShopPlansButton(){
        safeClickOnElement(shopPlansButton);

        return new AddToCartPage();
    }




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



    @FindBy(xpath = "//*[@id=\"nav-item-4\"]/div[1]/a" )
    public WebElement dealsButton2;

    @FindBy(xpath = "//*[@id=\"nav-item-4_1\"]/div/a")
    public WebElement allDealsButton2;
    public DealsPage clickOnAllDeals(){
        safeClickOnElement(dealsButton);
        safeClickOnElement(allDealsButton);
        return new DealsPage();
    }

    @FindBy (xpath = "//*[@id=\"nav-item-2\"]/div[1]/a")
    public WebElement mobileButton;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div[2]/div/nav/div/div/ul/li[2]/div/div/ul/li[3]/div[1]/a[1]")
    public WebElement phonesButton;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div[2]/div/nav/div/div/ul/li[2]/div/div/ul/li[3]/div[2]/ul/li[1]/a")
    public WebElement allPhonesButton;

    public MobilePage clickOnAllPhonesButton(){
        safeClickOnElement(mobileButton);
        safeClickOnElement(phonesButton);
        safeClickOnElement(allPhonesButton);
        return new MobilePage();
    }

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[8]/a/b")
    public WebElement storeLocatorButton;

    @FindBy(xpath = "//*[@id=\"q\"]")
    public WebElement zipInputField;

    @FindBy(xpath = "//button[@type='submit']//*[name()='svg']")
    public WebElement locatorSearchButton;


    @FindBy(xpath = "//a[normalize-space()='Contact us']")
    public WebElement contactUsButton;

    public StoreLocatorPage locatingNearStore(){
        safeClickOnElement(storeLocatorButton);
        safeClickOnElement(zipInputField);
        zipInputField.sendKeys("11420");
        safeClickOnElement(locatorSearchButton);
        return new StoreLocatorPage();
    }

    public ContactUsPage clickOnContactsButton(){
       safeClickOnElement(contactUsButton);

       return new ContactUsPage();
    }
}

