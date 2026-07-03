package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.TransferFundsPage;
import utils.ExtentTestManager;

public class TransferFundsTest extends BaseTest {

    @Test
    public void transferFundsSuccessfully() throws InterruptedException
    {
        ExtentTestManager.getTest().assignAuthor("Septian Al Basit");
        ExtentTestManager.getTest().assignCategory("Regression", "Transfer Funds");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserName("syams");
        loginPage.enterPassword("@sY4m5-321");
        ExtentTestManager.info("Entering login credentials");

        loginPage.clickLogin();
        ExtentTestManager.info("Login successful");

        TransferFundsPage transferFundsPage = new TransferFundsPage(driver);
        transferFundsPage.clickTransferFunds();
        ExtentTestManager.info("Navigate to Transfer Funds");
        Thread.sleep(1000);
        transferFundsPage.enterAmountField("10");
        ExtentTestManager.info("Transfer amount: 10");

        transferFundsPage.clickTransferButton();
        ExtentTestManager.info("Submit transfer");
        System.out.println("Transfer Complete!");

        Assert.assertTrue(
                transferFundsPage.isTransferSuccessDisplayed(),
                "An internal error has occurred and has been logged. "
        );
        ExtentTestManager.pass("Transfer completed successfully.");
    }


    @Test
    public void transferFundsNegativeAmount() throws InterruptedException
    {
        ExtentTestManager.getTest().assignAuthor("Septian Al Basit");
        ExtentTestManager.getTest().assignCategory("Regression", "Transfer Funds");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserName("syams");
        loginPage.enterPassword("@sY4m5-321");
        ExtentTestManager.info("Entering login credentials");

        loginPage.clickLogin();
        ExtentTestManager.info("Login successful");

        TransferFundsPage transferFundsPage = new TransferFundsPage(driver);
        transferFundsPage.clickTransferFunds();
        ExtentTestManager.info("Navigate to Transfer Funds");
        Thread.sleep(1000);
        transferFundsPage.enterAmountField("-10");
        ExtentTestManager.info("Transfer amount: -10");

        transferFundsPage.clickTransferButton();
        ExtentTestManager.info("Submit transfer");
        System.out.println("Transfer Complete!");

        Assert.assertTrue(
                transferFundsPage.isTransferSuccessDisplayed(),
                "An internal error has occurred and has been logged. "
        );
        ExtentTestManager.pass("Negative amount validation passed.");
    }

    @Test
    public void transferExceedingBalance() throws InterruptedException
    {
        ExtentTestManager.getTest().assignAuthor("Septian Al Basit");
        ExtentTestManager.getTest().assignCategory("Regression", "Transfer Funds");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserName("syams");
        loginPage.enterPassword("@sY4m5-321");
        ExtentTestManager.info("Entering login credentials");

        loginPage.clickLogin();
        ExtentTestManager.info("Login successful");

        TransferFundsPage transferFundsPage = new TransferFundsPage(driver);
        transferFundsPage.clickTransferFunds();
        ExtentTestManager.info("Navigate to Transfer Funds");
        Thread.sleep(1000);
        transferFundsPage.enterAmountField("1000");
        ExtentTestManager.info("Transfer amount: 1000");

        transferFundsPage.clickTransferButton();
        ExtentTestManager.info("Submit transfer");
        System.out.println("Transfer Complete!");

        Assert.assertTrue(
                transferFundsPage.isTransferSuccessDisplayed(),
                "An internal error has occurred and has been logged. "
        );
        ExtentTestManager.pass("Transfer exceeding balance processed as expected.");
    }
}
