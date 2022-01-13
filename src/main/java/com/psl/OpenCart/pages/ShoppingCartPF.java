/**
 * 
 */
package com.psl.OpenCart.pages;

import java.util.List;

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
public class ShoppingCartPF {
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
	
	SeleniumImplementation selenium;
	Actions action;

	public ShoppingCartPF(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		selenium=new SeleniumImplementation();
	}
	
	public boolean validateUpdatefunc(WebDriver driver)
	{
		selenium.click(ShoppingCartTab);
		selenium.moveToElement(countOfItems, driver);
		selenium.clear(countOfItems);
		selenium.setText("10", countOfItems);
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
	public boolean validateFinalTotal(WebDriver driver)
	{
		selenium.click(ShoppingCartTab);
		return(selenium.finalPriceCheck(driver,itemTotals,finalTotal));
		
		
	}
	
	public boolean validateAddCoupon(WebDriver driver) throws InterruptedException
	{
		selenium.click(ShoppingCartTab);
		
		selenium.scroll("2000", driver);
		selenium.click(couponDropDown);
		selenium.moveToElement(couponInput, driver);
		selenium.setText("2222", couponInput);
		selenium.click(couponBtn);
		return selenium.addCouponCheck(driver); 
		
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
}
