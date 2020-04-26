package com.flipcart.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.flipcart.utility.BrowserFactory;
import com.flipcart.utility.ConfigDataProvider;
import com.flipcart.utility.ExcelDataProvider;
import com.flipcart.utility.Helper;

public class BaseClass {
	public static WebDriver driver;
	public static ExcelDataProvider excel;
	public static ConfigDataProvider config;
	public static ExtentReports reports;
	public static ExtentTest logger;
	public static ExtentHtmlReporter extent;
	
	@BeforeSuite
	public void setupSuite()
	{
		excel=new ExcelDataProvider();
		config=new ConfigDataProvider();
		//driver=BrowserFactory.startApplication(driver,config.getBrowser(),config.getURL() );
		extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/"+"Flipcart.html"));
		reports=new ExtentReports();
		reports.attachReporter(extent);
		driver=BrowserFactory.startApplication(driver,config.getBrowser(),config.getURL() );
		
	}
	
	@BeforeClass
	public void setup()
	{
	
		//driver=BrowserFactory.startApplication(driver,config.getBrowser(),config.getURL() );
		
	}
	
	@AfterSuite
	public void teardown()
	{
		//BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void teardownMethods(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			Helper.captureScreenShot(driver, result.getName());
			try {
				logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver, result.getName())).build());
			} catch (IOException e) {
				
				e.printStackTrace();
				
				
			}
			
		}
		reports.flush();
	}
	
}
