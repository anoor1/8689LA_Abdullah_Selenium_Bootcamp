package test_app_verizon;

import base.BasePage;
import org.testng.annotations.Test;
import verizon.pom.homepage.HomePage;
import verizon.pom.searchpage.SearchPage;

public class TestDoSearch extends BasePage {

    @Test(priority = 1, groups = "smoke")
    public void testDoSearch(){
        HomePage homePage = new HomePage();
        homePage.searchTerm();

    }
}
