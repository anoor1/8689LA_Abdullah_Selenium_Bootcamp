package testsql;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Database;

import java.sql.SQLException;

public class TestSql extends BasePage {

    @Test public void testCreateCompany() throws SQLException {
        //Business Logic

        String query = "SELECT COUNT(*) FROM COMPANIES WHERE NAME = 'Tesla'";
        databaseInit();
        //excel. } takes from the excelsheet you introduce
        Object result = db.executeQueryReadOne(query);
       Assert.assertTrue(result.toString().equals("1"));


    }
}
