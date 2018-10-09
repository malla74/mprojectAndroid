package com.michaels.mobile.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestExcel {

	static String cellValue;

	public static XSSFRow getRow(String testCaseName) throws IOException {

		FileInputStream file = new FileInputStream(
				new File(System.getProperty("user.dir") + "\\resources\\MTestData.xlsx"));
		XSSFWorkbook wb = new XSSFWorkbook(file);

		XSSFSheet sheet = wb.getSheetAt(0);
		Iterator<Row> itr = sheet.iterator();

		while (itr.hasNext()) {
			XSSFRow row = (XSSFRow) itr.next();
			System.out.println(row.getCell(0).getStringCellValue().toString());
			if (row.getCell(0).getStringCellValue().toString().equalsIgnoreCase(testCaseName)) {
				return row;

			}

		}

		return null;

	}

	public static String getColumnValues(XSSFRow row) throws IOException {

		Iterator<Cell> itr = row.iterator();
		XSSFRow headerRow = row.getSheet().getRow(0);
		itr.next(); // to skip the first column values
		int count = 1; // to get the header values from second column
		while (itr.hasNext()) {
			XSSFCell cell = (XSSFCell) itr.next();
			String headervalue = headerRow.getCell(count++).toString();
			cellValue = cell.getStringCellValue().toString();
			if (headervalue.equalsIgnoreCase("test")) {
				return cellValue;

			}

		}

		return null;

	}

	public static void main(String[] args) throws IOException {
		
		System.out.println(getColumnValues(getRow("TC18")));
		
	}

}
