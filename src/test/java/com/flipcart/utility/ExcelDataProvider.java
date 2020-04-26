package com.flipcart.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelDataProvider {
	HSSFWorkbook wb;
	
	public ExcelDataProvider()
	{
		File src=new File("./TestData/Flipcart.xls");
		try {
			FileInputStream fis=new FileInputStream(src);
			wb=new HSSFWorkbook(fis);
		
		} catch (Exception e) {
			System.out.println("Unbale to read the data..."+e.getMessage());
		}
	}
	
	public String getStringData(String SheetName, int row, int colnum)
	{
		return wb.getSheet("SheetName").getRow(row).getCell(colnum).getStringCellValue();
	}
	
	public double getNumericData(String SheetName, int row, int colnum)
	{
		return wb.getSheet("SheetName").getRow(row).getCell(colnum).getNumericCellValue();
	}
	
	public String getStringData(int SheetIndex, int row, int colnum)
	{
		return wb.getSheetAt(SheetIndex).getRow(row).getCell(colnum).getStringCellValue();
	}
	
	public double getNumericData(int SheetIndex, int row, int colnum)
	{
		return wb.getSheetAt(SheetIndex).getRow(row).getCell(colnum).getNumericCellValue();
	}
	
	public int getRowCount(int SheetIndex)
	{
		return wb.getSheetAt(SheetIndex).getLastRowNum();
	}
	
	public int getRowCount(String SheetName)
	{
		return wb.getSheet(SheetName).getLastRowNum();
	
	}

}
