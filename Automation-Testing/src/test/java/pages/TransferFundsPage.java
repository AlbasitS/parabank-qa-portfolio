package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TransferFundsPage {
    WebDriver driver;

    public TransferFundsPage(WebDriver driver){
        this.driver = driver;
    }

    //=======LOCATORS=======
    By transferFundsLink = By.linkText("Transfer Funds");
    By amountField = By.id("amount");
    By transferButton = By.xpath("//input[@value='Transfer']");
    By transferCompleteText = By.xpath("//h1[normalize-space()='Transfer Complete!']");


    //=======ACTION METHODS======
    public void clickTransferFunds(){
        driver.findElement(transferFundsLink).click();
    }
    public void enterAmountField(String amount) {driver.findElement(amountField).sendKeys(amount); }
    public void clickTransferButton(){
        driver.findElement(transferButton).click();
    }

    //=======VERIFICATION METHODS======
    public boolean isTransferSuccessDisplayed() {
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        transferCompleteText
                )
        ).isDisplayed();
    }
}
