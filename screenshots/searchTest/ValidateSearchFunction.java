package searchTest;


import org.testng.annotations.Test;
import registerSuiteTests.TestBase;

public class ValidateSearchFunction extends TestBase {
    searchPage.ValidateSearchFunction searchPage;
    @Test
    public void searchForProduct(){
        searchPage = new searchPage.ValidateSearchFunction(driver);
        searchPage.searchForProducts("Iphone");


    }
}
