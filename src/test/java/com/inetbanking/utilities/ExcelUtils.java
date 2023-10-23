package com.inetbanking.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils
{
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static int getRowCount(String excelfile,String excelsheet)throws IOException
	{
		fi=new FileInputStream(excelfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(excelsheet);
		int rowCount=ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowCount;
	}
	public static int getCellCount(String excelfile,String excelsheet,int rownum)throws IOException
	{
		fi=new FileInputStream(excelfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(excelsheet);
		row=ws.getRow(rownum);
		int cellCount=row.getLastCellNum();
		wb.close();
		fi.close();
		return cellCount;
	}
	public static String getCellData(String excelfile,String excelsheet,int rownum,int colnum)throws IOException
	{
		fi=new FileInputStream(excelfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(excelsheet);
		row=ws.getRow(rownum);
		cell=row.getCell(colnum);
		String data;
		try
		{
			DataFormatter formatter=new DataFormatter();
			String cellData=formatter.formatCellValue(cell);
			return cellData;
		}
		catch(Exception e)
		{
			data="";
		}
		wb.close();
		fi.close();
		return data;
	}
	public static void setCellData(String excelfile,String excelsheet,int rownum,int colnum,String data)throws IOException
	{
		fi=new FileInputStream(excelfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(excelsheet);
		row=ws.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(excelfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}
}