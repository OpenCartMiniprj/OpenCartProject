/**
 * 
 */
package com.psl.OpenCart.commons;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.psl.OpenCart.commons.LoggersExample;
/**
 * @author segu_revathi
 *
 */
public class SeleniumImplementation {
	double sum;
	String li;
	Actions action;
	public void moveToElement(WebElement element,WebDriver driver)
	{
		action =new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	public void moveToElementClick(WebElement element,WebDriver driver)
	{
		action =new Actions(driver);
		action.moveToElement(element).click().perform();
	}
	
	public void click(WebElement element)
	{
		element.click();
	}
	
	public void clear(WebElement element)
	{
		element.clear();
	}
	
	public void setText(String text, WebElement element)
	{
		element.sendKeys(text);
	}
	
	public static void selectByIndex(WebElement sort, int num)
	{
		Select s=new Select(sort);
		s.selectByIndex(num);
	}
	
	public void selectByVisibleText(WebElement selectOption, String text)
	{
		Select s=new Select(selectOption);
		s.selectByVisibleText(text);
	}
	
	public void scroll(String string,WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String cmd = "window.scrollBy(0,"+string+")";
		js.executeScript(cmd);
	}
	
	public boolean validateTExt(WebElement element, WebDriver driver, String expectedText)
	{
		String observedText=element.getText();
		if(observedText.equals(expectedText))
		{
			return true;
		}
		return false;
	}
	
	

	public boolean checkCurrency(WebElement symbol, WebDriver driver, String string) {
		if((symbol.getText()).equals(string))
		{
			LoggersExample.logger.info("Converted to"+string+"currency successfully");
			return true;
		}
		return false;
	}
	
	
	//ramya
	
	public void validateTExt1(WebElement element, WebDriver driver, String expectedText) {
		String successMsg = "Your enquiry has been successfully sent to the store owner!";
		String observedMsg = driver.findElement(By.xpath("//*[@id=\"content\"]/p")).getText();
		if (successMsg.equalsIgnoreCase(observedMsg)) {
			LoggersExample.logger.info(" successfully submitted");
		} else {
			LoggersExample.logger.info("E-Mail Address does not appear to be valid!");
		}
	}

	public void InvalidateTExt(WebElement element, WebDriver driver, String expectedText) {
		String successMsg = "E-Mail Address does not appear to be valid!";
		String observedMsg = driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset/div[2]/div/div")).getText();
		if (successMsg.equalsIgnoreCase(observedMsg)) {
			LoggersExample.logger.info(" enter correct email");
		} else {
			LoggersExample.logger.info("E-Mail Address does not appear to be valid!");
		}
	}

	public void validateTExtInEditAccountInfo(WebElement element, WebDriver driver, String expectedText) {
		String successMsg = " Success: Your account has been successfully updated.";
		String observedMsg = driver.findElement(By.xpath("//*[@id=\"account-account\"]/div[1]")).getText();
		if (successMsg.equalsIgnoreCase(observedMsg)) {
			LoggersExample.logger.info("Personal info is updated succesfully");
		} else {
			LoggersExample.logger.info("E-Mail Address does not appear to be valid!");
		}
	}

	public void InvalidateTExtInEditAccountInfo(WebElement element, WebDriver driver, String expectedText) {
		String successMsg = " E-Mail Address does not appear to be valid!.";
		String observedMsg = driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset/div[3]/div/div")).getText();
		if (successMsg.equalsIgnoreCase(observedMsg)) {
			LoggersExample.logger.info("Personal info is not updated. enter corect email");
		} else {
			LoggersExample.logger.info("E-Mail Address does not appear to be valid!");
		}
	}
}
