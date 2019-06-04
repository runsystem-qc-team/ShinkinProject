package com.gmo

import org.apache.poi.hssf.usermodel.HSSFCellStyle
import org.apache.poi.hssf.util.HSSFColor
import org.apache.poi.ss.usermodel.*
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords

public class ExtendExcelKeywords {
	static String Path_TestData
	static KeywordLogger log = new KeywordLogger()

	@Keyword
	static String getCellData(Workbook workbook, String sSheetName, int iRowNum, int iColNum) throws Exception {
		try {
			Sheet ExcelWSheet = ExcelKeywords.getExcelSheet(workbook, sSheetName)
			String CellData = ExcelKeywords.getCellValueByIndex(ExcelWSheet, iRowNum, iColNum)
			return CellData;
		} catch (Exception e) {
			log.logInfo("Class ExtendExcelKeywords | Method getCellData | Exception desc : " + e.getMessage());
			return "";
		}
	}

	@Keyword
	public static void setCellData(String Path_TestData, Workbook workbook, String sSheetName, int iRowNum, int iColNum, String sResult) throws Exception {
		CellStyle style = workbook.createCellStyle();
		if(sResult == "PASS") {
			style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			//style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
			//style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		} else {
			style.setFillForegroundColor(IndexedColors.RED.getIndex());
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			//style.setFillBackgroundColor(IndexedColors.RED.getIndex());
			//style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		}
		style.setBorderBottom(BorderStyle.THIN);
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderRight(BorderStyle.THIN);
		style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderTop(BorderStyle.THIN);
		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderLeft(BorderStyle.THIN);
		style.setTopBorderColor(IndexedColors.BLACK.getIndex());

		try {
			Sheet ExcelWSheet = workbook.getSheet(sSheetName)
			Row row = ExcelWSheet.getRow(iRowNum);
			Cell cell = row.getCell(iColNum)

			if (cell == null) {
				cell = row.createCell(iColNum)
				cell.setCellValue(sResult)
			} else {
				cell.setCellValue(sResult)
			}

			cell.setCellStyle(style)
			FileOutputStream fileOut = new FileOutputStream(Path_TestData);
			workbook.write(fileOut)
			fileOut.close()
			//workbook = new XSSFWorkbook(new FileInputStream(Path_TestData))
		} catch (Exception e) {
			log.logInfo("Class ExtendExcelKeywords | Method setCellData | Exception desc : " + e.getMessage())
		}
	}
}
