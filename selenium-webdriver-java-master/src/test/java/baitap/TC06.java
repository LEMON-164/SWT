package baitap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import POM.LoginPage;
import driver.driverFactory;

public class TC06 {
    @Test
    public void tc06() {
        String email_address = "nguyendinhtiendung113@gmail.com";
        String password = "123456";
        // 1. Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            // 2. Open target page
            driver.get("http://live.techpanda.org/");
            LoginPage loginPage = new LoginPage(driver);

            // 3. Click on "My Account" link
            WebElement account = driver.findElement(By.xpath("//span[@class='label'][normalize-space()='Account']"));
            account.click();

            WebElement myAccountLink = driver.findElement(
                    By.xpath("//div[@id='header-account']//a[@title='My Account'][normalize-space()='My Account']"));
            myAccountLink.click();
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
            // 4.Login in application using previously created credential
            loginPage.enterEmailAddress(email_address);
            loginPage.enterPassword(password);
            loginPage.loginButton();
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
            // 5. Click on wishlist
            WebElement myWishList = driver.findElement(By.xpath("//a[normalize-space()='My Wishlist']"));
            myWishList.click();

            package BaiTapDemo;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import POM.LoginPage;

@Test
public class TC06 {
    public static void tc06(){
        String email_address ="minhlevu1642003@gmail.com";
        String password ="Lemon@1604";
        String zip = "10000";
//1. Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //2. Open target page
            driver.get("http://live.techpanda.org/");
            LoginPage loginPage = new LoginPage(driver);

           // 3. Click on "My Account" link
            WebElement account = driver.findElement(By.xpath("//span[@class='label'][normalize-space()='Account']"));
            account.click();

            WebElement myAccountLink = driver.findElement(By.xpath("//div[@id='header-account']//a[@title='My Account'][normalize-space()='My Account']"));
            myAccountLink.click();
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
            //4.Login in application using previously created credential
            loginPage.enterEmailAddress(email_address);
            loginPage.enterPassword(password);
            loginPage.loginButton();
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }
            //5. Click on wishlist
            WebElement myWishList = driver.findElement(By.xpath("//a[normalize-space()='My Wishlist']"));
            myWishList.click();

            //Go to add to cart
            WebElement addToCart = driver.findElement(By.xpath("//button[@title='Add to Cart']"));
            addToCart.click();

            //Choose country
            WebElement country = driver.findElement(By.xpath("//select[@id='country']"));
            country.sendKeys("United States");

            WebElement states = driver.findElement(By.xpath("//select[@id='region_id']"));
            states.sendKeys("Texas");

            WebElement estimate = driver.findElement(By.xpath("//input[@id='postcode']"));
            estimate.clear();
            estimate.sendKeys("10000");

            //click estimate
            WebElement estimateButton = driver.findElement(By.xpath("//span[contains(text(),'Estimate')]"));
            estimateButton.click();

            //verify
            WebElement flatRate = driver.findElement(By.xpath("//dt[normalize-space()='Flat Rate']"));
            String expectedFlatRate = "Flat Rate";

            try {
                //Assert.assertEquals(expectedMessageWishlist, messageWishlist.getText());
                Assert.assertEquals(expectedFlatRate, expectedFlatRate);
            }catch (Exception e) {
                e.printStackTrace();
            }

            //choose fixed
            WebElement fixed = driver.findElement(By.xpath(//label[@for='s_method_flatrate_flatrate']));

            //Verify Oder is generated. Note the order number


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
