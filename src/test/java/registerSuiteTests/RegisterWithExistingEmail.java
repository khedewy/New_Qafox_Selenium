package registerSuiteTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import registerDataSuite.ExistingData;
import homePage.HomePage;

import java.io.IOException;
import java.text.ParseException;

public class RegisterWithExistingEmail extends TestBase{
    HomePage homePage;
    registerSuite.RegisterWithExistingEmail registerPage;
    String currentTime = String.valueOf(System.currentTimeMillis());

    @Test
    public void navigateToRegisterPage(){
        homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();
        registerPage = new registerSuite.RegisterWithExistingEmail(driver);

    }

    @Test(priority = 1)
    public void enterRegisterData() throws IOException, ParseException, org.json.simple.parser.ParseException {
        ExistingData data = new ExistingData();
        data.registerData();
        registerPage = new registerSuite.RegisterWithExistingEmail(driver);
        registerPage.enterRegisterData(data.firstName, data.lastName, data.email, data.telephone, data.password);
        Assert.assertEquals(registerPage.getErrorMessage(),"Warning: E-Mail Address is already registered!");

    }
}
