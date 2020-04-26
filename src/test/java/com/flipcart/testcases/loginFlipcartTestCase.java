package com.flipcart.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.flipcart.pages.BaseClass;
import com.flipcart.pages.loginFlipcartPage;
import com.flipcart.utility.BrowserFactory;
import com.flipcart.utility.ExcelDataProvider;
import com.flipcart.utility.Helper;

public class loginFlipcartTestCase extends BaseClass{
	
	
	
	@Test(priority=3)
	public void loginFlipCart()
	{
		logger=reports.createTest("Login to Flipcart");
		loginFlipcartPage LoginFlipcartPage=PageFactory.initElements(driver, loginFlipcartPage.class);
		logger.info("Starting Application");
		LoginFlipcartPage.loginToFlipcart(excel.getStringData(0, 0, 0), excel.getStringData(0, 0, 1));
		logger.pass("Login done successfully");
		
	}
	
	@Test(priority=4)
	public void test2()
	{
		
		System.out.println("Dummy method test2 running");
	}

}
