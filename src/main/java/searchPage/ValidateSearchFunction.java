package searchPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ValidateSearchFunction {
    private WebDriver driver;
    public ValidateSearchFunction(WebDriver driver){
        this.driver = driver;
    }
    private final By searchBox = By.name("search");
    private final By searchButton = By.xpath("//button[@class='btn btn-default btn-lg']");

    public void searchForProducts(String product){
        driver.findElement(searchBox).sendKeys(product);
        driver.findElement(searchButton).click();


    }

}
