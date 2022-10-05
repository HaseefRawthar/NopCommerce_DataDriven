package com.NopCommerce.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.NopCommerce.baseclass.SetUp;

public class RegisterUserObject extends SetUp {

	WebDriver driver;
	
	public RegisterUserObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver,this);
		
	}
	
	@FindBy(xpath="//input[@id='gender-male']")
	public WebElement male;
	@FindBy(xpath="//input[@id='FirstName']")
	public WebElement firstName;
	@FindBy(xpath="//input[@id='LastName']")
	public WebElement lastName;
	@FindBy(xpath="//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[1]/option[23]")
	public WebElement day;
	@FindBy(xpath="//option[contains(text(),'June')]")
	public WebElement month;
	@FindBy(xpath="//option[contains(text(),'1998')]")
	public WebElement year;
	@FindBy(xpath="//input[@id='Email']")
	public WebElement email;
	@FindBy(xpath="//input[@id='Company']")
	public WebElement companyName;
	@FindBy(xpath="//input[@id='Password']")
	public WebElement password;
	@FindBy(xpath="//input[@id='ConfirmPassword']")
	public WebElement confirmPassword;
	@FindBy(xpath="//button[@id='register-button']")
	public WebElement registerButton;
	
	public void registration(String first, String last, String mail, String company, String pass)
	{
		try
		{
			waitForElementToLoad(registerButton);
			male.click();
			firstName.sendKeys(first);
			lastName.sendKeys(last);
			day.click();
			month.click();
			year.click();
			email.sendKeys(mail);
			companyName.sendKeys(company);
			password.sendKeys(pass);
			confirmPassword.sendKeys(pass);
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
	}
}
