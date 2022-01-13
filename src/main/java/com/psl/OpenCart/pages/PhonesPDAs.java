package com.psl.OpenCart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PhonesPDAs {


public static void main(String[]args) throws InterruptedException{
	System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");



WebDriver w = new ChromeDriver();



//Thread.sleep(5000);



w.get("http://localhost/opencartpro/");



//Thread.sleep(2000);



w.manage().window().maximize();
Thread.sleep(2000);
JavascriptExecutor js=(JavascriptExecutor)w;

//Clicking on the Phones&PDAs module
w.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[6]/a")).click();
Thread.sleep(2000);



//clicking on Show all components in dropdown list
w.findElement(By.xpath("//*[@id=\"list-view\"]/i")).click();
Thread.sleep(2000);



//Scrolling
js.executeScript("window.scrollBy(0,500)");
Thread.sleep(2000);
w.findElement(By.xpath("/html/body")).click();
Thread.sleep(1000);



//adding to add card
w.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div[2]/div[2]/button[1]/span")).click();
Thread.sleep(2000);

WebElement successmsg=w.findElement(By.cssSelector(".alert.alert-success.alert-dismissible"));
System.out.println(successmsg.getText());
String expectedText="Success: You have added HTC Touch HD to your shopping cart!\n×";
if((successmsg.getText()).equals(expectedText))
{
	System.out.println("added to cart successfully");
}
w.close();
}
}
