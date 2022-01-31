/**
 * 
 */
package com.psl.OpenCart.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.psl.OpenCart.commons.LoggersExample;
import com.psl.OpenCart.commons.SeleniumImplementation;

/**
 * @author segu_revathi
 *
 */
public class ShoppingCartPage {
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[4]/a/span")
	WebElement ShoppingCartTab;
	@FindBy(xpath="//*[@id=\"content\"]/form/div/table/tbody/tr[1]/td[4]/div/input")
	WebElement countOfItems;
	@FindBy(xpath="//*[@id=\"content\"]/form/div/table/tbody/tr[1]/td[4]/div/span/button[1]")
	WebElement updateBtn;
	@FindBy(xpath="//*[@id=\"checkout-cart\"]/div[1]")
	WebElement popupmsg;
	@FindBy(xpath="//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/span/button[2]")
	WebElement removeBtn;
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div/table/tbody/tr[2]/td[2]")
	WebElement finalPrice;
	@FindBy(css=".table.table-bordered td:nth-child(6)")
	List<WebElement> itemTotals;
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div/table/tbody/tr[2]/td[2]")
	WebElement finalTotal;
	@FindBy(xpath="//*[@id=\"accordion\"]/div[1]/div[1]/h4/a")
	WebElement couponDropDown;
	@FindBy(xpath="//*[@id=\"input-coupon\"]")
	WebElement couponInput;
	@FindBy(xpath="//*[@id=\"button-coupon\"]")
	WebElement couponBtn;
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div/table/tbody/tr[2]/td[1]/strong")
	WebElement couponMsg;
	@FindBy(xpath="//div[@id='content']/p")
	WebElement cartMsg;
	@FindBy(xpath="//*[@id=\"content\"]/p")
	WebElement emptyMsg;
	@FindBy(xpath="//*[@id=\"content\"]/div/div/a")
	WebElement continueBtn;
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[1]/div/div[3]/button[1]")
	WebElement addToCartBtn;
	
	SeleniumImplementation selenium;

	public ShoppingCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		selenium=new SeleniumImplementation();
	}
	
	public boolean validateUpdatefunc(WebDriver driver)
	{
		Properties p=new Properties();
		FileInputStream fis = null;
		try {
		fis = new FileInputStream("updateData.properties");
		p.load(fis);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		selenium.click(ShoppingCartTab);
		selenium.moveToElement(countOfItems, driver);
		selenium.clear(countOfItems);
		selenium.setText(p.getProperty(String.valueOf("updateValue")), countOfItems);
		LoggersExample.logger.info("Updated count of item in cart");
		selenium.click(updateBtn);
		return selenium.validateTExt(popupmsg, driver,"Success: You have modified your shopping cart!\n×");
	}
	
	public boolean validateRemoveFunc(WebDriver driver)
	{
		selenium.click(ShoppingCartTab);
		selenium.click(removeBtn);
		LoggersExample.logger.info("Clicked on remove button");
		return true;
		
	}
	
	
	
	
	public boolean validateEmptyShoppingCart(WebDriver driver)
	{
		String observedMsg=cartMsg.getText();
		if(observedMsg.equals("Your shopping cart is empty!"))
		{
			return true;
		}
		return false;
		
	}

	public boolean validateEmptyCartFunc(WebDriver driver) {
		// TODO Auto-generated method stub
		selenium.clear(ShoppingCartTab);
		if(selenium.validateTExt(emptyMsg, driver, "Your shopping cart is empty!"))
		{
			selenium.click(continueBtn);
			selenium.scroll("2000", driver);
			selenium.click(addToCartBtn);
			return true;
		}
		return false;
	}
	
	public void validateEmptyCart(WebDriver driver)
	{
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[4]/a")).click();
		String observedText= driver.findElement(By.xpath("//*[@id=\"content\"]/p")).getText();
		if(observedText.equals("Your shopping cart is empty!"))
		{
			LoggersExample.logger.info("Shopping cart is empty! Added product");
			driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,2000)");
			driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div[3]/button[1]")).click();
		}
	}
}
