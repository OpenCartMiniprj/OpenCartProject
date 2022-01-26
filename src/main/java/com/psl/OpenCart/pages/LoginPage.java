package com.psl.OpenCart.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.psl.OpenCart.commons.SeleniumImplementation;

public class LoginPage {
	@FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a")
	WebElement myaccount;
	@FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
	WebElement login;
	@FindBy(id = "input-email")
	WebElement email;
	@FindBy(id = "input-password")
	WebElement pass;
	@FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/form/input")
	WebElement submit;
	SeleniumImplementation page;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		page = new SeleniumImplementation();
	}

	public void validateLoginfunc(WebDriver driver,int r)

	{
		File src = new File("Opencart_ReadData.xlsx");

		FileInputStream fileinput;
		try {
			fileinput = new FileInputStream(src);
			Workbook wb = new XSSFWorkbook(fileinput);
			XSSFSheet sheet1 = (XSSFSheet) wb.getSheetAt(0);
			String username = sheet1.getRow(r).getCell(1).getStringCellValue();
			String pwd = sheet1.getRow(r).getCell(2).getStringCellValue();

			page.click(myaccount);
			page.click(login);
			page.setText(username, email);
			page.setText(pwd, pass);
			page.click(submit);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
