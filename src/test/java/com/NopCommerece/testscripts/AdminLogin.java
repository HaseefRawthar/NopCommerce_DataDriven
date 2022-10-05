package com.NopCommerece.testscripts;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.NopCommerce.baseclass.SetUp;
import com.NopCommerce.objectrepository.AdminLoginObject;
import com.NopCommerce.objectrepository.DashboardObject;
import com.NopCommerce.objectrepository.LandingPageObject;
import com.NopCommerce.testdata.LoginData;
import com.NopCommerce.testdata.TestDataImportUI;

public class AdminLogin extends SetUp {

	private LandingPageObject landingpageObj;
	private AdminLoginObject adminloginObj;
	private DashboardObject dashboardObj;
	private LoginData logindataObj;
	private TestDataImportUI tdImport;
	String[] testData;
	
	@BeforeClass
	public void initialize()
	{
		try
		{
			initializeLog("UI");
			landingpageObj = new LandingPageObject(driver);
			adminloginObj = new AdminLoginObject(driver);
			dashboardObj = new DashboardObject(driver);
			logindataObj = new LoginData();
			tdImport = new TestDataImportUI();
			
			tdImport.readSheet("Login");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	@Test(priority=1)
	public void invalidLogin()
	{
		log.info("Invalid login test");
		try
		{
			eTest = eReports.createTest("InValid Login");
			eTest.assignCategory("LogIn");
			expectedMsg = "Login was unsuccessful. Please correct the errors and try again.No customer account found";
			waitForElementToLoad(landingpageObj.adminArea);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,350)", "");
			//js.executeScript("arguments[0].click();", homeObj.adminArea);
			landingpageObj.adminArea.click();
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			
	    	testData = logindataObj.getInValidLoginData();
	    	adminloginObj.login(testData[0], testData[1]);
			waitForElementToLoad(adminloginObj.invalidMsg);
			actualMsg = adminloginObj.invalidMsg.getText().replace("\n", "");
			driver.close();
			driver.switchTo().window(tabs.get(0));
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(actualMsg);
		Assert.assertEquals(expectedMsg, actualMsg);
		log.info("Assertion passed");
	}
	
	@Test(priority=2)
	public void validLogin()
	{
		log.info("Invalid login test");
		try
		{
			eTest = eReports.createTest("Valid Login");
			eTest.assignCategory("LogIn");
			driver.navigate().refresh();
			driver.get(url);
			waitForElementToLoad(landingpageObj.adminArea);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			//js.executeScript("window.scrollBy(0,350)", "");
			js.executeScript("arguments[0].click();", landingpageObj.adminArea);
			//landingpageObj.adminArea.click();
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			
			testData = logindataObj.getValidLoginData();
	    	adminloginObj.login(testData[0], testData[1]);
	    	expectedMsg = "Dashboard";
	    	waitForElementToLoad(dashboardObj.dashboardHeading);
	    	actualMsg = dashboardObj.dashboardHeading.getText();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(actualMsg);
		Assert.assertEquals(expectedMsg, actualMsg);
		log.info("Assertion passed");
	}
}
