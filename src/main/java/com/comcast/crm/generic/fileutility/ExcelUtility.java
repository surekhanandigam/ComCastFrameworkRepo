package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelUtility {
   public String getDataFromExcel(String sheetname,int rownum,int cellnum) throws Throwable
   {
	   FileInputStream fis=new FileInputStream("./testdata/TestScriptData.xlsx");
	   Workbook wb=WorkbookFactory.create(fis);
	   String data=wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
	   wb.close();
	   return data;
   }
   
   public int getRowcount(String sheetname) throws Throwable
   {
	   FileInputStream fis=new FileInputStream("./testdata/TestScriptData.xlsx");
	   Workbook wb=WorkbookFactory.create(fis);
	   int rowcount=wb.getSheet(sheetname).getLastRowNum();
	   wb.close();
	   return rowcount;
   }
   
   public void setDataIntoExcel(String sheetname,int rownum,int cellnum, String data) throws Throwable
   {
	   FileInputStream fis=new FileInputStream("./testdata/TestScriptData.xlsx");
	   Workbook wb=WorkbookFactory.create(fis);
	   wb.getSheet(sheetname).getRow(rownum).createCell(cellnum);
	   //Write Object of the Physical File
	   FileOutputStream fos=new FileOutputStream("./testdata/TestScriptData.xlsx");
	   wb.write(fos);
	   wb.close();
   }
}
