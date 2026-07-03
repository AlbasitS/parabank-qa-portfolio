package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RequestLoanPage
{
    WebDriver driver;

    public RequestLoanPage(WebDriver driver) { this.driver = driver; }

        //=======LOCATORS=======
        By requestLoanLink = By.linkText("Request Loan");
        By requestLoanAmountField = By.id("amount");
        By requestLoanDownPaymentField = By.id("downPayment");
        By requestLoadApplyNowButton = By.xpath("//input[@value='Apply Now']");
        By requestLoanResult = By.id("requestLoanResult");
        By requestLoadErrorMessage = By.id("requestLoanError");

        //=======ACTION METHODS======
        public void clickRequestLoanLink(){
            driver.findElement(requestLoanLink).click();
        }
        public void inputLoanAmount(String loanamount){
            driver.findElement(requestLoanAmountField).sendKeys(loanamount);
        }
        public void inputDownPayment(String downpayment){
            driver.findElement(requestLoanDownPaymentField).sendKeys(downpayment);
        }

        public void clickApplyNowButton(){
            driver.findElement(requestLoadApplyNowButton).click();
        }

        //=======VERIFICATION METHODS======
        public boolean isRequestLoanApprove(){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement result = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(requestLoanResult));
            return result.getText().contains("Approved");
        }

        public boolean isRequestLoanDenied(){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement result = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(requestLoanResult));
            return result.getText().contains("Denied");
        }

        public boolean isRequestLoanError(){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(requestLoadErrorMessage)
            ).isDisplayed();
        }
}
