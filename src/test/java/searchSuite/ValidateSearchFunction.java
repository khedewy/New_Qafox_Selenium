package searchSuite;

import org.testng.annotations.Test;
import registerSuiteTests.TestBase;

public class ValidateSearchFunction extends TestBase {
    searchPage.ValidateSearchFunction searchFunction;

    @Test
    public void searchForProduct(){
        searchFunction = new searchPage.ValidateSearchFunction(driver);
        searchFunction.searchForProducts("iphone");
    }
}
