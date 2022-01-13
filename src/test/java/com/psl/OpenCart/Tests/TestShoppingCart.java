package com.psl.OpenCart.Tests;

/**
 * @author segu_revathi
 *
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.psl.OpenCart.commons.LoggersExample;
import com.psl.OpenCart.pages.ShoppingCart;

public class TestShoppingCart {
	ShoppingCart sc1=new ShoppingCart();
	WebDriver driver;
	@Test(priority = 1)
	public void openBrowserTest()
	{
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost/opencartpro/");
	}

	@Test(priority = 2)
	public void loginTest()
	{
		try {
		File src =new File("C:\\Users\\segu_revathi\\Desktop\\MiniProject\\LoginData.xlsx");

		FileInputStream fileinput=new FileInputStream(src);
		Workbook wb=new XSSFWorkbook(fileinput);

		XSSFSheet sheet1=(XSSFSheet) wb.getSheetAt(0);
		String s1=sheet1.getRow(0).getCell(0).getStringCellValue();
		String s2=sheet1.getRow(0).getCell(1).getStringCellValue();
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		Thread.sleep(2000);

		WebElement elemnt= driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a"));
		Actions a=new Actions(driver);
		a.moveToElement(elemnt).click().perform();
		Thread.sleep(2000);

		driver.findElement(By.name("email")).sendKeys(s1);
		driver.findElement(By.name("password")).sendKeys(s2);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		}
		catch(IOException e){
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
//	@Test(priority = 3)
//	public void shoppingCartTotalPriceTest()
//	{
//		int sum=0;
//		//click on shopping cart
//		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[4]/a/span")).click();
//		List<WebElement> values=driver.findElements(By.cssSelector(".table.table-bordered td:nth-child(6)"));
//		for (int i = 0; i < values.size(); i++) {
//			values.get(i).getText();
//			System.out.println(Integer.parseInt(values.get(i).getText()));
//			sum+=Integer.parseInt(values.get(i).getText());
//		}
//		System.out.println("Total price we got: "+sum);
//	}
	
	@Test(priority = 3)
	public void shoppingCartUpdateTest()
	{
		//click on shopping cart
		//driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[4]/a/span")).click();
		WebElement countOfItems=driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr[1]/td[4]/div/input"));
		Actions a1=new Actions(driver);
		a1.moveToElement(countOfItems).click().perform();
		countOfItems.clear();
		LoggersExample.logger.info("Cleared existing count");
		countOfItems.sendKeys("10");
		LoggersExample.logger.info("Updated value of count 10 is given");
		WebElement update= driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr[1]/td[4]/div/span/button[1]"));
		update.click();
		LoggersExample.logger.info("Updated successfully");
		String subtotal = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr[1]/td[6]")).getText();
		System.out.println(subtotal);
		LoggersExample.logger.info("Print subtotal successfully");
		
	}
	
	
	
	@Test(groups= {"AddCoupon"})
	public void addCouponTest()
	{
		WebElement couponDropDown= driver.findElement(By.xpath("//*[@id=\"accordion\"]/div[1]/div[1]/h4/a"));
		couponDropDown.click();
		WebElement couponInput=driver.findElement(By.xpath("//*[@id=\"input-coupon\"]"));
		Actions a=new Actions(driver);
		a.moveToElement(couponInput).click().perform();
		couponInput.sendKeys("2222");
		driver.findElement(By.id("button-coupon")).click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2000)");
		
		
		String finalTotal = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/table/tbody/tr[3]/td[2]")).getText();
		String li = "";
		for(int j=0; j<finalTotal.length(); j++)
		{
	         if(Character.isDigit(finalTotal.charAt(j))) {
	            li+=finalTotal.charAt(j);
	         }
	         else if(finalTotal.charAt(j)=='.')
	         {
	        	 li+=finalTotal.charAt(j);
	         }
		}

		if((ShoppingCart.sum-((10*ShoppingCart.sum)/100))==Double.parseDouble(li))
		{
			System.out.println("Coupon applied and deducted 10%");
		}
		System.out.println("New total price is: "+Double.parseDouble(li));

	}
	
	@Test(priority = 4)
	public void closeBrowser()
	{
		driver.close();
		LoggersExample.logger.info("Chrome closed successfully!!!");
	}
	
	
}
