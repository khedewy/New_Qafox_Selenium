package searchPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchWithInvalidKeyWord {
    private WebDriver driver;
    public SearchWithInvalidKeyWord(WebDriver driver){
        this.driver = driver;
    }
    private final By searchBox = By.name("search");
    private final By searchButton = By.xpath("//button[@class='btn btn-default btn-lg']");
    private final By errorMessage = By.xpath("//p[text()='There is no product that matches the search criteria.']");

    public void searchForProducts(String product){
        driver.findElement(searchBox).sendKeys(product);
        driver.findElement(searchButton).click();
    }

    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }
}
