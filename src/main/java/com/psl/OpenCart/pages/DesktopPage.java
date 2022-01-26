package com.psl.OpenCart.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.psl.OpenCart.commons.SeleniumImplementation;

public class DesktopPage {
	public static void main(String args[]) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);

		driver.get("http://localhost/opencartapp/");
		driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/div/a")).click();
		WebElement sort=driver.findElement(By.id("input-sort"));
		int num=3;
		SeleniumImplementation.selectByIndex( sort,  num);

		//show in list
		driver.findElement(By.id("list-view")).click();
		
		//select product
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div[1]/div/div[2]/div[1]/h4/a")).click();

		//add to wish list
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div[1]/button[1]")).click();

		//Add to cart
		Select s1 = new Select(driver.findElement(By.id("input-option226")));
		s1.selectByIndex(1);
		
		driver.findElement(By.id("button-cart")).click();

		driver.close();



	}
}



