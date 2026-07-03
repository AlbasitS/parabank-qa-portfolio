package tests;


import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.OpenNewAccountPage;
import utils.ExtentTestManager;

public class OpenNewAccountTest extends BaseTest {

    @Test
    public void openNewAccountSuccessfully() throws InterruptedException
    {
        ExtentTestManager.getTest().assignAuthor("Septian Al Basit");
        ExtentTestManager.getTest().assignCategory("Regression", "Account");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserName("syams");
        loginPage.enterPassword("@sY4m5-321");
        ExtentTestManager.info("Entering login credentials");

        loginPage.clickLogin();
        ExtentTestManager.info("Login button clicked");

        OpenNewAccountPage accountPage = new OpenNewAccountPage(driver);
        accountPage.clickOpenNewAccount();
        ExtentTestManager.info("Navigate to Open New Account");
        Thread.sleep(1000);

        //Dropdown Handling
        accountPage.selectAccountType("SAVINGS");
        ExtentTestManager.info("Selecting account type : SAVINGS");

        accountPage.clickOpenNewAccountButton();
        ExtentTestManager.info("Submitting account creation request");
        Thread.sleep(1000);

        Assert.assertTrue(
                accountPage.isAccountCreatedSuccessfully(),"Open New Account Failed"
        );
        ExtentTestManager.pass("New account created successfully");
    }
}
