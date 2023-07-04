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


    public DealsPage clickOnAllDealsButton(){
        safeClickOnElement(dealsButton);
        safeClickOnElement(allDealsButton);
        return new DealsPage();
    }
}
