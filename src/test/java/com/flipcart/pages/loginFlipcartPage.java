package com.flipcart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginFlipcartPage {
	WebDriver driver;
	
	public loginFlipcartPage(WebDriver lDriver)
	{
		this.driver=lDriver;
	}
	
	@FindBy(xpath="//a[text()='Login & Signup']") WebElement login_Signup;
	@FindBy(xpath="//input[@type='text'][contains(@class,'_2zrpKA')]") WebElement email;
	@FindBy(xpath="//input[@type='password']") WebElement pass;
	@FindBy(xpath="//input[@type='password']//following::button[@type='submit']") WebElement login_btn;
	
	public void loginToFlipcart(String username, String password)
	{
		List<WebElement> test = driver.findElements(By.xpath("//input[@type='text'][contains(@class,'_2zrpKA')]"));
		if(test.size()==0)
		{
			login_Signup.click();
		}
		//System.out.println("List size is ..."+test.size());
		email.sendKeys(username);
		pass.sendKeys(password);
		login_btn.click();
	}
	
}
