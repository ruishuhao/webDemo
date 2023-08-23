package com.wallet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class createWallet {
    private static ChromeDriver driver;
    WebElement element;

    @BeforeClass
    public static void openBrowser() {
        ChromeOptions op = new ChromeOptions();
        op.addExtensions(new File("trustwallet.crx"));
        driver = new ChromeDriver(op);
        driver.get("chrome-extension://egjidjbpglichdcondbcbdnbeeppgdph/home.html#/onboarding");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void clickCreate() throws InterruptedException {

        System.out.println("Starting test " + new Object() {
        }.getClass().getEnclosingMethod().getName());
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div[1]")).click();
        Thread.sleep(5000);
        try {
            element = driver.findElement(By.id("field-2"));
        } catch (Exception e) {
        }
        Assert.assertNotNull(element);
        System.out.println("Ending test " + new Object() {
        }.getClass().getEnclosingMethod().getName());
    }
    @Test
    public void setWrongPassword() throws InterruptedException {

        System.out.println("Starting test " + new Object() {
        }.getClass().getEnclosingMethod().getName());
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("field-2")).sendKeys("1111");
        driver.findElement(By.id("field-3")).sendKeys("222");
        Thread.sleep(5000);
        try {
            element = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/form/div[2]/p"));
        } catch (Exception e) {
        }
        Assert.assertNotNull(element);
        System.out.println("Ending test " + new Object() {
        }.getClass().getEnclosingMethod().getName());
    }

    @Test
    public void setRightPassword() throws InterruptedException {

        System.out.println("Starting test " + new Object() {
        }.getClass().getEnclosingMethod().getName());
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("field-2")).sendKeys("1qaz@Wsx");
        driver.findElement(By.id("field-3")).sendKeys("1qaz@Wsx");
        driver.findElement(By.className("chakra-checkbox__control")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/form/div[4]/button[2]")).click();
        try {
            element = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div[4]/button[2]"));
        } catch (Exception e) {
        }
        Assert.assertNotNull(element);
        System.out.println("Ending test " + new Object() {
        }.getClass().getEnclosingMethod().getName());
    }

    @Test
    public void passwordTOU() throws InterruptedException {

        System.out.println("Starting test " + new Object() {
        }.getClass().getEnclosingMethod().getName());
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("field-2")).sendKeys("1qaz@Wsx");
        driver.findElement(By.id("field-3")).sendKeys("1qaz@Wsx");
        Thread.sleep(5000);
        Boolean able=Boolean.TRUE;
        try {
            element = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/form/div[4]/button[2]"));
            able = element.isEnabled();
        } catch (Exception e) {
        }
        Assert.assertEquals(Boolean.FALSE,able);
        System.out.println("Ending test " + new Object() {
        }.getClass().getEnclosingMethod().getName());
    }
    @Test
    public void showSecret() throws InterruptedException {

        System.out.println("Starting test " + new Object() {
        }.getClass().getEnclosingMethod().getName());
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("field-2")).sendKeys("1qaz@Wsx");
        driver.findElement(By.id("field-3")).sendKeys("1qaz@Wsx");
        driver.findElement(By.className("chakra-checkbox__control")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/form/div[4]/button[2]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div[4]/button[2]")).click();
        Thread.sleep(5000);
        try {
            element = driver.findElement(By.id("canvas"));
        } catch (Exception e) {
        }
        Assert.assertNotNull(element);
        System.out.println("Ending test " + new Object() {
        }.getClass().getEnclosingMethod().getName());
    }

    @AfterClass
    public static void closeBrowser() {
        driver.quit();
    }
}
