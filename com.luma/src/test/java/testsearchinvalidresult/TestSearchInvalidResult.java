package testsearchinvalidresult;

import base.BasePage;
import luma.pom.itemsearchpage.ItemSearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSearchInvalidResult extends BasePage {
    @Test(priority = 8, groups = {"BAT"})
    public void testSearchInvalidResult() {
        ItemSearchPage page = new ItemSearchPage();
        page.searchWrongItem("12345");
        Assert.assertTrue(isElementVisible(page.noResultsReturned));
    }
}
