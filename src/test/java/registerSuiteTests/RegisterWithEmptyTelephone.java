package registerSuiteTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import registerDataSuite.EmptyTelephoneData;
import homePage.HomePage;

import java.io.IOException;
import java.text.ParseException;

public class RegisterWithEmptyTelephone extends TestBase{
    HomePage homePage;
    registerSuite.RegisterWithEmptyTelephone registerPage;
    String currentTime = String.valueOf(System.currentTimeMillis());

    @Test
    public void navigateToRegisterPage(){
        homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();

    }

    @Test(priority = 1)
    public void enterRegisterData() throws IOException, ParseException, org.json.simple.parser.ParseException {
        EmptyTelephoneData data = new EmptyTelephoneData();
        data.registerData();
        registerPage = new registerSuite.RegisterWithEmptyTelephone(driver);
        registerPage.enterRegisterData(data.firstName, data.lastName, data.email+currentTime+"@gmail.com",
                data.telephone, data.password);

        Assert.assertEquals(registerPage.getErrorMessage(),"Telephone must be between 3 and 32 characters!");




    }
}
