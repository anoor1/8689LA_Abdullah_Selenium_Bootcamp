package testaddmodifycartdata;

import base.BasePage;
import luma.pom.addmodifycartpage.AddModifyCartPage;
import luma.pom.itemsearchpage.ItemSearchPage;
import org.testng.annotations.Test;

public class TestAddModifyCartData extends BasePage {
    @Test(priority = 6, groups = {"BAT"})
    public void testAddModifyCartData() {
        ItemSearchPage page = new ItemSearchPage();
        page.searchItem("Duffle Bag");
        AddModifyCartPage add=new AddModifyCartPage();
        add.addtoCartItem();
        add.modifyItem();
        add.removeCartItem();
    }
}
