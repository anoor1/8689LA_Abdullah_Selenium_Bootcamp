package testlanguage;

import bankofamerica.pom.bankofamericapage.BankOfAmericaPage;
import base.BasePage;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLanguage extends BasePage {

    @Test(priority = 1, groups = {"BAT"})
    public void testSwitchLanguages(){
        BankOfAmericaPage bankOfAmericaPage = new BankOfAmericaPage();
        bankOfAmericaPage.clickToSwitchLanguages();
        Assert.assertTrue(isElementVisible(bankOfAmericaPage.languageButton));
    }

}

