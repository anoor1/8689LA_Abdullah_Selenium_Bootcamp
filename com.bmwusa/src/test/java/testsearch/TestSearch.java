package testsearch;

import base.BasePage;
import bmwusa.pom.homepage.HomePage;
import org.testng.annotations.Test;

public class TestSearch extends BasePage {



        @Test(priority = 1, groups = "smoke")
        public void testDoSearch(){
            HomePage homePage = new HomePage();
            String searchTerm = "bmw x5";
            homePage.searchForSomething(searchTerm);

        }

}
