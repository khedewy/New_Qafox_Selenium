package LoginSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginWithInvalidPassword {
    private final WebDriver driver;
    public LoginWithInvalidPassword(WebDriver driver){
        this.driver = driver;
    }
    private final By emailTxt = By.id("input-email");
    private final By passwordTxt = By.id("input-password");
    private final By loginButton = By.xpath("//input[@value='Login']");
    private final By errorMessage = By.xpath("//div[@class='alert alert-danger alert-dismissible']");



    public void enterLoginData(String email, String password){
        driver.findElement(emailTxt).sendKeys(email);
        driver.findElement(passwordTxt).sendKeys(password);
        driver.findElement(loginButton).click();
    }
    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }
}
