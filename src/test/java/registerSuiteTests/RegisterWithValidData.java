package registerSuiteTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import registerDataSuite.RegisterValidData;
import homePage.HomePage;

import java.io.IOException;
import java.text.ParseException;

public class RegisterWithValidData extends TestBase{
    HomePage homePage;
    registerSuite.RegisterWithValidData registerPage;
    String currentTime = String.valueOf(System.currentTimeMillis());

    @Test
    public void navigateToRegisterPage(){
        homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();
        registerPage = new registerSuite.RegisterWithValidData(driver);

    }

    @Test(priority = 1)
    public void enterRegisterData() throws IOException, ParseException, org.json.simple.parser.ParseException {
        RegisterValidData data = new RegisterValidData();
        data.registerData();
        registerPage = new registerSuite.RegisterWithValidData(driver);
        registerPage.enterRegisterData(data.firstName, data.lastName, data.email+currentTime+"@gmail.com", data.telephone, data.password);
        Assert.assertEquals(registerPage.getErrorMessage(),"Your Account Has Been Created!");

    }
}
