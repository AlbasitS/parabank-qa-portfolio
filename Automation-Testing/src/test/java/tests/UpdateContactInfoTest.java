package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.UpdateContactInfoPage;
import utils.ExtentTestManager;

public class UpdateContactInfoTest extends BaseTest {

    // Data yang akan diinput
    String newFirstName = "qwerty";

    @Test
    public void updateContactWithValidCredentials()
    {
        ExtentTestManager.getTest().assignAuthor("Septian Al Basit");
        ExtentTestManager.getTest().assignCategory("Regression", "Update Contact Info");

        LoginPage loginPage = new LoginPage(driver);

        ExtentTestManager.info("Entering login credentials");
        loginPage.enterUserName("syams");
        loginPage.enterPassword("@sY4m5-321");

        loginPage.clickLogin();
        ExtentTestManager.info("Login button clicked");

        UpdateContactInfoPage updateContactInfoPage = new UpdateContactInfoPage(driver);
        updateContactInfoPage.clickUpdateContactInfoLink();
        ExtentTestManager.info("Navigate to Update Contact Info");

        ExtentTestManager.info("Entering new update contact information");
        updateContactInfoPage.inputUpdateContactInfoFirstName(newFirstName);
        updateContactInfoPage.inputUpdateContactInfoLastName("Noor");
        updateContactInfoPage.inputUpdateContactInfoAddress("Dasana Indah");
        updateContactInfoPage.inputUpdateContactInfoCity("Tangerang");
        updateContactInfoPage.inputUpdateContactInfoState("Indonesia");
        updateContactInfoPage.inputUpdateContactInfoZipCode("654321");
        updateContactInfoPage.inputUpdateContactInfoPhone("0898989698");

        updateContactInfoPage.clickUpdateProfileButton();
        ExtentTestManager.info("Submit new update contact");

        // Cek 1: Pesan sukses muncul?
        Assert.assertTrue(updateContactInfoPage.isUpdateContactInfoSuccessfully(), "Update Profile Failed");
        System.out.println("✅ Pesan sukses: " + updateContactInfoPage.getUpdateSuccessMessage());
        // Note: ParaBank does not re-populate form fields after page reload.
        // Verification is based on success message returned by the server,
        // which confirms data was accepted and saved by the backend.

        // Cek 2: Data benar-benar tersimpan? (reload lalu bandingkan)  ✅ TAMBAH
        updateContactInfoPage.clickUpdateContactInfoLink();
        String savedFirstName = updateContactInfoPage.getFirstNameFieldValue();
        Assert.assertEquals(savedFirstName, newFirstName, "❌ First name tidak terupdate!");
        System.out.println("✅ First name berhasil tersimpan: " + savedFirstName);

        ExtentTestManager.pass("Contact information updated successfully.");
    }


    @Test
    public void updateContactWithEmptyCredentials()
    {
        ExtentTestManager.getTest().assignAuthor("Septian Al Basit");
        ExtentTestManager.getTest().assignCategory("Regression", "Update Contact Info");

        LoginPage loginPage = new LoginPage(driver);

        ExtentTestManager.info("Entering login credentials");
        loginPage.enterUserName("syams");
        loginPage.enterPassword("@sY4m5-321");

        loginPage.clickLogin();
        ExtentTestManager.info("Login button clicked");

        UpdateContactInfoPage updateContactInfoPage = new UpdateContactInfoPage(driver);
        updateContactInfoPage.clickUpdateContactInfoLink();
        ExtentTestManager.info("Navigate to Update Contact Info");

        ExtentTestManager.info("Entering new update contact with empty First Name and Address field");
        updateContactInfoPage.inputUpdateContactInfoFirstName("");  // ✅ input kosong
        updateContactInfoPage.inputUpdateContactInfoLastName("Noor");
        updateContactInfoPage.inputUpdateContactInfoAddress("");    // ✅ input kosong
        updateContactInfoPage.inputUpdateContactInfoCity("Tangerang");
        updateContactInfoPage.inputUpdateContactInfoState("Indonesia");
        updateContactInfoPage.inputUpdateContactInfoZipCode("654321");
        updateContactInfoPage.inputUpdateContactInfoPhone("0898989698");

        updateContactInfoPage.clickUpdateProfileButton();
        ExtentTestManager.info("Click new update contact");

        Assert.assertTrue(
                updateContactInfoPage.isFirstNameErrorDisplayed(),
                "Error firstName seharusnya muncul!"
        );
        System.out.println("✅ Error firstName: " + updateContactInfoPage.getFirstNameErrorMessage());

        // Cek error address muncul
        Assert.assertTrue(
                updateContactInfoPage.isAddressErrorDisplayed(),
                "Error address seharusnya muncul!"
        );
        System.out.println("✅ Error address: " + updateContactInfoPage.getAddressErrorMessage());

        ExtentTestManager.pass("Update Contact validation verified.");
    }
}
