package com.flipcart.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.flipcart.pages.BaseClass;
import com.flipcart.pages.SearchProductsPage;

public class SearchProductsTestCase extends BaseClass{
	
	@Test(dataProvider="ProductsName", priority=5)
	public void addToCart(String Product_Name)
	{
		logger=reports.createTest("Searching Products");
		logger.info("Searching Products");
		SearchProductsPage searchproductpage=PageFactory.initElements(driver, SearchProductsPage.class);
		driver.navigate().refresh();
		searchproductpage.addProduct(Product_Name);
		logger.pass("Product added successfully");
		
	}
	
	@DataProvider(name="ProductsName")
	public Object[] productList()
	{
		int r=excel.getRowCount("SearchProducts");
		System.out.println("total products added is "+ r);
		Object[] data=new Object[r+1];
		for(int i=0;i<=r;i++)
		{
			data[i]=excel.getStringData(1, i, 0);
			System.out.println(data[i].toString());
		}
		return data;
	}
	

}
