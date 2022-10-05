package com.NopCommerce.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.NopCommerce.baseclass.SetUp;

public class LoginObject extends SetUp {

	WebDriver driver;
	
	public LoginObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver,this);
		
	}
	
	@FindBy(xpath="LoginObject")
	public WebElement login;
}
