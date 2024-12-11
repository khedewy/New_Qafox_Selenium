package registerSuiteTests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class TestBase {
    protected WebDriver driver;


    @BeforeClass
    @Parameters({"browser"})
    public void setDriver(@Optional("chrome") String browserName){
        if (browserName.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.navigate().to("https://tutorialsninja.com/demo/");
        }
        else if (browserName.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.navigate().to("https://tutorialsninja.com/demo/");
        }
    }

    @AfterClass
    public void closeDriver(){
        driver.close();
    }

    @AfterMethod
    public void tearDown() {
        try {
            // Take screenshot if the test failed
            takeScreenshot();
        } catch (Exception e) {
            System.out.println("Test failed, screenshot captured.");
        } finally {

        }
    }

    private void takeScreenshot() {
        // Capture the screenshot only if the test failed
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            // Save the screenshot to a file
            FileUtils.copyFile(screenshot, new File("screenshot_" + System.currentTimeMillis() + ".png"));
            System.out.println("Screenshot taken.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
