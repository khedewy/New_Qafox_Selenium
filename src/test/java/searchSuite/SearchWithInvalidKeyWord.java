package searchSuite;

import org.testng.Assert;
import org.testng.annotations.Test;
import registerSuiteTests.TestBase;
import searchPage.SearchWithValidKeyWord;

public class SearchWithInvalidKeyWord extends TestBase {
    searchPage.SearchWithInvalidKeyWord searchFunction;
    @Test
    public void searchForProduct(){
        searchFunction = new searchPage.SearchWithInvalidKeyWord(driver);
        searchFunction.searchForProducts("ihopne");
        Assert.assertEquals(searchFunction.getErrorMessage(),"There is no product that matches the search criteria.");
    }
}
