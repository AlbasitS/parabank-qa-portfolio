package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    WebDriver driver;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    //=======LOCATORS=======
    By registerLinkPage = By.xpath("//a[normalize-space()='Register']");
    By registerFirstName = By.name("customer.firstName");
    By registerLastName = By.name("customer.lastName");
    By registerAddress = By.name("customer.address.street");
    By registerCity = By.name("customer.address.city");
    By registerState = By.name("customer.address.state");
    By registerZipCode = By.name("customer.address.zipCode");
    By registerPhone = By.name("customer.phoneNumber");
    By registerSsn = By.name("customer.ssn");

    By registerUserName = By.name("customer.username");
    By registerPassword = By.name("customer.password");
    By registerConfirmPassword = By.name("repeatedPassword");

    By registerButton = By.xpath("//input[@value='Register']");

    By successMessage = By.xpath("//p[contains(text(),'Your account was created successfully')]");

    //=======ACTION METHODS======
    public void clickRegisterLinkPage(){
        driver.findElement(registerLinkPage).click();
    }

    public void inputFirstName(String firstname){
        driver.findElement(registerFirstName).sendKeys(firstname);
    }
    public void inputLastName(String lastname){
        driver.findElement(registerLastName).sendKeys(lastname);
    }
    public void inputAddress(String address){
        driver.findElement(registerAddress).sendKeys(address);
    }
    public void inputCity(String city){
        driver.findElement(registerCity).sendKeys(city);
    }
    public void inputState(String state){
        driver.findElement(registerState).sendKeys(state);
    }
    public void inputZipCode(String zipcode){
        driver.findElement(registerZipCode).sendKeys(zipcode);
    }
    public void inputPhone(String phone){
        driver.findElement(registerPhone).sendKeys(phone);
    }
    public void inputSsn(String ssn){
        driver.findElement(registerSsn).sendKeys(ssn);
    }
    public void inputUserName(String username){
        driver.findElement(registerUserName).sendKeys(username);
    }
    public void inputPassword(String password){
        driver.findElement(registerPassword).sendKeys(password);
    }
    public void inputConfirmPassword(String confirmpassword){
        driver.findElement(registerConfirmPassword).sendKeys(confirmpassword);
    }

    public void clickRegisterButton(){
        driver.findElement(registerButton).click();
    }

    //=======VERIFICATION METHODS======
    public boolean isRegistrationSuccessDisplayed(){
        return driver.findElement(successMessage).isDisplayed();
    }
}
