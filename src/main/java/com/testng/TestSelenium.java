package com.testng;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestSelenium {

	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
//		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
//		driver = new ChromeDriver();
//		System.setProperty("webdriver.gecko.driver", "C:\\driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "https://192.168.60.171";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws Exception {
		driver.get(baseUrl + "/fe/ifast#/home");
		driver.findElement(By.linkText("登录")).click();
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("100_100");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("ifast123");
		driver.findElement(By.xpath("//input[@value='登录']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//section[@id='body-wrapper']/div[2]/div/div/div/div/div[2]/div[2]/button")).click();
		driver.findElement(By.xpath("//section[@id='body-wrapper']/div[2]/div/div/div/div/div[2]/div[1]/div/a/img")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("html/body/header/div/nav[2]/div/div[2]/ul/li[3]/a")).click();
		driver.findElement(By.linkText("购买基金")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='001387']")).click();
		driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
		driver.findElement(By.xpath("//section[@id='body-wrapper']/div[2]/div/div/div/div[2]/form/buy-fund-code-amount/span/div/label/input")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("ifast123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

//	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		 driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
	
	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	public String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}


}
