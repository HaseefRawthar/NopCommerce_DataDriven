package com.NopCommerece.testscripts;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.NopCommerce.baseclass.SetUp;
import com.NopCommerce.objectrepository.HomeObject;
import com.NopCommerce.objectrepository.LandingPageObject;
import com.NopCommerce.objectrepository.RegisterUserObject;
import com.NopCommerce.testdata.RegisterUserData;
import com.NopCommerce.testdata.TestDataImportUI;

public class RegisterUsers extends SetUp {

	private LandingPageObject landingpageObj;
	private RegisterUserObject registeruserObj;
	private HomeObject homeObj;
	private TestDataImportUI tdImport;
	private RegisterUserData regUserDataObj;
	String[] testData;
	
	@BeforeClass
	public void initialize()
	{
		try
		{
			initializeLog("UI");
			landingpageObj = new LandingPageObject(driver);
			registeruserObj = new RegisterUserObject(driver);
			homeObj = new HomeObject(driver);
			tdImport = new TestDataImportUI();
			regUserDataObj = new RegisterUserData();
			
			tdImport.readSheet("RegisterUser");
			
			String url = "https://demo.nopcommerce.com";
		    driver.get(url);
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
	}
	
	@Test
	public void registerUser()
	{
		try
		{
			eTest = eReports.createTest("Register User");
			eTest.assignCategory("Register User");
		    waitForElementToLoad(landingpageObj.register);
		    landingpageObj.register.click();
		    
		    regUserDataObj.generateFakeRegisterData();
	    	testData = regUserDataObj.registerUserData();
	    	registeruserObj.registration(testData[0], testData[1], testData[2], testData[3], testData[4]);
	    	registeruserObj.registerButton.click();
	    	
	    	expectedMsg = "Your registration completed";
	    	waitForElementToLoad(homeObj.regCompleteMsg);
	    	actualMsg = homeObj.regCompleteMsg.getText();
	    	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		Assert.assertEquals(actualMsg, expectedMsg);
	}
}
