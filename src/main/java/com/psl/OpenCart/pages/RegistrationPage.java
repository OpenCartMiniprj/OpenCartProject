package com.psl.OpenCart.pages;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.psl.OpenCart.commons.*;

public class RegistrationPage {

	@FindBy(xpath = "//div[@id='top-links']/ul/li[2]/a")
	WebElement myAccount;

	@FindBy(linkText = "Register")
	WebElement clickRegister;

	@FindBy(id = "input-firstname")
	WebElement inputFname;

	@FindBy(id = "input-lastname")
	WebElement inputLname;

	@FindBy(id = "input-email")
	WebElement inputEmail;

	@FindBy(id = "input-telephone")
	WebElement inputTelephone;

	@FindBy(id = "input-password")
	WebElement inputPass;

	@FindBy(id = "input-confirm")
	WebElement inputConfirmpass;

	SeleniumImplementation page;

	public RegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		page = new SeleniumImplementation();
	}
	XSSFWorkbook workbook;
	XSSFSheet sheet;
//	String projectPath = System.getProperty("user.dir");
	ExcelUtils exe = new ExcelUtils("RegistrationData.xlsx", "sheet1");

	public void registerFunction(WebDriver driver) throws Exception {
		String fname = exe.readFirstname();
		String lname = exe.readLastname();
		String email = exe.readEmail();
		String tele = exe.readTelephone();
		String password = exe.readPass();
		String cnfrmpass = exe.readConfirmPass();
		page.click(myAccount);
		page.click(clickRegister);
		page.setText(fname, inputFname);
		page.setText(lname, inputLname);
		page.setText(email, inputEmail);
		page.setText(tele, inputTelephone);
		page.setText(password, inputPass);
		page.setText(cnfrmpass, inputConfirmpass);
	}
}
