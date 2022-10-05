package com.NopCommerce.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.NopCommerce.baseclass.SetUp;

public class LandingPageObject extends SetUp {

	WebDriver driver;
	
	public LandingPageObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver,this);
		
	}
	
	@FindBy(xpath="//span[contains(text(),'Admin area')]")
	public WebElement adminArea;
	
	@FindBy(xpath="//a[contains(text(),'Register')]")
	public WebElement register;
	
}
