package com.NopCommerce.api.testdata;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.NopCommerce.baseclass.SetUp;

public class TestDataImportAPI extends SetUp{

	//private static HSSFWorkbook workbook; //for .xls
	private static XSSFWorkbook workbook;  //for .xlsx file xssfwoorkbook is needed
	//private static HSSFSheet sheet;
	private static XSSFSheet sheet;
	private static  FileInputStream inputStream;
	private static FileOutputStream outputstream;
	static Cell cell;
	static Row row;
	String cellData;

	String path = projectFolder+"/Excel/APITestData.xlsx";

	public void readSheet(String sheetName)
	{
		try {
			log.info("Entered readExcel method");
			inputStream = new FileInputStream(path);
			workbook = new XSSFWorkbook(inputStream);
			sheet = workbook.getSheet(sheetName);
		} 
		catch (IOException e) {
			e.printStackTrace();
			log.info(e);
		}
	}



	public String getCellData(int rowNum, int colNum)
	{
		try {
			log.info("Entered getValue method");
			cellData = sheet.getRow(rowNum).getCell(colNum).toString();
		}
		catch(Exception e){
			cellData = "";
			log.info(e);
		}
		return cellData;

	}

	public void writeCell(int rowNum, int colNum, String text)
	{
		try {
			log.info("Entered writeCell method");
			outputstream=new FileOutputStream(path);
			if(sheet.getRow(rowNum) == null)
				row = sheet.createRow(rowNum);
			if(sheet.getRow(rowNum).getCell(colNum)==null){
				row=sheet.getRow(rowNum);
				cell=row.createCell(colNum);
			}
			else {
				cell=sheet.getRow(rowNum).getCell(colNum);
			}
			cell.setCellValue(text);
			workbook.write(outputstream);
			outputstream.close();
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Failed");
		}


	}
}
