package com.psl.OpenCart.commons;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.psl.OpenCart.commons.LoggersExample;

import io.github.bonigarcia.wdm.WebDriverManager;
public class InitBrowsers {
	public void Initialize_browser(String browser,WebDriver driver) {
	try
	{
//		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
//		driver= new ChromeDriver();
//			
//		driver.manage().window().maximize();
//		// Navigate to the demoqa website
//		driver.get("http://localhost/opencartpro/");
//		Thread.sleep(5000);
//		LoggersExample.logger.info("Opened OpenCart Application successfully");
		
		
		//Check if parameter passed from TestNG is 'firefox'
		if(browser.equalsIgnoreCase("firefox")){
		//create firefox instance
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		
		}
		//Check if parameter passed as 'chrome'
		else if(browser.equalsIgnoreCase("chrome")){
		//set path to chromedriver.exe
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Edge")){
		//set path to Edge.exe
		//EdgeOptions options=new EdgeOptions();
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		//driver = new EdgeDriver();
		}
		else{
		//If no browser is passed throw exception
		throw new Exception("Incorrect Browser");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
