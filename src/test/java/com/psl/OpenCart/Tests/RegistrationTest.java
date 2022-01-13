package com.psl.OpenCart.Tests;

import java.util.concurrent.TimeUnit;



import javax.annotation.Tainted;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class RegistrationTest
{
WebDriver driver;

@Test(priority = 1)
public void openBrowserTest()
{
System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
//Open Website
driver.get("http://localhost/opencartpro");
}

@Test(priority = 2)
public void openRegisterPage()
{
driver.findElement(By.xpath("//div[@id='top-links']/ul/li[2]/a")).click();
driver.findElement(By.linkText("Register")).click();

}


@Test(priority = 3)
public void firstnameTest()
{
driver.findElement(By.id("input-firstname")).sendKeys("Pramila");

}



@Test(priority = 4)
public void lastnameTest()
{
driver.findElement(By.id("input-lastname")).sendKeys("Dey");
}

@Test(priority = 5)
public void emailTest()
{
driver.findElement(By.id("input-email")).sendKeys("Pramila@gmail.com");
}

@Test(priority = 6)
public void telephoneTest()
{
driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
}

@Test(priority = 7)
public void passswordTest()
{
driver.findElement(By.id("input-password")).sendKeys("Pramila");
}

@Test(priority = 8)
public void confirmTest()
{
driver.findElement(By.id("input-confirm")).sendKeys("Pramila");
}

@Test(priority = 9)
public void selectNewsletterTest()
{
driver.findElement(By.xpath("(//input[@name='newsletter'])[2]")).click();
}

@Test(priority = 10)
public void agreeTest()
{
driver.findElement(By.name("agree")).click();
}
//
@Test(priority = 11)
public void continueTest()
{
driver.findElement(By.xpath("//input[@value='Continue']")).click();
}

@Test(priority = 12)
public void createdTest()
{
	String expected_title = "Your Account Has Been Created!";
	String actual_title = driver.getTitle();
	Assert.assertEquals(expected_title, actual_title);
}

@Test(priority = 13)
public void closeBrowserTest()
{
driver.close();
}

//@FindBy(xpath = "//div[@id='top-links']/ul/li[2]/a") WebElement myaccount;
//@FindBy(linkText = "Register") WebElement register;
//@FindBy(id = "input-firstname") WebElement firstname;
//@FindBy(id = "input-lastname") WebElement lastname;
//@FindBy(id = "input-email") WebElement email;
//@FindBy(id = "input-telephone") WebElement telephone;
//@FindBy(id = "input-password") WebElement password;
//@FindBy(id = "input-confirm") WebElement confirmpass;
//@FindBy(xpath = "(//input[@name='newsletter'])[2]") WebElement newsletter;
//@FindBy(name = "agree") WebElement agree;
//@FindBy(xpath = "//input[@value='Continue']") WebElement submit;






//@Test
//public void register_test() throws Exception
//{
//System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
//WebDriver driver=new ChromeDriver();
//driver.manage().window().maximize();
//
////Open Website
//driver.get("http://localhost/opencartpro");
//
////Open my account option
////div[@id='top-links']/ul/li[2]/a
//Thread.sleep(2000);
//driver.findElement(By.xpath("//div[@id='top-links']/ul/li[2]/a")).click();
//
////Open register module
//Thread.sleep(2000);
//driver.findElement(By.linkText("Register")).click();
//
////Fill the data
//driver.findElement(By.id("input-firstname")).sendKeys("Pramila");
//Thread.sleep(2000);
////Alert alert=driver.switchTo().alert();
////Thread.sleep(2000);
////alert.accept();
//
//driver.findElement(By.id("input-lastname")).sendKeys("Dey");
//Thread.sleep(2000);
//// Alert alert1=driver.switchTo().alert();
//// Thread.sleep(2000);
//// alert1.accept();
//
//driver.findElement(By.id("input-email")).sendKeys("Pramila@gmail.com");
//Thread.sleep(2000);
//// Alert alert2=driver.switchTo().alert();
//// Thread.sleep(2000);
//// alert2.accept();
//
//driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
//Thread.sleep(2000);
//// Alert alert3=driver.switchTo().alert();
//// Thread.sleep(2000);
//// alert3.accept();
//
//
//driver.findElement(By.id("input-password")).sendKeys("Pramila");
//Thread.sleep(2000);
//// Alert alert4=driver.switchTo().alert();
//// Thread.sleep(2000);
//// alert4.accept();
//
//driver.findElement(By.id("input-confirm")).sendKeys("Pramila");
//Thread.sleep(2000);
//// Alert alert5=driver.switchTo().alert();
//// Thread.sleep(2000);
//// alert5.accept();
//
//driver.findElement(By.xpath("(//input[@name='newsletter'])[2]")).click();
//Thread.sleep(2000);
//// Alert alert6=driver.switchTo().alert();
//// Thread.sleep(2000);
//// alert6.accept();
//
//driver.findElement(By.name("agree")).click();
//Thread.sleep(2000);
//
//driver.findElement(By.xpath("//input[@value='Continue']")).click();
//Thread.sleep(2000);
//
//String expected_title = "Your Account Has Been Created!";
//String actual_title = driver.getTitle();
//
//// if(expected_title.equals(actual_title))
//// {
//// System.out.println("Registration Successful");
//// }
//// else
//// {
//// System.out.println("Email already exist");
//// }
//
//Assert.assertEquals(expected_title, actual_title);
//
//driver.close();
//
//
//
//
//}




}