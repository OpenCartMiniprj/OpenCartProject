package com.psl.OpenCart.Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.psl.OpenCart.commons.LoggersExample;
import com.psl.OpenCart.pages.PhonesAndPDAsPage;


/**
 * @author sindhuja_inturi
 *
 */
public class TestPhonesAndPDAs {
	 WebDriver driver;
	 PhonesAndPDAsPage pad1;
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/opencartpro");
		LoggersExample.logger.info("Browser opened successfully!!!");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		pad1=new PhonesAndPDAsPage(driver);
	}
	
	@Test
	public void validatePhonesAndPDAsfunc() throws IOException, InterruptedException
	{
		pad1.validatePhoneAndPDAs(driver);
		LoggersExample.logger.info("Tested PhonesAndPDAs functionality.");
	}
	
	@Test
	public void validateSelectPhonefunc()
	{
		pad1.validatePhones(driver);
		LoggersExample.logger.info("Tested select phone functionality.");
	}
	
	@AfterTest
	public void closeBrowsers()
	{
		driver.close();
		LoggersExample.logger.info("Browser closed successfully!!!");
	}
}

