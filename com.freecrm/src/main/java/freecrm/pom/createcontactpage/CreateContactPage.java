package freecrm.pom.createcontactpage;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage extends BasePage {

    public CreateContactPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@name='last_name']")
    public WebElement lastNameInput;

    @FindBy(xpath = "//div[@name='company']/input[@type='text']")
    public WebElement companyNameInput;

    @FindBy (xpath = "//div[@class='ui fluid multiple search selection dropdown']")
    public WebElement tagsInput;

    @FindBy (xpath = "//div[@class='ui selection upward dropdown']")
    public WebElement categoryDropdown;

    @FindBy(xpath = "//div[@class='visible menu transition']//div[1]")
    public WebElement leadDropdownOption;

    @FindBy(xpath = "//textarea[@name='description']")
    public WebElement descriptionInput;

    @FindBy(xpath = "//div[@name='timezone']/input[@type='text']")
    public WebElement timezoneInput;

    @FindBy(xpath ="//input[@name='first_name']")
    public WebElement firstNameInputField;

    @FindBy(xpath ="//input[@name='middle_name']")
    public WebElement middleNameInputField;

    @FindBy(xpath = "//form[@class='ui form segment custom-form-container']//div[@class='ui right corner labeled input']/input[@name='value']")
    public WebElement emailInputEmail;

    @FindBy(xpath = "//form[@class='ui form segment custom-form-container']//div[@class='ui right corner labeled input']/input[@name='value']")
    public WebElement statusDropDownBox;

    @FindBy(xpath ="//span[.='Active']")
    public WebElement activeStatus;

    @FindBy(xpath="//input[@name='address']")
    public WebElement addressInputField;

    @FindBy(xpath="//input[@name='city']")
    public WebElement cityInputField;

    @FindBy(xpath ="//input[@name='state']")
    public WebElement stateInputField;

    @FindBy(xpath ="//input[@name='zip']")
    public WebElement zipInputField;

    public void inputFirstName(String firstName){
        sendKeysToElement(firstNameInputField, firstName);
    }
    public void inputLastName(String lastName){
        sendKeysToElement(lastNameInput, lastName);
    }
    public void inputMiddleName(String middleName){
        sendKeysToElement(middleNameInputField, middleName);
    }
    public void inputCompany(String companyName){
        sendKeysToElement(companyNameInput, companyName);
    }
    public void inputTag(String tagName){
        sendKeysToElement(tagsInput, tagName);
    }
    public void inputEmailAddress(String emailAddress){
        sendKeysToElement(emailInputEmail, emailAddress);
    }
    public void clickOnCategoryDropdown(){
        safeClickOnElement(categoryDropdown);
    }
    public void clickOnLead(){
        safeClickOnElement(leadDropdownOption);
    }
    public void clickOnStatusDropdown(){
        safeClickOnElement(statusDropDownBox);
    }
    public void clickOnActive(){
        safeClickOnElement(activeStatus);
    }
    public void inputDescription(String description){
        sendKeysToElement(descriptionInput, description);
    }
    public void inputTimeZone(String timeZone){
        sendKeysToElement(timezoneInput, timeZone);
    }
    public void inputStreetAddress(String streetAddress){
        sendKeysToElement(addressInputField, streetAddress);
    }
    public void inputCity(String city){
        sendKeysToElement(cityInputField, city);
    }
    public void inputState(String state){
        sendKeysToElement(stateInputField, state);
    }
    public void inputZipCode(String zip){
        sendKeysToElement(zipInputField, zip);
    }

    public void createNewContact(String firstName,String lastName,String middleName, String companyName, String tagName,
                                 String emailAddress,String description, String timeZone, String streetAddress, String city, String state, String zip){

        inputFirstName(firstName);
        inputLastName(lastName);
        inputMiddleName(middleName);
        inputCompany(companyName);
        inputTag(tagName);
        inputEmailAddress(emailAddress);
        clickOnCategoryDropdown();
        clickOnLead();
        clickOnStatusDropdown();
        clickOnActive();
        inputDescription(description);
        inputTimeZone(timeZone);
        inputStreetAddress(streetAddress);
        inputCity(city);
        inputState(state);
        inputZipCode(zip);

    }






}
