package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.aventstack.extentreports.ExtentReports;
import org.testng.ITestResult;
import utils.ExtentManager;
import utils.ExtentTestManager;
import utils.ScreenshotUtil;

import java.lang.reflect.Method;

public class BaseTest {

    protected WebDriver driver;
    protected ExtentReports extent;

    @BeforeMethod
    public void setUp(Method method){

        extent = ExtentManager.getInstance();

        ExtentTestManager.setTest(
                extent.createTest(method.getName())
        );

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://localhost:8080/parabank");
//      driver.get("https://parabank.parasoft.com/parabank/index.htm");
        ExtentTestManager.info("Navigate to Parabank application");

        System.out.println("Browser Opened");
        ExtentTestManager.info("Chrome browser launched");
    }

    @AfterMethod
    public void tearDown(ITestResult result){
        if (result.getStatus() == ITestResult.SUCCESS){
            ExtentTestManager.pass("Execution completed successfully");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            ExtentTestManager.fail(result.getThrowable().toString());

            String screenshot = ScreenshotUtil.captureScreenshot(driver, result.getName());

            ExtentTestManager.getTest()
                    .addScreenCaptureFromPath(screenshot);


        } else {
            ExtentTestManager.getTest().skip("Test skipped");
        }

        extent.flush();

        if(driver != null){
            driver.quit();
        }
        System.out.println("Browser Closed");
    }
}
