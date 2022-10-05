package com.NopCommerce.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardObject {

	WebDriver driver;
	
	public DashboardObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver,this);
		
	}
	
	@FindBy(xpath="//h1[contains(text(),'Dashboard')]")
	public WebElement dashboardHeading;
}
