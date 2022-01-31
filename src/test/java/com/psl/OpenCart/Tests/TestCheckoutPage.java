package com.psl.OpenCart.Tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCheckoutPage {

	WebDriver d;

	@BeforeTest
	public void login() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		d = new ChromeDriver();
		d.get("http://localhost/opencartpro");
		d.manage().window().maximize();
		// My Account
		WebElement my_acc = d.findElement(By.linkText("My Account"));
		my_acc.click();
		Thread.sleep(2000);
		d.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();
		WebElement email = d.findElement(By.id("input-email"));
		email.sendKeys("tejal1553@gmail.com");

		// Password
		WebElement password = d.findElement(By.id("input-password"));
		password.sendKeys("tejal");
		Thread.sleep(2000);

		// Login
		WebElement login = d.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
		login.click();
		Thread.sleep(2000);
	}

	@Test
	public void checkout() throws InterruptedException {
		d.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[5]/a/span")).click();
		Thread.sleep(1000);

		d.findElement(By.xpath("//*[@id=\"button-payment-address\"]")).click();
		Thread.sleep(1000);

		d.findElement(By.id("button-shipping-address")).click();
		Thread.sleep(1000);

		d.findElement(By.id("button-shipping-method")).click();
		Thread.sleep(1000);

		d.findElement(By.name("agree")).click();
		Thread.sleep(1000);

		d.findElement(By.id("button-payment-method")).click();
		Thread.sleep(1000);

		d.findElement(By.id("button-confirm")).click();
		Thread.sleep(2000);

		try {
			WebDriverWait wait = new WebDriverWait(d, 5);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = d.switchTo().alert();
			Assert.assertTrue(alert.getText().contains("OK"));
			alert.accept();
		} catch (Exception e) {

			System.out.println("Exception: " + e);
		}
		Thread.sleep(2000);

		d.findElement(By.id("button-confirm")).click();
		Thread.sleep(2000);

		d.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
		Thread.sleep(1000);

		d.close();
	}
}
