/**
 * 
 */
package com.psl.OpenCart.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.psl.OpenCart.commons.LoggersExample;
import com.psl.OpenCart.pages.CurrencyFirst;

/**
 * @author segu_revathi
 *
 */
public class TestCurrency {
	CurrencyFirst cur=new CurrencyFirst();
	
	WebDriver driver;
	@BeforeTest
	public void openBrowserTest()
	{
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/opencartpro/");
		LoggersExample.logger.info("Chrome opened successfully!!!");
	}
	
	@Test(priority=1)     //(groups= {"Currency"})
	public void testEuroCurrency()
	{
		//cur.euroCurrency();
		driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div/button")).click();
		//checking Euro currency
		WebElement currencyEuro= driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div/ul/li[1]/button"));
		currencyEuro.click();
		LoggersExample.logger.info("Clicked on Euro drop-down link");
		
		String symbol=driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div/button/strong")).getText();
		symbol=driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div/button/strong")).getText();
		if(symbol.equals("€"))
		{
			LoggersExample.logger.info("Converted to Euro currency successfully");
		}
	}
	
	@Test(priority=2)
	public void testPoundCurrency()
	{
		//clicking currency dropdown
		WebElement currencyBtn = driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div/button"));
		currencyBtn.click();
				
		//checking Pound currency
		WebElement currencyPound= driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div/ul/li[2]/button"));
		currencyPound.click();
		LoggersExample.logger.info("Clicked on pound drop-down link");
		String symbol=driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div/button/strong")).getText();
		if(symbol.equals("£"))
		{
			LoggersExample.logger.info("Converted to pound currency successfully");
		}
	}
	
	@Test(priority=3)
	public void testDollarCurrency()
	{
		//checking US Dollar Currency
		driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div/button")).click();
		//checking Euro currency
		WebElement currencyDollar= driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div/ul/li[3]/button"));
		currencyDollar.click();
		LoggersExample.logger.info("Clicked on Dollar drop-down link");
		String symbol=driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div/button/strong")).getText();
		if(symbol.equals("$"))
		{
			LoggersExample.logger.info("Converted to US Dollar currency successfully");
		}
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		LoggersExample.logger.info("Chrome closed successfully!!!");
	}
}
