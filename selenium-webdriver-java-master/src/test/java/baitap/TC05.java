package baitap;

import java.io.File;

import org.apache.commons.io.FileUtils;
//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import POM.RegisterPage;
import driver.driverFactory;

@org.testng.annotations.Test
public class TC05 {
    @Test
    public void tc05() {
        String firstname = "LEMUN";
        String middlename = "...";
        String lastname = "...";
        String email_address = "minhlevuu1642003@gmail.com";
        String password = "Lemon@1604";
        String confirmation = "Lemon@1604";

        // Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            // 1. Open target page
            driver.get("http://live.techpanda.org/");
            RegisterPage registerPage = new RegisterPage(driver);
            // Delay Web for Performance

            // 2. Click on my account link
            registerPage.clickMyAccountLink();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            // 3. Click Create an Account link and fill New User information excluding the
            // registered Email ID.
            registerPage.clickCreateAccountLink();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
            // 3a. fill New User information excluding the registered Email ID
            registerPage.enterFirstName(firstname);
            registerPage.enterMiddleName(middlename);
            registerPage.enterLastName(lastname);
            registerPage.enterEmail(email_address);
            registerPage.enterPassword(password);
            registerPage.enterConfirmPassword(confirmation);

            // 4. Click Register
            registerPage.clickRegister();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            // 5. Verify Registration is done. Expected account registration done.
            String vWelcome = ("WELCOME, " + firstname.toUpperCase() + " " + middlename.toUpperCase() + " "
                    + lastname.toUpperCase() + "!");
            String tWelcome = driver.findElement(By.xpath("//div[1]/p[1]")).getText();
            System.out.println(tWelcome);

            // Catch Error
            AssertJUnit Assert = null;
            try {
                Assert.assertEquals(vWelcome, tWelcome);
            } catch (Exception e) {
                e.printStackTrace();
            }

            // 6. Go To TV Menu
            driver.findElement(By.xpath("(//a[@class='level0 '])[2]")).click();

            // 7. Add product in your wish list - use product - LG LCD
            driver.findElement(By.xpath("//a[@class='link-wishlist']")).click();

            // 8. Click SHARE WISHLIST
            driver.findElement(By.xpath("//button[@class='button btn-share']")).click();

            // 9. In next page enter Email and a message and click SHARE WISHLIST
            WebElement typeEmail = driver.findElement(By.id("email_address"));
            typeEmail.clear();
            typeEmail.sendKeys("minhlev1642003@gmail.com");

            WebElement typeMess = driver.findElement(By.id("message"));
            typeMess.clear();
            typeMess.sendKeys("hi");

            // click SHARE WISHLIST
            driver.findElement(By.xpath("//button[@title='Share Wishlist']")).click();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            // 10.Check wishlist is shared. Expected wishlist shared successfully.
            WebElement messageWishlist = driver.findElement(By.xpath("//li[@class='success-msg']//li[1]"));
            String expectedMessageWishlist = "Your Wishlist has been shared.";

            try {
                Assert.assertEquals(expectedMessageWishlist, messageWishlist.getText());
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Take Screen shot
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String png = "C:\\Users\\Lemon\\Downloads\\selenium-webdriver-java-master\\selenium-webdriver-java-master\\src\\test\\java\\baitap\\TC05.png";
            FileUtils.copyFile(srcFile, new File(png));

        } catch (Exception e) {
            e.printStackTrace();
        }
        // Quit browser session
        driver.quit();
    }
}
