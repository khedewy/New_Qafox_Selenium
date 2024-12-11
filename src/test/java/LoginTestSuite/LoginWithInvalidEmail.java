package LoginTestSuite;

import homePage.HomePage;
import loginData.InvalidEmailData;
import org.testng.Assert;
import org.testng.annotations.Test;
import registerSuiteTests.TestBase;

import java.io.IOException;
import java.text.ParseException;

public class LoginWithInvalidEmail extends TestBase {
    HomePage homePage;
    LoginSuite.LoginWithInvalidEmail loginPage;

    @Test
    public void NavigateToLogin(){
        homePage = new HomePage(driver);
        homePage.navigateToLoginPage();
        loginPage = new LoginSuite.LoginWithInvalidEmail(driver);

    }

    @Test(priority = 1)
    public void login() throws IOException, ParseException, org.json.simple.parser.ParseException {
        InvalidEmailData data = new InvalidEmailData();
        data.loginData();
        loginPage = new LoginSuite.LoginWithInvalidEmail(driver);
        loginPage.enterLoginData(data.email, data.password);
        Assert.assertEquals(loginPage.getErrorMessage(),"Warning: No match for E-Mail Address and/or Password.");
    }
}
