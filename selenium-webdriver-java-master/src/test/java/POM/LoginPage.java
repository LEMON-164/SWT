package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    By myAccountLink = By.linkText("MY ACCOUNT");

    By enterEmailAddress = By.id("email");

    By enterPassword = By.id("pass");
    By loginButton= By.xpath("//button[@id='send2']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void myAccountLink(){
        driver.findElement(myAccountLink).click();
    }
    public void enterEmailAddress(String emailAddress){
        WebElement emailAddressElement = driver.findElement(enterEmailAddress);
        emailAddressElement.clear(); // clear the QTY before
        emailAddressElement.sendKeys(emailAddress);
    }
    public void enterPassword(String password){
        WebElement enterPasswordElement = driver.findElement(enterPassword);
        enterPasswordElement.clear(); // clear the QTY before
        enterPasswordElement.sendKeys(password);
    }
    public void loginButton(){
        driver.findElement(loginButton).click();
    }
}
