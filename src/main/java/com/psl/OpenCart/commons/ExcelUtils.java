package com.psl.OpenCart.commons;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtils {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelUtils(String excelPath , String sheetName) 
	{
		try
		{
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		}
		catch(Exception e)
		{
			LoggersExample.logger.info(e);
		}
		
	}
	
	public static String readFirstname() throws Exception
	{
		
		String Firstname = sheet.getRow(1).getCell(0).getStringCellValue();
		LoggersExample.logger.info(Firstname);
		return Firstname;
		
	}
	
	public static String readLastname() throws Exception
	{
		
		String Lastname = sheet.getRow(1).getCell(1).getStringCellValue();
		LoggersExample.logger.info(Lastname);
		return Lastname;
		
	}
	
	public static String readEmail() throws Exception
	{
		
		String Email = sheet.getRow(1).getCell(2).getStringCellValue();
		LoggersExample.logger.info(Email);
		return Email;
		
	}
	
	public static String readTelephone() throws Exception
	{
	DataFormatter formatter = new DataFormatter();
	String Telephone = formatter.formatCellValue(sheet.getRow(1).getCell(3));

	LoggersExample.logger.info(Telephone);
	return Telephone;
	}
	
	public static String readPass() throws Exception
	{
		
		String Pass = sheet.getRow(1).getCell(4).getStringCellValue();
		LoggersExample.logger.info(Pass);
		return Pass;
	}
	
	public static String readConfirmPass() throws Exception
	{
		
		String ConfirmPass = sheet.getRow(1).getCell(5).getStringCellValue();
		LoggersExample.logger.info(ConfirmPass);
		return ConfirmPass;
	}
	
	

}
