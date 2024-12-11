package LoginSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginWithValidData {
    private final WebDriver driver;
    public LoginWithValidData (WebDriver driver){
        this.driver = driver;
    }


    private final By emailTxt = By.id("input-email");
    private final By passwordTxt = By.id("input-password");
    private final By loginButton = By.xpath("//input[@value='Login']");
    private final By LoginSuccessfullyMessage = By.xpath("//h2[text()='My Account']");



    public void enterLoginData(String email, String password){
        driver.findElement(emailTxt).sendKeys(email);
        driver.findElement(passwordTxt).sendKeys(password);
        driver.findElement(loginButton).click();
    }
    public String getSuccessfulLoginAssertionMessage(){
        return driver.findElement(LoginSuccessfullyMessage).getText();
    }

}
