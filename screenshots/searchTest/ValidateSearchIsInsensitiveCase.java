package searchTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import registerSuiteTests.TestBase;

public class ValidateSearchIsInsensitiveCase extends TestBase {
    searchPage.SearchWithValidKeyWord searchPage;
    @Test
    public void searchForProduct(){
        searchPage = new searchPage.SearchWithValidKeyWord(driver);
        searchPage.searchForProducts("IPHONE");
        Assert.assertEquals(searchPage.getAssertionMessage(),"iPhone");
        searchPage.searchForProducts("Iphone");
        Assert.assertEquals(searchPage.getAssertionMessage(),"iPhone");



    }
}
