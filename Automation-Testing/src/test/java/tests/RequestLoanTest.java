package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RequestLoanPage;
import utils.ExtentTestManager;

public class RequestLoanTest extends BaseTest {

    @Test
    public void requestLoanWithValidAmount()
    {
        ExtentTestManager.getTest().assignAuthor("Septian Al Basit");
        ExtentTestManager.getTest().assignCategory("Regression", "Request Loan");

        LoginPage loginPage = new LoginPage(driver);

        ExtentTestManager.info("Entering login credentials");
        loginPage.enterUserName("syams");
        loginPage.enterPassword("@sY4m5-321");

        loginPage.clickLogin();
        ExtentTestManager.info("Login button clicked");

        RequestLoanPage requestLoanPage = new RequestLoanPage(driver);
        requestLoanPage.clickRequestLoanLink();
        ExtentTestManager.info("Navigate to Request Loan");

        ExtentTestManager.info("Entering Request Loan Amount");
        requestLoanPage.inputLoanAmount("1000");
        requestLoanPage.inputDownPayment("100");

        requestLoanPage.clickApplyNowButton();
        ExtentTestManager.info("Submit Request Loan");

        Assert.assertTrue(
                requestLoanPage.isRequestLoanApprove(),
                "Error! An internal error has occurred and has been logged"
        );
        ExtentTestManager.pass("Loan request approved successfully.");
    }

    @Test
    public void requestLoanWithAmountLowerThanDownPayment()
    {
        ExtentTestManager.getTest().assignAuthor("Septian Al Basit");
        ExtentTestManager.getTest().assignCategory("Regression", "Request Loan");

        LoginPage loginPage = new LoginPage(driver);

        ExtentTestManager.info("Entering login credentials");
        loginPage.enterUserName("syams");
        loginPage.enterPassword("@sY4m5-321");

        loginPage.clickLogin();
        ExtentTestManager.info("Login button clicked");

        RequestLoanPage requestLoanPage = new RequestLoanPage(driver);
        requestLoanPage.clickRequestLoanLink();
        ExtentTestManager.info("Navigate to Request Loan");

        ExtentTestManager.info("Entering Request Loan Amount Lower Than Down Payment");
        requestLoanPage.inputLoanAmount("100");
        requestLoanPage.inputDownPayment("200");

        requestLoanPage.clickApplyNowButton();
        ExtentTestManager.info("Submit Request Loan");

        Assert.assertTrue(
                requestLoanPage.isRequestLoanDenied(),
                "Error! An internal error has occurred and has been logged"
        );
        ExtentTestManager.pass("Loan request denied as expected.");
    }

    @Test
    public void requestLoanWithEmptyLoanAmount()
    {
        ExtentTestManager.getTest().assignAuthor("Septian Al Basit");
        ExtentTestManager.getTest().assignCategory("Regression", "Request Loan");

        LoginPage loginPage = new LoginPage(driver);

        ExtentTestManager.info("Entering login credentials");
        loginPage.enterUserName("syams");
        loginPage.enterPassword("@sY4m5-321");

        loginPage.clickLogin();
        ExtentTestManager.info("Login button clicked");

        RequestLoanPage requestLoanPage = new RequestLoanPage(driver);
        requestLoanPage.clickRequestLoanLink();
        ExtentTestManager.info("Navigate to Request Loan");

        ExtentTestManager.info("Entering Request Loan, Empty Loan Amount");
        requestLoanPage.inputLoanAmount("");
        requestLoanPage.inputDownPayment("100");

        requestLoanPage.clickApplyNowButton();
        ExtentTestManager.info("Submit Request Loan");

        Assert.assertTrue(
                requestLoanPage.isRequestLoanError(),
                "Error! An internal error has occurred and has been logged"
        );
        ExtentTestManager.pass("Validation for empty loan amount displayed successfully.");
    }

    @Test
    public void requestLoanWithEmptyDownPayment()
    {
        ExtentTestManager.getTest().assignAuthor("Septian Al Basit");
        ExtentTestManager.getTest().assignCategory("Regression", "Request Loan");

        LoginPage loginPage = new LoginPage(driver);

        ExtentTestManager.info("Entering login credentials");
        loginPage.enterUserName("syams");
        loginPage.enterPassword("@sY4m5-321");

        loginPage.clickLogin();
        ExtentTestManager.info("Login button clicked");

        RequestLoanPage requestLoanPage = new RequestLoanPage(driver);
        requestLoanPage.clickRequestLoanLink();
        ExtentTestManager.info("Navigate to Request Loan");

        ExtentTestManager.info("Entering Request Loan, Empty Down Payment Amount");
        requestLoanPage.inputLoanAmount("1000");
        requestLoanPage.inputDownPayment("");

        requestLoanPage.clickApplyNowButton();
        ExtentTestManager.info("Submit Request Loan");

        Assert.assertTrue(
                requestLoanPage.isRequestLoanError(),
                "Error! An internal error has occurred and has been logged"
        );
        ExtentTestManager.pass("Validation for empty down payment displayed successfully.");
    }
}
