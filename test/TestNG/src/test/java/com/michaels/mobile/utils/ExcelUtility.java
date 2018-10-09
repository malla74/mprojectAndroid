package com.michaels.mobile.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static XSSFRow findRow(String testCaseName) throws IOException {

		FileInputStream file = new FileInputStream(
				new File(System.getProperty("user.dir") + "\\resources\\MTestData.xlsx"));

		// Get the workbook instance for XLSX file
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowItr = sheet.iterator();
		try {
			while (rowItr.hasNext()) {
				XSSFRow row = (XSSFRow) rowItr.next();

				if (testCaseName.equalsIgnoreCase(row.getCell(0).toString())) {
					return row;
				}
			}

		} catch (Exception e) {
			System.out.println("Cannot Read Row, Please Check the Testdata file and enter correct Information ");
		}

		// If no such row found need to handle NullPointerException for that
		return null;
	}

	public static String getAllColumnFromRow(XSSFRow RowObject, String headerName) {
		Iterator<Cell> itr = RowObject.iterator();
		XSSFRow headerRow = RowObject.getSheet().getRow(0);
		String cellValue = "";
		int headerCellCount = 1;
		// to avoid first column
		itr.next();

		while (itr.hasNext()) {
			Cell cell = itr.next();
			Cell headerValue = headerRow.getCell(headerCellCount++);
			/*
			 * switch (cell.getCellType()) { case XSSFCell.CELL_TYPE_BOOLEAN: cellValue =
			 * cell.getBooleanCellValue() + ""; information = information + " " +
			 * headerValue + " - " + cellValue + "; "; break; case
			 * XSSFCell.CELL_TYPE_NUMERIC: cellValue = cell.getNumericCellValue() + "";
			 * information = information + " " + headerValue + " - " + cellValue + "; ";
			 * break; case XSSFCell.CELL_TYPE_STRING: cellValue = cell.getStringCellValue();
			 * information = information + " " + headerValue + " - " + cellValue + "; ";
			 * break; case XSSFCell.CELL_TYPE_BLANK: break; }
			 */

			if (headerName.equalsIgnoreCase(headerValue.toString())) {

				DataFormatter dataFormatter = new DataFormatter();
				cellValue = dataFormatter.formatCellValue(cell);
				// cellValue = cell.getStringCellValue();
				Log.info("Test Data from Excel : " + headerName + ": " + cellValue);

			}

		}
		return cellValue;
	}

	public static String getData(String testCaseName, String headerName) {

		try {
			return getAllColumnFromRow(findRow(testCaseName), headerName);
		} catch (IOException e) {
			Log.info("Please check Test data sheet/Prive valid inputs");
			return "";
		}

	}

}
