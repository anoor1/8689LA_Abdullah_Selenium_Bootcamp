package stayssearchpage;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaysSearchPage extends BasePage {

    public StaysSearchPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[@aria-label='Going to']")
    public WebElement goingtobutton;


    @FindBy(xpath = "//input[@placeholder='Going to']")
    public WebElement goingtotxtbox;

    @FindBy(xpath = "(//button[@data-stid='destination_form_field-result-item-button'])[1]")
    public WebElement selectFirstCity;


    @FindBy(xpath = "//button[@id='d1-btn']")
    public WebElement checkinDateFieldButton;

    @FindBy(xpath = "//button[@id='d2-btn']")
    public WebElement checkoutDateFieldButton;

    @FindBy(xpath = "//button[@data-stid='apply-date-picker']")
    public WebElement doneButton;

    @FindBy(xpath = "//button[@data-stid='open-room-picker']")
    public WebElement selecttravellerbutton;

    @FindBy(xpath="//button[@data-testid='submit-button']")
    public WebElement searchbutton;

    @FindBy(xpath = "//button[@data-stid='show-more-results']")
    public WebElement showmoreResults;

    @FindBy(xpath = "(//a[@data-stid='open-hotel-information'])[1]")
    public WebElement searchHotelData;

    public void selectDate(String date)
    {
        WebElement dateElement=driver.findElement(By.xpath("(//button[@data-day='"+date+"'])[1]"));
        safeClickOnElement(dateElement);

    }



    public void searchFlight(String goingtocity,String fromDate,String toDate)
    {

        safeClickOnElement(goingtobutton);
        safeClickOnElement(goingtotxtbox);
        sendKeysToElement(goingtotxtbox,goingtocity);
        safeClickOnElement(selectFirstCity);

        safeClickOnElement(checkinDateFieldButton);
        selectDate(fromDate);
        safeClickOnElement(doneButton);
        safeClickOnElement(checkoutDateFieldButton);
        selectDate(toDate);
        safeClickOnElement(doneButton);
        clickOnElement(searchbutton);

    }









}
