package searchTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import registerSuiteTests.TestBase;

public class SearchWithInvalidKeyWord extends TestBase {
    searchPage.SearchWithInvalidKeyWord searchPage;
    @Test
    public void searchForProduct(){
        searchPage = new searchPage.SearchWithInvalidKeyWord(driver);
        searchPage.searchForProducts("Ihopne");
        Assert.assertEquals(searchPage.getErrorMessage(),"There is no product that matches the search criteria.");
    }
}
