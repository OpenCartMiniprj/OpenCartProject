/**
 * 
 */
package com.psl.OpenCart.Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.psl.OpenCart.commons.LoggersExample;
import com.psl.OpenCart.pages.ContactUsPage;
import com.psl.OpenCart.pages.CurrencyPage;
import com.psl.OpenCart.pages.EditAccountInfoPage;
import com.psl.OpenCart.pages.LoginPage;
import com.psl.OpenCart.pages.SearchPage;
import com.psl.OpenCart.pages.PhonesAndPDAsPage;
import com.psl.OpenCart.pages.ShoppingCartPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ExcelUtils.screenshot;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author segu_revathi
 *
 */
public class TestModules extends screenshot{
	public static String browserName = "Chrome";
	WebDriver driver;
	ShoppingCartPage scPage;
	CurrencyPage cur;
	ContactUsPage cuPage;
	private LoginPage loginPg;
	private EditAccountInfoPage eaiPage;
	private SearchPage loginpage;
	private PhonesAndPDAsPage pad1;
	
	static ExtentTest test;
	static ExtentReports report;
	
	@BeforeClass
	public static void startTest()
	{
		report = new ExtentReports(System.getProperty("user.dir")+"\\final_ExtentReportResults.html");
		test = report.startTest("Opencart_Modules");
	}
	
	@BeforeTest
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		if (browserName.contains("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.contains("EDGE")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.get("http://localhost/opencartpro");
		LoggersExample.logger.info("Browser opened successfully!!!");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		scPage=new ShoppingCartPage(driver);
		cur=new CurrencyPage(driver);
		loginPg=new LoginPage(driver);
		cuPage=new ContactUsPage(driver);
		eaiPage=new EditAccountInfoPage(driver);
		loginpage = new SearchPage(driver);
		pad1=new PhonesAndPDAsPage(driver);
	}
	
	
	
	@Test (priority=1)
	public void validateContactformValid() throws IOException, InterruptedException
	{
		cuPage.validContactform(driver);
		LoggersExample.logger.info("Tested contact form with valid data");
		test.log(LogStatus.PASS, "Tested contact form with valid data");
	}
	
	@Test (priority=2)
	public void validateContactformInvalid() throws IOException, InterruptedException
	{
		cuPage.InvalidContactform(driver);
		LoggersExample.logger.info("Tested contact form with Invalid data");
		test.log(LogStatus.FAIL, "Tested contact form with Invalid data");
		takeScreenshot(driver);
	}
	
	@Test(priority=3)
	public void validateLoginInvalidCred()
	{
		loginPg.validateLoginfunc(driver,1);
		LoggersExample.logger.info("Tested login page with Invalid data");
		test.log(LogStatus.FAIL, "Tested login page with Invalid data");
		takeScreenshot(driver);
	}
	
	@Test(priority=4)
	public void validateLoginBlankCred()
	{
		loginPg.validateLoginfunc(driver,3);
		LoggersExample.logger.info("Tested login page with Invalid data");
		test.log(LogStatus.FAIL, "Tested login page with Invalid data");
		takeScreenshot(driver);
	}

	
	@Test(priority=5)
	public void validateLoginValidCred()
	{
		loginPg.validateLoginfunc(driver,2);
		LoggersExample.logger.info("Tested login page with valid data");
		test.log(LogStatus.PASS, "Tested login page with valid data");
	}
	
	@Test(priority=6)
	public void validateCurrencyEurofunc()
	{
		Assert.assertTrue(cur.validateEuroCurrency(driver));
		LoggersExample.logger.info("Tested Euro currency functionality.");
		test.log(LogStatus.PASS, "Tested Euro currency functionality.");
	}
	
	@Test(priority=7)
	public void validateCurrencyPoundfunc()
	{
		Assert.assertTrue(cur.validatePoundCurrency(driver));
		LoggersExample.logger.info("Tested Pound currency functionality.");
		test.log(LogStatus.PASS, "Tested Pound currency functionality.");
	}
	
	@Test(priority=8)
	public void validateCurrencyUSDollarfunc()
	{
		Assert.assertTrue(cur.validateUSDollarCurrency(driver));
		LoggersExample.logger.info("Tested USDollar functionality.");
		test.log(LogStatus.PASS, "Tested USDollar functionality.");
	}
	
	@Test(priority = 9)
	public void searchFunction() {
		
		loginpage.SearchFunction(driver);
		LoggersExample.logger.info("Tested search functionality.");
		test.log(LogStatus.PASS, "Tested search functionality.");

	}
	
	@Test(priority=10)
	public void validatePhonesAndPDAsfunc() throws IOException, InterruptedException
	{
		pad1.validatePhoneAndPDAs(driver);
		LoggersExample.logger.info("Tested PhonesAndPDAs functionality.");
		test.log(LogStatus.PASS, "Tested PhonesAndPDAs functionality.");
	}
	
	
	
	@Test(priority=11)
	public void validatePhoneSelectfunc()
	{
		pad1.validatePhones(driver);
		LoggersExample.logger.info("Tested select phone functionality.");
		test.log(LogStatus.PASS, "Tested select phone functionality.");
	}
	
	@Test(priority=12)
	public void validateShoppingCartEmpty()
	{
		scPage.validateEmptyCartFunc(driver);
		LoggersExample.logger.info("Tested empty cart in cart functionality.");
		test.log(LogStatus.PASS, "Tested empty cart in cart functionality.");
		
	}
	
	@Test(priority=13)
	public void validateShoppingCartPFUpdateFunc()
	{
		Assert.assertTrue(scPage.validateUpdatefunc(driver));
		LoggersExample.logger.info("Tested Update items in cart functionality.");
		test.log(LogStatus.PASS, "Tested Update items in cart functionality.");
	}

	@Test(priority=14)
	public void validateShoppingCartRemoveFunc()
	{
		Assert.assertTrue(scPage.validateRemoveFunc(driver));
		LoggersExample.logger.info("Tested Remove item from cart functionality.");
		test.log(LogStatus.PASS, "Tested Remove item from cart functionality");
	}
	
	@Test (priority=15)
	public void validateEditAccInfoValid() throws IOException, InterruptedException
	{
		try {
		eaiPage.validEditAccount(driver);
		LoggersExample.logger.info("Tested edit account info functionality with valid credentials.");
		test.log(LogStatus.PASS, "Tested edit account info functionality with valid credentials.");
		}
		catch(Exception e)
		{
			LoggersExample.logger.info("exception caught");
			test.log(LogStatus.FAIL, "exception caught");
		}
	}
	
	@Test(priority = 16)
	public void LogoutFunction() {
		loginpage.LogoutFnctionTest(driver);
		LoggersExample.logger.info("Logged Out succesfully");
		test.log(LogStatus.PASS, "Logged Out succesfully");

	}
	
	@AfterTest
	public void closeBrowsers()
	{
		driver.close();
		LoggersExample.logger.info("Browser closed successfully!!!");
		test.log(LogStatus.PASS, "Browser closed successfully!!!");
	}
	
	
	@AfterClass
	public static void endTest() {
		report.endTest(test);
		report.flush();
	}
}
