package com.flipcart.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipcart.utility.Helper;

public class SearchProductsPage {
	
	
WebDriver driver;
	
	public SearchProductsPage(WebDriver lDriver)
	{
		this.driver=lDriver;
		
	}
	
	@FindBy(name="q") WebElement SearchText;	
	@FindBy(xpath="//button[@type='submit']") WebElement SearchBtn;
	@FindBy(xpath="(//a[@target='_blank'])[1]") WebElement product;
	@FindBy(xpath="//button[@class='_2AkmmA _2Npkh4 _2MWPVK']") WebElement AddToCart;
	
	public void addProduct(String ProductName)
	{
		String parentwindow=driver.getWindowHandle();
		//Helper.enterDataByJS(driver, SearchText, "");
		//Helper.enterDataByJS(driver, SearchText, ProductName);
		SearchText.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		SearchText.sendKeys(Keys.BACK_SPACE);
		SearchText.sendKeys(ProductName);
		SearchBtn.click();
		product.click();
		Helper.switchChildWindow(driver,parentwindow );
		AddToCart.click();
		driver.close();
		driver.switchTo().window(parentwindow);
		
		
	}

}
