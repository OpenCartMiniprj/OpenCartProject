/**
 * 
 */
package com.psl.OpenCart.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.psl.OpenCart.commons.SeleniumImplementation;



/**
 * @author bandaru_ramya
 *
 */
public class EditAccountInfoPage {

	SeleniumImplementation selenium;
	WebDriver driver;
	
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/a")
	WebElement MyAccountTab;
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")
	WebElement AccountDetails;
	@FindBy(xpath="//*[@id=\"content\"]/ul[1]/li[1]/a")
	WebElement EditAccount;
	@FindBy(xpath="//*[@id=\"input-firstname\"]")
	WebElement FirstNameTextBox;
	@FindBy(xpath="//*[@id=\"input-lastname\"]")
	WebElement LastNameTextBox;
	@FindBy(xpath="//*[@id=\"input-email\"]")
	WebElement EmailTextBox;
	@FindBy(xpath="//*[@id=\"input-telephone\"]")
	WebElement TelephoneTextBox;
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div[2]/input")
	WebElement SubmitEditAccountInfoForm;
	@FindBy(xpath="//*[@id=\"account-account\"]/div[1]")
	WebElement displaymsg;
	
    //constructor
	public EditAccountInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		selenium=new SeleniumImplementation();
	}
	
	
	public void validEditAccount(WebDriver driver) throws IOException, InterruptedException
	{
		selenium.moveToElement(MyAccountTab, driver);
		selenium.click(MyAccountTab);
		selenium.moveToElement(AccountDetails, driver);
		selenium.click(AccountDetails);
		selenium.click(EditAccount);
		
		Properties p=new Properties();
		FileInputStream fis = null;
		try {
		fis = new FileInputStream("LoginDetails.properties");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		p.load(fis);
				
		selenium.moveToElement(FirstNameTextBox, driver);
		selenium.clear(FirstNameTextBox);
		selenium.setText(p.getProperty("FirstName"), FirstNameTextBox);
		selenium.moveToElement(LastNameTextBox, driver);
		selenium.clear(LastNameTextBox);
		selenium.setText(p.getProperty("LastName"), LastNameTextBox);
		selenium.moveToElement(EmailTextBox, driver);
		selenium.clear(EmailTextBox);
		selenium.setText(p.getProperty("E-Mail"), EmailTextBox);
		selenium.moveToElement(TelephoneTextBox, driver);
		selenium.clear(TelephoneTextBox);
		selenium.setText(p.getProperty("Telephone"), TelephoneTextBox);
		selenium.click(SubmitEditAccountInfoForm);
		selenium.validateTExtInEditAccountInfo(displaymsg, driver," Success: Your account has been successfully updated.");
	}
	
	
	public void InvalidEditAccount(WebDriver driver) throws IOException, InterruptedException
	{
		selenium.moveToElement(MyAccountTab, driver);
		selenium.click(MyAccountTab);
		selenium.moveToElement(AccountDetails, driver);
		selenium.click(AccountDetails);
		selenium.click(EditAccount);
		
		Properties p=new Properties();
		FileInputStream fis = null;
		try {
		fis = new FileInputStream("LoginDetails.properties");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		p.load(fis);
				
		selenium.moveToElement(FirstNameTextBox, driver);
		selenium.clear(FirstNameTextBox);
		selenium.setText(p.getProperty("FirstName1"), FirstNameTextBox);
		selenium.moveToElement(LastNameTextBox, driver);
		selenium.clear(LastNameTextBox);
		selenium.setText(p.getProperty("LastName1"), LastNameTextBox);
		selenium.moveToElement(EmailTextBox, driver);
		selenium.clear(EmailTextBox);
		selenium.setText(p.getProperty("E-Mail1"), EmailTextBox);
		selenium.moveToElement(TelephoneTextBox, driver);
		selenium.clear(TelephoneTextBox);
		selenium.setText(p.getProperty("Telephone"), TelephoneTextBox);
		selenium.click(SubmitEditAccountInfoForm);
		selenium.InvalidateTExtInEditAccountInfo(displaymsg, driver,"E-Mail Address does not appear to be valid!");
	}
	

}
