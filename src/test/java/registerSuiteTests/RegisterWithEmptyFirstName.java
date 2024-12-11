package registerSuiteTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import registerDataSuite.EmptyFirstNameData;
import homePage.HomePage;

import java.io.IOException;
import java.text.ParseException;

public class RegisterWithEmptyFirstName extends TestBase{
    HomePage homePage;
    registerSuite.RegisterWithEmptyFirstName registerPage;
    String currentTime = String.valueOf(System.currentTimeMillis());

    @Test
    public void navigateToRegisterPage(){
        homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();

    }

    @Test(priority = 1)
    public void enterRegisterData() throws IOException, ParseException, org.json.simple.parser.ParseException {
        EmptyFirstNameData data = new EmptyFirstNameData();
        data.registerData();
        registerPage = new registerSuite.RegisterWithEmptyFirstName(driver);
        registerPage.enterRegisterData(data.firstName, data.lastName, data.email+currentTime+"@gmail.com",
                data.telephone, data.password);

        Assert.assertEquals(registerPage.getErrorMessage(),"First Name must be between 1 and 32 characters!");




    }
}
