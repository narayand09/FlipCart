package com.flipcart.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Helper {
	
	// ScreenShots, alerts, Frames, windows, Sync issue, JavaScript Executor
	
	
	
	public static String captureScreenShot(WebDriver driver, String MethodName)
	{
		String ScreenPath=System.getProperty("user.dir")+"/Screens/"+MethodName+"_"+getCurrentDateTime()+".png";
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(ScreenPath));
		} catch (IOException e) {
			System.out.println("Unable to copy file..."+e.getMessage());
		}
		return ScreenPath;
	}

	public static String getCurrentDateTime()
	{
		DateFormat customFormat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date date=new Date();
		return customFormat.format(date);
		
	}
	
	public static void switchChildWindow(WebDriver driver, String parentwindow)
	{
		Set<String> handles = driver.getWindowHandles();
		for(String handle:handles)
		{
			if(!handle.contentEquals(parentwindow))
				driver.switchTo().window(handle);
		}
	}
	
	public static void enterDataByJS(WebDriver driver, WebElement ele, String x)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='"+x+"';", ele);
	}
	
}
