package registerSuiteTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import registerDataSuite.RegisterValidData;
import homePage.HomePage;

import java.io.IOException;
import java.text.ParseException;

public class RegisterWithoutAgreeingOnTerms extends TestBase{
    HomePage homePage;
    registerSuite.RegisterWithoutAgreeingOnTerms registerPage;
    String currentTime = String.valueOf(System.currentTimeMillis());

    @Test
    public void navigateToRegisterPage(){
        homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();
        registerPage = new registerSuite.RegisterWithoutAgreeingOnTerms(driver);

    }

    @Test(priority = 1)
    public void enterRegisterData() throws IOException, ParseException, org.json.simple.parser.ParseException {
        RegisterValidData data = new RegisterValidData();
        data.registerData();
        registerPage = new registerSuite.RegisterWithoutAgreeingOnTerms(driver);
        registerPage.enterRegisterData(data.firstName, data.lastName, data.email+currentTime+"@gmail.com",
                data.telephone, data.password);
        Assert.assertEquals(registerPage.getErrorMessage(),"Warning: You must agree to the Privacy Policy!");

    }
}
