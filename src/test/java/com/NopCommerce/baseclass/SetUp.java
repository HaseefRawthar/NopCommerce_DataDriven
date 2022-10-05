package com.NopCommerce.baseclass;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.NopCommerce.utility.Utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;


public class SetUp {

	public static WebDriver driver;
	public static WebDriverWait wait30Sec;
	public static Logger log;
	public String logPath="";
	public static String projectFolder = System.getProperty("user.dir");
	public static String log4jConfPath =projectFolder+"/src/test/java/com/NopCommerece/resources/log4j.properties";
	public static Date date;
	public static SimpleDateFormat df;
	public static String currentDateTime;
	public static String[] actualArray, expectedArray;
	public static String expectedMsg, actualMsg;
	public String url;
	public static ExtentSparkReporter esReporter;
    public static ExtentReports eReports;
    public static ExtentTest eTest;
    public static Utilities utilsObj;
	
	@BeforeSuite
	public void start()
	{
		try {
		// System.setProperty("webdriver.chrome.driver", "src/main/java/chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			  ChromeOptions options = new ChromeOptions();
			  
			  options.addArguments("--no-sandbox"); options.addArguments("--headless");
			  options.addArguments("--disable-dev-shm-usage");
			  options.addArguments("--window-size=1920x1080"); driver = new
			  ChromeDriver(options);
			 
		 initializeLog("");
		 extentReport();
		 //driver = new ChromeDriver();
	     driver.manage().window().maximize();
		 url = "https://www.nopcommerce.com/en/demo";
		 driver.get(url);
	     
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
	    
	}
	
	@AfterSuite(alwaysRun=true)
	public void tearDown()
	{
		eReports.flush();
		driver.quit();
	}
	
	
	public void extentReport()
	{
		try {
		  log.info("Report status initiated");
		  String path = projectFolder+"/Reports/TestDemo_"+getCurrentDateTime()+".html";
          esReporter = new ExtentSparkReporter(path);
          esReporter.config().setDocumentTitle("Automation Report");
          esReporter.config().setReportName("TestDemo Report");
          esReporter.config().setTheme(Theme.STANDARD);
          eReports = new ExtentReports();
          eReports.attachReporter(esReporter);
          eReports.setSystemInfo("Project Name", "TestDemo");
          eReports.setSystemInfo("Platform", System.getProperty("os.name"));
          eReports.setSystemInfo("Environment", "QA");
          eReports.setSystemInfo("Browser","Google chrome");
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
	}
	
	@AfterMethod
	public void testReportResult(ITestResult result)
	{
		try {
			
			log.info("enter testReportResult method ");
			   if(result.getStatus() == ITestResult.SUCCESS) {
	                eTest .log(Status.PASS, "Test passed");
	            }
			   
			   else if(result.getStatus() == ITestResult.FAILURE) {
	                eTest .log(Status.FAIL, "Test failed");
	            }
			   
			   else if(result.getStatus() == ITestResult.SKIP) {
	                eTest.log(Status.SKIP, "Test skipped");
	            }
			   if(utilsObj != null) {
				   String screenshotPath = utilsObj.getScreenshot(driver, result.getName()+"_"+getCurrentDateTime());
	               eTest.addScreenCaptureFromPath(screenshotPath);
			   }
		}
		catch(Exception e) {
            e.printStackTrace();
            log.info(e);
        } 
		
	}
	
	public void closeBrowser()
	{
		try
		{
			driver.quit();
		}
		catch(Exception e) {
			e.printStackTrace();
			log.error(e);
		}
	}
	
	public static void initializeLog(String type)
	{
		try
		{
			log = Logger.getLogger(SetUp.class.getName());
			System.setProperty("logPath", projectFolder+"/Logs/LogFile_"+type+"_"+getCurrentDateTime());
			PropertyConfigurator.configure(log4jConfPath); 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getCurrentDateTime() {
	      
		try {
           
            df= new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
            date = new Date();
            System.setProperty("currentDateTime", df.format(new Date()));
        }catch(Exception e) {
            e.printStackTrace();
        }
        
		return currentDateTime = df.format(date);
    }
	
	public void waitForElementToLoad(WebElement element)
	{
		try {
		wait30Sec = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait30Sec.until(ExpectedConditions.visibilityOf(element));
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("waited for 30 seconds..");
		}
		
	}

}
