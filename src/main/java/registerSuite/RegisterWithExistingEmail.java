package registerSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterWithExistingEmail {
    private final WebDriver driver;
    public RegisterWithExistingEmail(WebDriver driver){
        this.driver = driver;
    }
    private final By firstNameTxt = By.id("input-firstname");
    private final By lastNameTxt = By.id("input-lastname");
    private final By emailTxt = By.id("input-email");
    private final By telephoneTxt = By.id("input-telephone");
    private final By passwordTxt = By.id("input-password");
    private final By confirmPassWordTxt = By.id("input-confirm");
    private final By agreeOnServices = By.xpath("//input[@type='checkbox']");
    private final By continueButton = By.xpath("//input[@value='Continue']");
    private final By errorMessage = By.xpath("//div[@class='alert alert-danger alert-dismissible']");



    public void enterRegisterData(String firstName, String lastName, String email, String telephone, String password){
        driver.findElement(firstNameTxt).sendKeys(firstName);
        driver.findElement(lastNameTxt).sendKeys(lastName);
        driver.findElement(emailTxt).sendKeys(email);
        driver.findElement(telephoneTxt).sendKeys(telephone);
        driver.findElement(passwordTxt).sendKeys(password);
        driver.findElement(confirmPassWordTxt).sendKeys(password);
        driver.findElement(agreeOnServices).click();
        driver.findElement(continueButton).click();
    }

    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }
}
