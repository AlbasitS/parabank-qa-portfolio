package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OpenNewAccountPage {

    WebDriver driver;

    public OpenNewAccountPage(WebDriver driver){
        this.driver = driver;
    }

    //=======LOCATORS=======
    By openNewAccountLink = By.linkText("Open New Account");
    By accountTypeDropDown = By.id("type");
    By openNewAccountButton = By.xpath("//input[@value='Open New Account']");
    By successMessage = By.xpath("//h1[normalize-space()='Account Opened!']");

    //=======ACTION METHODS=======
    public void clickOpenNewAccount(){
        driver.findElement(openNewAccountLink).click();
    }

    //Dropdown Handling
    public void selectAccountType(String accountType){
        Select select = new Select(driver.findElement(accountTypeDropDown));
        select.selectByVisibleText(accountType);

        System.out.println(
                "Selected Account Type: " + select.getFirstSelectedOption().getText()
        );
    }

    public void clickOpenNewAccountButton(){
        driver.findElement(openNewAccountButton).click();
    }

    //=======VERIFICATION METHODS======
    public boolean isAccountCreatedSuccessfully(){
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        successMessage
                )
        ).isDisplayed();
    }
}
