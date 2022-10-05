package com.NopCommerce.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.NopCommerce.baseclass.SetUp;

public class Utilities extends SetUp {

	String destination;
	File source,finalDestination;
	TakesScreenshot ts;
	
	public String getScreenshot(WebDriver driver, String screenshotName)
	{
		try {
		ts = (TakesScreenshot) driver;
		source = ts.getScreenshotAs(OutputType.FILE);
	    destination = System.getProperty("user.dir") + "/Reports/Screenshots/"+screenshotName+".png";
		finalDestination = new File(destination);
	    FileUtils.copyFile(source, finalDestination);
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destination;
	}
}
