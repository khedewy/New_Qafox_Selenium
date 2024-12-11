package searchTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import registerSuiteTests.TestBase;

public class SearchWithValidKeyWord extends TestBase {
    searchPage.SearchWithValidKeyWord searchPage;
    @Test
    public void searchForProduct(){
        searchPage = new searchPage.SearchWithValidKeyWord(driver);
        searchPage.searchForProducts("Iphone");
        Assert.assertEquals(searchPage.getAssertionMessage(),"iPhone");
    }
}
