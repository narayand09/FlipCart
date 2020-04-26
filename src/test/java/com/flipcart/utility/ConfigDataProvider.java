package com.flipcart.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties prop;
	public ConfigDataProvider()
	{
		File src=new File("./Config/config.properties");
		
		
		try {
			FileInputStream fis=new FileInputStream(src);
			prop=new Properties();
			prop.load(fis);
		} catch (Exception e) {
			
			System.out.println("Not able to load config file..."+e.getMessage());
		}
	}

	public String getBrowser()
	{
		return prop.getProperty("Browser");
	}
	
	public String getURL()
	{
		return prop.getProperty("url");
	}
	
	public String getDataFromConfig(String ketToSearch)
	{
		return prop.getProperty(ketToSearch);
	}
}
