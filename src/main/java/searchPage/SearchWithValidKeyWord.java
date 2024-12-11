package searchPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchWithValidKeyWord {
    private WebDriver driver;
    public SearchWithValidKeyWord(WebDriver driver){
        this.driver = driver;
    }
    private final By searchBox = By.name("search");
    private final By searchButton = By.xpath("//button[@class='btn btn-default btn-lg']");
    private final By assertionMessage = By.xpath("//a[text()='iPhone']");

    public void searchForProducts(String product){
        driver.findElement(searchBox).sendKeys(product);
        driver.findElement(searchButton).click();
        driver.findElement(searchBox).clear();
    }

    public String getAssertionMessage(){
        return driver.findElement(assertionMessage).getText();
    }
}
