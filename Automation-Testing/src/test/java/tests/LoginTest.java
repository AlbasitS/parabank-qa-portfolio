package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ExtentTestManager;

public class LoginTest extends BaseTest {

    @Test
    public void loginWithValidCredentials()
//            throws InterruptedException
    {
        ExtentTestManager.getTest().assignAuthor("Septian Al Basit");
        ExtentTestManager.getTest().assignCategory("Smoke");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUserName("syams");
        ExtentTestManager.info("Username entered");

        loginPage.enterPassword("@sY4m5-321");
        ExtentTestManager.info("Password entered");

//        Thread.sleep(2000);

        loginPage.clickLogin();
        ExtentTestManager.info("Login button clicked");
        System.out.println("Login Completed");

        ExtentTestManager.info("Verifying account overview page");

        Assert.assertTrue(
                loginPage.isAccountOverviewDisplayed(),
                "Login failed, Account Overview not displayed."
        );
        ExtentTestManager.pass("Login Successful");

    }
}
