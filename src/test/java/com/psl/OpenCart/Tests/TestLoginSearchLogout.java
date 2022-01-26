package com.psl.OpenCart.Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.psl.OpenCart.commons.LoggersExample;
import com.psl.OpenCart.pages.SearchPage;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLoginSearchLogout {
	static WebDriver driver;
	public static String browserName = "Chrome";
	private SearchPage loginpage;

	@BeforeTest(groups = { "Regression" })
	public void driverSetup() {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/opencartpro");
		LoggersExample.logger.info("Browser opened successfully!!!");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		loginpage = new SearchPage(driver);
	}

	@Test(priority = 1)
	public void LoginWithInvalidCred() throws IOException {

		loginpage.validateUpdatefunc(driver, 1);
	}

	@Test(priority = 2)
	public void LoginWithBlankField() throws IOException {
		loginpage.validateUpdatefunc(driver, 3);
	}

	@Test(priority = 3)
	public void LoginWithValidCred() throws IOException {
		loginpage.validateUpdatefunc(driver, 2);

	}

	@Test(priority = 4)
	public void searchFunction() {
		loginpage.SearchFunction(driver);

	}

	@Test(priority = 5)
	public void LogoutFunction() {
		loginpage.LogoutFnctionTest(driver);

	}

	@AfterTest
	public void close() {
		driver.close();
	}

}
