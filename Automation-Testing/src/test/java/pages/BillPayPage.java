package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BillPayPage {
    WebDriver driver;

    public BillPayPage(WebDriver driver){
        this.driver = driver;
    }

    //=======LOCATORS=======
    By billPayLink = By.linkText("Bill Pay");
    By billPayeeNameField = By.name("payee.name");
    By billPayAddressField = By.name("payee.address.street");
    By billPayCityField = By.name("payee.address.city");
    By billPayStateField = By.name("payee.address.state");
    By billPayZipCodeField = By.name("payee.address.zipCode");
    By billPayPhoneField = By.name("payee.phoneNumber");

    By billPayAccountField = By.name("payee.accountNumber");
    By billPayVerifyAccountField = By.name("verifyAccount");

    By billPayAmountField = By.name("amount");

//    By billPayFromAccountDropDown = By.name("fromAccountId");
    By billPaySendPaymentButton = By.xpath("//input[@value='Send Payment']");

    By billPaySuccessMessage = By.xpath("//h1[normalize-space()='Bill Payment Complete']");

    //=======ACTION METHODS======
    public void clickBillPayLink(){
        driver.findElement(billPayLink).click();
    }
    public void inputBillPayeeName(String billpayeename){
        driver.findElement(billPayeeNameField).sendKeys(billpayeename);
    }
    public void inputBillPayAddress(String billpayaddress){
        driver.findElement(billPayAddressField).sendKeys(billpayaddress);
    }
    public void inputBillPayCity(String billpaycity){
        driver.findElement(billPayCityField).sendKeys(billpaycity);
    }
    public void inputBillPayState(String billpaystate){
        driver.findElement(billPayStateField).sendKeys(billpaystate);
    }
    public void inputBillPayZipCode(String billpayzipcode){
        driver.findElement(billPayZipCodeField).sendKeys(billpayzipcode);
    }
    public void inputBillPayPhone(String billpayphone){
        driver.findElement(billPayPhoneField).sendKeys(billpayphone);
    }

    public void inputBillPayAccount(String billpayaccount){
        driver.findElement(billPayAccountField).sendKeys(billpayaccount);
    }
    public void inputBillPayVerifyAccount(String billpayverifyaccount){
        driver.findElement(billPayVerifyAccountField).sendKeys(billpayverifyaccount);
    }

    public void inputBillPayAmount(String billpayamount){
        driver.findElement(billPayAmountField).sendKeys(billpayamount);
    }

//    public void selectFromAccountId(String fromaccountid){
//        Select select = new Select(driver.findElement(billPayFromAccountDropDown));
//        select.selectByVisibleText(fromaccountid);
//
//        System.out.println(
//                "Selected Account Id: " + select.getFirstSelectedOption().getText());
//    }

    public void clickSendPaymentButton(){
        driver.findElement(billPaySendPaymentButton).click();
    }

    //=======VERIFICATION METHODS======
    public boolean isBillPaySuccessfully(){
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(billPaySuccessMessage)
        ).isDisplayed();
    }
}
