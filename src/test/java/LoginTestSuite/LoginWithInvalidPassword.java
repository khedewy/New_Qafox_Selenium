package LoginTestSuite;

import homePage.HomePage;
import loginData.InvalidEmailData;
import loginData.InvalidPasswordData;
import org.testng.Assert;
import org.testng.annotations.Test;
import registerSuiteTests.TestBase;

import java.io.IOException;


public class LoginWithInvalidPassword extends TestBase {
    HomePage homePage;
    LoginSuite.LoginWithInvalidPassword loginPage;

    @Test
    public void NavigateToLogin(){
        homePage = new HomePage(driver);
        homePage.navigateToLoginPage();


    }

    @Test(priority = 1)
    public void login() throws IOException, org.json.simple.parser.ParseException {
        InvalidPasswordData data = new InvalidPasswordData();
        data.loginData();
        loginPage = new LoginSuite.LoginWithInvalidPassword(driver);
        loginPage.enterLoginData(data.email, data.password);
        Assert.assertEquals(loginPage.getErrorMessage(),"Warning: No match for E-Mail Address and/or Password.");
    }
}
