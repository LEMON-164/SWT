package baitap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import driver.driverFactory;

public class TC02 {
    @Test
    public void tc02() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            // 1. Open target page
            driver.get("http://live.techpanda.org/");

            // 2. Click on Mobile
            WebElement mobileMenu = driver.findElement(By.xpath("//a[normalize-space()='Mobile']"));
            mobileMenu.click();

            // 3.Read the cost of Sony Xperia mobile in the list page
            WebElement sonyXperiaCost = driver.findElement(By.xpath("//span[contains(text(),'$100.00')]"));
            String sonyXperiaPrice = sonyXperiaCost.getText();

            // Step 4: Click on Sony Xperia mobile
            WebElement sonyXperiaLink = driver.findElement(By.xpath("//a[@title='Sony Xperia']"));
            sonyXperiaLink.click();

            // Step 5: Read the Sony Xperia mobile from detail page.
            WebElement sonyXperiaCostDetailPrice = driver.findElement(By.xpath("//span[@class='price']"));
            String sonyXperiaPriceText = sonyXperiaCostDetailPrice.getText();

            // Step 6: Compare the product value in the list and detail pages
            Assert.assertEquals(sonyXperiaPrice, sonyXperiaPriceText,
                    "Product value in list and details page are not equal.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
