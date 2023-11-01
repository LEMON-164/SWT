package baitap;

import static org.openqa.selenium.OutputType.*;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import POM.CartPage;
import POM.CheckOutPage;
import POM.LoginPage;
import driver.driverFactory;

public class TC06 {
    @Test
    public static void testTC06() {

        String emailAddress = "minhlevu1642003@gmail.com";
        String password = "Lemon@1604";
        String firstname = "LEMON";
        String middlename = "...";
        String lastname = "...";
        String Company = "FPT";
        String Address = "dau do";
        String Address1 = "dau day";
        String City = "new mexico";
        String State = "nevada";
        String Zip = "10000";
        String Country = "American Samoa";
        String telephone = "123456789";
        String tax = "10";

        // init web driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {

            // Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");

            Thread.sleep(2000);

            // Click on my account link
            LoginPage loginPage = new LoginPage(driver);
            loginPage.clickMyAccountLink();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            Thread.sleep(2000);

            // Login in application using previously created credential
            loginPage.enterEmail(emailAddress);

            Thread.sleep(1000);

            loginPage.enterPassword(password);

            Thread.sleep(1000);

            // Click Login
            loginPage.clickLogin();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            Thread.sleep(2000);

            // Click on MY WISHLIST link
            driver.findElement(By.linkText("MY WISHLIST")).click();

            Thread.sleep(2000);

            // In next page, Click ADD TO CART link
            CartPage cartPage = new CartPage(driver);
            cartPage.clickAddToCart();

            // debug purpose only
            Thread.sleep(2000);

            // Enter general shipping country, state/province and zip for the shipping cost
            // estimate
            cartPage.chooseCountry();

            // debug purpose only
            Thread.sleep(1000);

            cartPage.chooseState();

            // debug purpose only
            Thread.sleep(1000);

            cartPage.zipEmail(Zip);

            // debug purpose only
            Thread.sleep(1000);

            // Click Estimate
            cartPage.clickEstimateLink();

            // Verify Shipping cost generated
            String flatRate = driver.findElement(By.xpath("//dt[normalize-space()='Flat Rate']")).getText();
            String valueFlatRate = driver.findElement(By.xpath("//label[@for='s_method_flatrate_flatrate']")).getText();
            System.out.println("Shipping cost generated: " + flatRate);
            System.out.println("Value: " + valueFlatRate);

            // Screenshot
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(FILE);
            String png = ("D:\\FPT\\Chuyên ngành 5\\SWT301\\SeleniumWebdriver\\SeleniumWebdriver\\" + "TC06"
                    + "_1.png");
            FileUtils.copyFile(scrFile, new File(png));

            // Select Shipping Cost, Update Total
            cartPage.clickFlatRate();

            // debug purpose only
            Thread.sleep(2000);

            cartPage.clickUpdateButton();

            // Verify shipping cost is added to total
            String subTotal = driver
                    .findElement(By
                            .xpath("//tbody//td[@class='a-right']//span[@class='price'][normalize-space()='$615.00']"))
                    .getText();
            String shippingCost = driver
                    .findElement(By.xpath("//td[@class='a-right']//span[@class='price'][normalize-space()='$5.00']"))
                    .getText();
            String grandTotal = driver.findElement(By.xpath("//span[normalize-space()='$620.00']")).getText();
            System.out.println("Sub Total: " + subTotal);
            System.out.println("Shipping cost" + shippingCost);
            System.out.println("Grand Total: " + grandTotal);

            // Screenshot
            scrFile = ((TakesScreenshot) driver).getScreenshotAs(FILE);
            png = ("D:\\FPT\\Chuyên ngành 5\\SWT301\\SeleniumWebdriver\\SeleniumWebdriver\\" + "TC06" + "_2.png");
            FileUtils.copyFile(scrFile, new File(png));

            // debug purpose only
            Thread.sleep(2000);

            // Click "Proceed to Checkout"
            cartPage.clickProceedToCheckOutButton();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            Thread.sleep(2000);

            // Enter Billing Information, and click Continue
            CheckOutPage checkoutPage = new CheckOutPage(driver);
            checkoutPage.selectAddressBilling(Address);

            Thread.sleep(1000);

            checkoutPage.enterFirstNameBilling(firstname);

            Thread.sleep(1000);

            checkoutPage.enterLastNameBilling(lastname);

            Thread.sleep(1000);

            checkoutPage.enterCompanyBilling(Company);

            Thread.sleep(1000);

            checkoutPage.enterAddress1Billing(Address1);

            Thread.sleep(1000);

            checkoutPage.enterCityBilling(City);

            Thread.sleep(1000);

            checkoutPage.selectStateBilling(State);

            Thread.sleep(1000);

            checkoutPage.enterZipBilling(Zip);

            Thread.sleep(1000);

            checkoutPage.selectCountryBilling(Country);

            Thread.sleep(1000);

            checkoutPage.enterTelephoneBilling(telephone);

            Thread.sleep(1000);

            // driver.findElement(By.cssSelector("button[onclick='billing.save()']")).click();

            checkoutPage.clickShipToDifferentAddress();

            Thread.sleep(1000);

            checkoutPage.clickContinueBillingButton();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            Thread.sleep(2000);

            // Enter Shipping Information, and click Continue
            checkoutPage.selectAddressShipping(Address);

            Thread.sleep(1000);

            checkoutPage.enterFirstNameShipping(firstname);

            Thread.sleep(1000);

            checkoutPage.enterLastNameShipping(lastname);

            Thread.sleep(1000);

            checkoutPage.enterCompanyShipping(Company);

            Thread.sleep(1000);

            checkoutPage.enterAddress1Shipping(Address1);

            Thread.sleep(1000);

            checkoutPage.enterCityShipping(City);

            Thread.sleep(1000);

            checkoutPage.selectStateShipping(State);

            Thread.sleep(1000);

            checkoutPage.enterZipShipping(Zip);

            Thread.sleep(1000);

            checkoutPage.selectCountryShipping(Country);

            Thread.sleep(1000);

            checkoutPage.enterTelephoneShipping(telephone);

            Thread.sleep(1000);

            checkoutPage.clickContinueShippingButton();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            Thread.sleep(2000);

            // In Shipping Method, Click Continue
            checkoutPage.clickContinueShippingMethodButton();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            Thread.sleep(2000);

            // In Payment Information select 'Check/Money Order' radio button. Click
            // Continue
            driver.findElement(By.xpath("//label[normalize-space()='Check / Money order']")).click();

            Thread.sleep(1000);

            checkoutPage.clickContinuePaymentButton();

            Thread.sleep(2000);

            // Click 'PLACE ORDER' button
            driver.findElement(By.xpath("//button[@title='Place Order']")).click();

            // switching to new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            // Verify Oder is generated. Note the order number
            String successOrder = driver
                    .findElement(By.xpath("//h1[normalize-space()='Your order has been received.']")).getText();
            if (successOrder.contains("YOUR ORDER HAS BEEN RECEIVED")) {
                System.out.println("ORDER SUCCESS");
                System.out.println(successOrder);

            } else {
                System.out.println("ORDER FAILED");
            }

            // Screenshot
            scrFile = ((TakesScreenshot) driver).getScreenshotAs(FILE);
            png = ("D:\\FPT\\Chuyên ngành 5\\SWT301\\SeleniumWebdriver\\SeleniumWebdriver\\" + "TC06" + "_3.png");
            FileUtils.copyFile(scrFile, new File(png));

            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Quit browser session
        driver.quit();

    }
}
