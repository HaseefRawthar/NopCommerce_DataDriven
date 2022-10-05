package com.NopCommerce.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.NopCommerce.baseclass.SetUp;

public class AdminLoginObject extends SetUp{

	WebDriver driver;
	
	public AdminLoginObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver,this);
		
	}
	
	@FindBy(xpath="//input[@id='Email']")
	public WebElement email;
	@FindBy(xpath="//input[@id='Password']")
	public WebElement password;
	@FindBy(xpath="//button[contains(text(),'Log in')]")
	public WebElement loginButton;
	@FindBy(xpath="//body/div[6]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]")
	public WebElement invalidMsg;
	
	public void login(String mail, String passwrd)
	{
		try
		{
			waitForElementToLoad(email);
			email.clear();
			email.sendKeys(mail);
			password.clear();
			password.sendKeys(passwrd);
			loginButton.click();
		}
		catch(Exception e){
			e.printStackTrace();
			log.info(e);
		}
	}
}
