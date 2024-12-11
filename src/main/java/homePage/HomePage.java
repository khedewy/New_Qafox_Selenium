package homePage;


import LoginSuite.LoginWithValidData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import registerSuite.RegisterWithValidData;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    WebDriverWait wait;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    private final By accountManager = By.xpath("//a[@title='My Account']");
    private final By registerButton = By.xpath("//a[text()='Register']");
    private final By loginButton = By.linkText("Login");


    public RegisterWithValidData navigateToRegisterPage(){
        driver.findElement(accountManager).click();
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(registerButton)));
        driver.findElement(registerButton).click();
        return new RegisterWithValidData(driver);
    }
    public LoginWithValidData navigateToLoginPage(){
        driver.findElement(accountManager).click();
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(loginButton)));
        driver.findElement(loginButton).click();
        return new LoginWithValidData(driver);
    }

}
