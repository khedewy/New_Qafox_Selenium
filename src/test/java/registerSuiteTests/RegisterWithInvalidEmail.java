package registerSuiteTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import registerDataSuite.RegisterValidData;
import homePage.HomePage;

import java.io.IOException;
import java.text.ParseException;

public class RegisterWithInvalidEmail extends TestBase {
    HomePage homePage;
    registerSuite.RegisterWithInvalidEmail registerPage;
    String currentTime = String.valueOf(System.currentTimeMillis());

    @Test
    public void navigateToRegisterPage(){
        homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();
        registerPage = new registerSuite.RegisterWithInvalidEmail(driver);
        Assert.assertEquals(registerPage.getRegisterPageAssertionMessage(),"Register Account");
    }

    @Test(priority = 1)
    public void enterRegisterData() throws IOException, ParseException, org.json.simple.parser.ParseException {
        RegisterValidData data = new RegisterValidData();
        data.registerData();
        registerPage = new registerSuite.RegisterWithInvalidEmail(driver);
        registerPage.enterRegisterData(data.firstName, data.lastName, data.email+currentTime, data.telephone, data.password);


    }
}
