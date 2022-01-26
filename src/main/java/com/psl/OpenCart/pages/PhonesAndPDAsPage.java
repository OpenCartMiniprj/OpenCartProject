package com.psl.OpenCart.pages;

import java.io.IOException;

/**
    @author sindhuja_inturi
 * 
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.psl.OpenCart.commons.SeleniumImplementation;

public class PhonesAndPDAsPage {

	@FindBy(xpath = "//*[@id=\"account-account\"]/ul/li[1]/a")
	WebElement home;
	@FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[6]/a")
	WebElement PhonesAndPDAs;
	@FindBy(xpath = "//*[@id=\"list-view\"]/i")
	WebElement list;
	@FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[1]/div/div[1]/a/img")
	WebElement selectPhone;
	@FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[1]/div/div[2]/div[2]/button[1]")
	WebElement addToCart;

	@FindBy(xpath = "//*[@id=\"product-category\"]/div[1]")
	WebElement addToCartsuccessmsg;

	SeleniumImplementation selenium;
	Actions action;

	// constructor
	public PhonesAndPDAsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		selenium = new SeleniumImplementation();
	}

	public void validatePhoneAndPDAs(WebDriver driver) throws IOException, InterruptedException {
		selenium.click(PhonesAndPDAs);

	}

	public void validatePhones(WebDriver driver) {
		selenium.click(selectPhone);

	}

}
