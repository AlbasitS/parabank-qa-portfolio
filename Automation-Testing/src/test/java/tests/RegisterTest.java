package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegisterPage;
import utils.ExtentTestManager;

public class RegisterTest extends BaseTest {

    @Test
    public void registerWithValidCredentials()
    {
        ExtentTestManager.getTest().assignAuthor("Septian Al Basit");
        ExtentTestManager.getTest().assignCategory("Smoke");

        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.clickRegisterLinkPage();
        ExtentTestManager.info("Navigate to Register Page");

        ExtentTestManager.info("Entering customer registration information");
        registerPage.inputFirstName("Syams");
        registerPage.inputLastName("Noor");;
        registerPage.inputAddress("Setiabudi");
        registerPage.inputCity("Jakarta");
        registerPage.inputState("Indonesia");
        registerPage.inputZipCode("123456");
        registerPage.inputPhone("08123456789");
        registerPage.inputSsn("123");

//        registerPage.inputUserName("user" + System.currentTimeMillis());
        ExtentTestManager.info("Entering account credentials");
        registerPage.inputUserName("syams");
        registerPage.inputPassword("@sY4m5-321");
        registerPage.inputConfirmPassword("@sY4m5-321");

        registerPage.clickRegisterButton();
        ExtentTestManager.info("Submitting registration form");

        Assert.assertTrue(
                registerPage.isRegistrationSuccessDisplayed(),
                "Registration Failed"
        );
        ExtentTestManager.pass("Registration completed successfully");
    }
}
