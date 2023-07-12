package testradiobutton;

import base.BasePage;
import booking.pom.homepage.HomePage;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRadioButton extends BasePage {

    @Test(priority = 1, groups = {"Smoke"})
    public void testRoundTripRadioButton(){
        HomePage homePage = new HomePage();
        homePage.clickOnRoundTripRadioButton();
        checkElementSelected(homePage.roundTripRadioButton);

        //Verify that the radio button is selected
    }
    @Test(priority = 2, groups = {"Smoke"})
    public void testOneWayRadioButton(){
        HomePage homePage = new HomePage();
        homePage.clickOnOneWayRadioButton();
        checkElementSelected(homePage.oneWayRadioButton);

    }

    @Test(priority = 3, groups = {"Smoke"})
    public void testMultiCityRadioButton(){
        HomePage homePage = new HomePage();
        homePage.clickOnMultiCityRadioButton();
        checkElementSelected(homePage.multiCityRadioButton);

    }
}
