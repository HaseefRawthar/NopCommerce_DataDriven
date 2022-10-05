package com.NopCommerce.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.NopCommerce.baseclass.SetUp;

public class HomeObject extends SetUp {


	WebDriver driver;
	
	public HomeObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver,this);
		
	}
	
	@FindBy(xpath="//div[contains(text(),'Your registration completed')]")
	public WebElement regCompleteMsg;
}
