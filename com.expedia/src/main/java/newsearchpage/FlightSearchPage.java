package newsearchpage;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightSearchPage extends BasePage {

    public FlightSearchPage() {
        PageFactory.initElements(driver, this);
    }


    public void selectDate(String date) {

    }
}
