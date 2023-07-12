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
        driver.findElement(By.xpath("//label[@for='search_type_option_ROUNDTRIP']//span[@class='InputRadio-module__field___4Jbyo']")).isSelected();
        //Verify that the radio button is selected
    }
    @Test(priority = 2, groups = {"Smoke"})
    public void testOneWayRadioButton(){
        HomePage homePage = new HomePage();
        homePage.clickOnOneWayRadioButton();
        driver.findElement(By.xpath("//label[@for='search_type_option_ONEWAY']//span[@class='InputRadio-module__field___4Jbyo']")).isSelected();
    }

    @Test(priority = 3, groups = {"Smoke"})
    public void testMultiCityRadioButton(){
        HomePage homePage = new HomePage();
        homePage.clickOnMultiCityRadioButton();
        driver.findElement(By.xpath("//label[@for='search_type_option_MULTISTOP']//span[@class='InputRadio-module__field___4Jbyo']")).isSelected();
    }
}
