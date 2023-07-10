package testcategoryresult;

import base.BasePage;
import luma.pom.homepage.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCategoryResult extends BasePage {
    @Test(priority = 7, groups = {"BAT"})
    public void testCategoryResult() {
        HomePage homepage = new HomePage();
        homepage.doFilterTo();
        Assert.assertTrue(isElementVisible(homepage.categoryJacketResult));
    }
}
