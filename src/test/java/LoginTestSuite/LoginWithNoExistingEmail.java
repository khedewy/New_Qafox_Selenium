package LoginTestSuite;

import homePage.HomePage;
import loginData.InvalidPasswordData;
import loginData.NonExistingEmailData;
import org.testng.Assert;
import org.testng.annotations.Test;
import registerSuiteTests.TestBase;

import java.io.IOException;

public class LoginWithNoExistingEmail extends TestBase {
    HomePage homePage;
    LoginSuite.LoginWithNonExistingEmail loginPage;

    @Test
    public void NavigateToLogin() {
        homePage = new HomePage(driver);
        homePage.navigateToLoginPage();


    }

    @Test(priority = 1)
    public void login() throws IOException, org.json.simple.parser.ParseException {
        NonExistingEmailData data = new NonExistingEmailData();
        data.loginData();
        loginPage = new LoginSuite.LoginWithNonExistingEmail(driver);
        loginPage.enterLoginData(data.email, data.password);
        Assert.assertEquals(loginPage.getErrorMessage(), "Warning: No match for E-Mail Address and/or Password.");

    }
}