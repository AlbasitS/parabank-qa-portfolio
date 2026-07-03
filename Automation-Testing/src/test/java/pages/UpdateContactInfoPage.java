package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UpdateContactInfoPage {
    WebDriver driver;

    public UpdateContactInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    //=======LOCATORS=======
    By updateContactInfoLink = By.linkText("Update Contact Info");
    By updateContactInfoFirstName = By.name("customer.firstName");
    By updateContactInfoLastName = By.name("customer.lastName");
    By updateContactInfoAddress = By.name("customer.address.street");
    By updateContactInfoCity = By.name("customer.address.city");
    By updateContactInfoState = By.name("customer.address.state");
    By updateContactInfoZipCode = By.name("customer.address.zipCode");
    By updateContactInfoPhone = By.name("customer.phoneNumber");
    By updateProfileButton = By.xpath("//input[@value='Update Profile']");
    By updateProfileSuccessMessage = By.id("updateProfileResult");

    By updateContactInfoFirstNameError = By.id("firstName-error");
    By updateContactInfoAddressError = By.id("street-error");

    //=======ACTION METHODS=======
    public void clickUpdateContactInfoLink(){
        driver.findElement(updateContactInfoLink).click();
    }
    public void inputUpdateContactInfoFirstName(String firstname){
        driver.findElement(updateContactInfoFirstName).clear();
        driver.findElement(updateContactInfoFirstName).sendKeys(firstname);
    }
    public void inputUpdateContactInfoLastName(String lastname){
        driver.findElement(updateContactInfoLastName).clear();
        driver.findElement(updateContactInfoLastName).sendKeys(lastname);
    }
    public void inputUpdateContactInfoAddress(String address){
        driver.findElement(updateContactInfoAddress).clear();
        driver.findElement(updateContactInfoAddress).sendKeys(address);
    }
    public void inputUpdateContactInfoCity(String city){
        driver.findElement(updateContactInfoCity).clear();
        driver.findElement(updateContactInfoCity).sendKeys(city);
    }
    public void inputUpdateContactInfoState(String state){
        driver.findElement(updateContactInfoState).clear();
        driver.findElement(updateContactInfoState).sendKeys(state);
    }
    public void inputUpdateContactInfoZipCode(String zipcode){
        driver.findElement(updateContactInfoZipCode).clear();
        driver.findElement(updateContactInfoZipCode).sendKeys(zipcode);
    }
    public void inputUpdateContactInfoPhone(String phone){
        driver.findElement(updateContactInfoPhone).clear();
        driver.findElement(updateContactInfoPhone).sendKeys(phone);
    }

    public void clickUpdateProfileButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(updateProfileButton)).click();
//        driver.findElement(updateProfileButton).click();
    }

    //=======VERIFICATION METHODS=======
    public boolean isUpdateContactInfoSuccessfully(){
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(updateProfileSuccessMessage)
        ).isDisplayed();
    }
    // ✅ TAMBAHKAN METHOD INI — ambil teks pesan sukses
    public String getUpdateSuccessMessage(){
        return driver.findElement(updateProfileSuccessMessage).getText();
    }

    // ✅ TAMBAHKAN METHOD INI — verifikasi data tersimpan setelah reload
    public String getFirstNameFieldValue(){
        driver.navigate().refresh();
        return driver.findElement(updateContactInfoFirstName).getAttribute("value");
    }

    public boolean isFirstNameErrorDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(updateContactInfoFirstNameError)
        ).isDisplayed();
    }

    public boolean isAddressErrorDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(updateContactInfoAddressError)
        ).isDisplayed();
    }

    public String getFirstNameErrorMessage(){
        return driver.findElement(updateContactInfoFirstNameError).getText();
    }

    public String getAddressErrorMessage(){
        return driver.findElement(updateContactInfoAddressError).getText();
    }
}
