package testaddtocart;

import base.BasePage;
import optimum.pom.addtocartpage.AddToCartPage;
import optimum.pom.homepage.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAddToCart extends BasePage {

    @Test(priority = 1, groups = {"Smoke"})
    public void testAddToCart(){
        HomePage homePage = new HomePage();
        AddToCartPage addToCartPage = new AddToCartPage();

        homePage.clickOnShopPlansButton();
        String zipCode = "10001";
        addToCartPage.addToCart(zipCode);
        Assert.assertTrue(isElementVisible(addToCartPage.CartHeader));
    }
}
