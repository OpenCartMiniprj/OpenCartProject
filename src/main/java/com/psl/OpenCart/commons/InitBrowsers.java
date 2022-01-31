package com.psl.OpenCart.commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class InitBrowsers {
	static WebDriver driver=null;
	public void Initialize_browser() {
	
	try
	{
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		driver= new ChromeDriver();
			
		driver.manage().window().maximize();
		driver.get("http://localhost/opencartpro/");
		LoggersExample.logger.info("Opened OpenCart Application successfully");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally {
		driver.close();
	}
	}
	
}
