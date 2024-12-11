package LoginTestSuite;

import homePage.HomePage;
import loginData.EmptyEmailData;
import loginData.InvalidEmailData;
import org.testng.Assert;
import org.testng.annotations.Test;
import registerSuiteTests.TestBase;

import java.io.IOException;


public class LoginWithEmptyEmail extends TestBase {
    HomePage homePage;
    LoginSuite.LoginWithEmptyEmail loginPage;

    @Test
    public void NavigateToLogin(){
        homePage = new HomePage(driver);
        homePage.navigateToLoginPage();

    }

    @Test(priority = 1)
    public void login() throws IOException, org.json.simple.parser.ParseException {
        EmptyEmailData data = new EmptyEmailData();
        data.loginData();
        loginPage = new LoginSuite.LoginWithEmptyEmail(driver);
        loginPage.enterLoginData(data.email, data.password);
        Assert.assertEquals(loginPage.getErrorMessage(),"Warning: No match for E-Mail Address and/or Password.");
    }
}
