package com.psl.OpenCart.Tests;

import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestComponents {
	WebDriver driver;

	@BeforeTest // annotation
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://localhost/Opencart");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		System.out.println("Chrome opened Sucessfully");
	}

	@Test(priority = 1)
	public void verifyComponentsModuleInHomePage() {
		// Checking whether the components module is present in the Home page
		boolean flag = driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[3]/a")).isDisplayed();
		Assert.assertTrue(flag);
		System.out.println("components module is present in the Home page");
	}

	@Test(priority = 2)
	public void verifyComponentsIsClickable() throws InterruptedException {
		// Check whether the module is clickable or not
		driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[3]/a")).click();
		System.out.println("Clicked on the components module");
		// clicking on Show all components in drop-down list
		driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[3]/div/a")).click();
	}

	@Test(priority = 3)
	public void addingToCart() throws InterruptedException, IOException {
		verifyComponentsIsClickable();
		// Clicking on Monitors
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/ul/li[2]/a")).click();

		// Scrolling
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");

		// clicking on the list option
		driver.findElement(By.xpath("//*[@id=\"list-view\"]/i")).click();
		// Adding Apple Cinema 30" to Cart
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[2]/button[1]")).click();

		// Scrolling
		js.executeScript("window.scrollBy(0,700)");

		// Selecting the radio button
		driver.findElement(By.xpath("//*[@id=\"input-option218\"]/div[2]/label/input")).click();

		// Selecting the check-box
		driver.findElement(By.xpath("//*[@id=\"input-option223\"]/div[2]/label")).click();
		driver.findElement(By.xpath("//*[@id=\"input-option208\"]")).sendKeys("Good");
		driver.findElement(By.xpath("//*[@id=\"input-option217\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"input-option217\"]/option[5]")).click();
		driver.findElement(By.xpath("//*[@id=\"input-option209\"]")).sendKeys("Hello Everyone");

		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//*[@id=\"button-upload222\"]")).click();
		Thread.sleep(2000);

		// Using AutoIT to Upload the file
		Runtime.getRuntime().exec("C:\\Users\\tejal_borase\\Desktop\\Mini Project Phase 2\\Files\\FileUpload.exe");
		Thread.sleep(5000);

		// Accepting the Alert
		Alert alertOK = driver.switchTo().alert();
		alertOK.accept();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"button-cart\"]")).click();
		js.executeScript("window.scrollBy(0,-1500)");
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
