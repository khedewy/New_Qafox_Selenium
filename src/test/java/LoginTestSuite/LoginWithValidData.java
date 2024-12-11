package LoginTestSuite;

import homePage.HomePage;
import loginData.LoginValidData;
import org.testng.Assert;
import org.testng.annotations.Test;
import registerSuiteTests.TestBase;

import java.io.IOException;
import java.text.ParseException;

public class LoginWithValidData extends TestBase {
    HomePage homePage;

    LoginSuite.LoginWithValidData loginPage;

    @Test
    public void NavigateToLogin(){
        homePage = new HomePage(driver);
        homePage.navigateToLoginPage();
        loginPage = new LoginSuite.LoginWithValidData(driver);

    }

    @Test(priority = 1)
    public void login() throws  IOException, ParseException, org.json.simple.parser.ParseException {
        LoginValidData data = new LoginValidData();
        data.loginData();
        loginPage = new LoginSuite.LoginWithValidData(driver);
        loginPage.enterLoginData(data.email, data.password);
        Assert.assertEquals(loginPage.getSuccessfulLoginAssertionMessage(),"My Account");
    }
}
