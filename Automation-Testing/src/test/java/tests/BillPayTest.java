package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BillPayPage;
import pages.LoginPage;
import utils.ExtentTestManager;

public class BillPayTest extends BaseTest {

    @Test
    public void billPayWithValidCredentials()
    {
        ExtentTestManager.getTest().assignAuthor("Septian Al Basit");
        ExtentTestManager.getTest().assignCategory("Regression", "Bill Pay");

        LoginPage loginPage = new LoginPage(driver);

        ExtentTestManager.info("Entering login credentials");
        loginPage.enterUserName("syams");
        loginPage.enterPassword("@sY4m5-321");

        ExtentTestManager.info("Login button clicked");
        loginPage.clickLogin();

        BillPayPage billPayPage = new BillPayPage(driver);
        billPayPage.clickBillPayLink();
        ExtentTestManager.info("Navigate to Transfer Funds");

        ExtentTestManager.info("Entering bill payment details");
        billPayPage.inputBillPayeeName("Your Own");
        billPayPage.inputBillPayAddress("Setia Budi");
        billPayPage.inputBillPayCity("Jakarta");
        billPayPage.inputBillPayState("Indonesia");
        billPayPage.inputBillPayZipCode("123456");
        billPayPage.inputBillPayPhone("08123456789");

        billPayPage.inputBillPayAccount("112233");
        billPayPage.inputBillPayVerifyAccount("112233");

        billPayPage.inputBillPayAmount("55");

        billPayPage.clickSendPaymentButton();
        ExtentTestManager.info("Submitting bill payment");

        Assert.assertTrue(
                billPayPage.isBillPaySuccessfully(),
                "Bill Payment Failed"
        );
        ExtentTestManager.pass("Bill pay completed successfully.");
    }
}
