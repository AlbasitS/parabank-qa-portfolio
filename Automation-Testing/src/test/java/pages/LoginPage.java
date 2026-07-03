package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //=======LOCATORS=======
    By usernameField = By.name("username");
    By passwordField = By.name("password");
    By loginButton = By.xpath("//input[@value='Log In']");
    By accountOverviewtext = By.xpath("//h1[contains(text(),'Accounts Overview')]");

    //=======ACTION METHODS======
    public void enterUserName(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password){

        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin(){

        driver.findElement(loginButton).click();
    }

    //=======VERIFICATION METHODS======
    public boolean isAccountOverviewDisplayed(){
        return driver.findElement(accountOverviewtext).isDisplayed();
    }
}
