package com.gmo

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.awt.*;
import java.awt.image.*
import java.nio.file.Path
import java.nio.file.Paths

import javax.imageio.ImageIO;

import org.apache.poi.hssf.usermodel.HSSFClientAnchor
import org.apache.poi.hssf.usermodel.HSSFPatriarch
import org.apache.poi.hssf.usermodel.HSSFPicture
import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.ClientAnchor
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.util.IOUtils
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords

import kms.turing.katalon.plugins.assertj.BooleanAssert as BooleanAssert
import ru.yandex.qatools.ashot.AShot
import ru.yandex.qatools.ashot.Screenshot
import ru.yandex.qatools.ashot.shooting.ShootingStrategies

public class Utilities {
	static Sheet sheet
	static Workbook workbook
	static org.apache.poi.ss.usermodel.Cell Cell
	static Row row
	static final String Path_TestData = "Data Files//TestData.xlsx"

	static Path tmpDir = Paths.get(RunConfiguration.getProjectDir()).resolve('tmp')
	static Boolean forceSnapshots = true
	static KeywordLogger log = new KeywordLogger()
	static final File dirOldSystem = new File("Data Files//Images//Old System")
	static final File dirNewSystem = new File("Data Files//Images//New System")
	static Map fontDataOnOldSystem = ["Object Name On Old System":"Font Family On Old System"]
	static Map fontDataOnNewSystem = ["Object Name On New System":"Font Family On New System"]

	@Keyword
	static String getURLOnOldSystem(TestObject obj) {
		WebUI.click(obj)
		WebUI.delay(1)
		def expectedURL = WebUI.getUrl()
		return expectedURL
	}

	@Keyword
	static void getFontFamilyOnOldSystem(String obj) {
		log.logInfo("Get font family of Element")
		def lableOfObject = WebUI.getText(findTestObject(obj))
		def fontFaminly = WebUI.getCSSValue(findTestObject(obj), "font-family")
		//log.logInfo("Font Faminly: " + fontFaminly)
		fontDataOnOldSystem.put(lableOfObject, fontFaminly)
		//log.logInfo("Font of Record" + fontDataOnOldSystem)
		//return fontFaminly
	}

	@Keyword
	static void writeFontDataOnOldSysteToExcel() {
		workbook = ExcelKeywords.getWorkbook(Path_TestData)
		//log.logInfo("Workbook: " + workbook)
		sheet = workbook.getSheet("TC7")
		//log.logInfo("Sheet: " + sheet.sheetName)
		def key = fontDataOnOldSystem.keySet()
		def value = fontDataOnOldSystem.values()
		//log.logInfo("Record Font Data size: " + fontDataOnOldSystem.size())
		for(int i = 0; i < fontDataOnOldSystem.size(); i++) {
			Cell cell1 = ExcelKeywords.setValueToCellByIndex(sheet, i, 0, key[i])
			Cell cell2 = ExcelKeywords.setValueToCellByIndex(sheet, i, 1, value[i])
		}

		FileOutputStream fileOut = new FileOutputStream(Path_TestData);
		workbook.write(fileOut)
		fileOut.close()
	}

	@Keyword
	static void getFontFamilyOnNewSystem(String obj) {
		log.logInfo("Get font family of Element")
		def lableOfObject = WebUI.getText(findTestObject(obj))
		def fontFaminly = WebUI.getCSSValue(findTestObject(obj), "font-family")
		//log.logInfo("Font Faminly: " + fontFaminly)
		fontDataOnNewSystem.put(lableOfObject, fontFaminly)
		//log.logInfo("Font of Record" + fontDataOnNewSystem)
		//return fontFaminly
	}

	@Keyword
	static void writeFontDataOnNewSysteToExcel() {
		workbook = ExcelKeywords.getWorkbook(Path_TestData)
		//log.logInfo("Workbook: " + workbook)
		sheet = workbook.getSheet("TC7")
		//log.logInfo("Sheet: " + sheet.sheetName)
		def key = fontDataOnNewSystem.keySet()
		def value = fontDataOnNewSystem.values()
		//log.logInfo("Record Font Data size: " + fontDataOnNewSystem.size())
		for(int i = 0; i < fontDataOnNewSystem.size(); i++) {
			Cell cell1 = ExcelKeywords.setValueToCellByIndex(sheet, i, 2, key[i])
			Cell cell2 = ExcelKeywords.setValueToCellByIndex(sheet, i, 3, value[i])
		}

		FileOutputStream fileOut = new FileOutputStream(Path_TestData);
		workbook.write(fileOut)
		fileOut.close()
	}

	@Keyword
	static void verifyFontOnTwoSystem() {
		workbook = ExcelKeywords.getWorkbook(Path_TestData)
		log.logInfo("Workbook: " + workbook)
		sheet = workbook.getSheet("TC7")
		log.logInfo("Sheet: " + sheet.sheetName)
		for(int i = 1; i < fontDataOnNewSystem.size(); i++) {
			def cellOfOldSystem1 = ExcelKeywords.getCellValueByIndex(sheet, i, 0)
			def cellOfOldSystem2 = ExcelKeywords.getCellValueByIndex(sheet, i, 1)
			def cellOfNewSystem1 = ExcelKeywords.getCellValueByIndex(sheet, i, 2)
			def cellOfNewSystem2 = ExcelKeywords.getCellValueByIndex(sheet, i, 3)
			if (cellOfOldSystem2 == cellOfNewSystem2) {
				BooleanAssert.isTrue(true, "Element of Old System and New System are the text")
			} else {
				BooleanAssert.isTrue(false, "Element of Old System and New System are not the text")
			}
			if (cellOfOldSystem2 == cellOfNewSystem2) {
				BooleanAssert.isTrue(true, "Font of Old System and New System are the same")
			} else {
				BooleanAssert.isTrue(false, "Font of Old System and New System are not the same")
			}
		}

		FileOutputStream fileOut = new FileOutputStream(Path_TestData);
		workbook.write(fileOut)
		fileOut.close()
	}

	@Keyword
	static void verifySwitchToScreenAfterClickButton(TestObject obj, String expectedURL){
		WebUI.click(obj)
		WebUI.delay(2)
		def actualURL = WebUI.getUrl()
		WebUI.verifyEqual(actualURL, expectedURL)
		WebUI.delay(5)
	}

	@Keyword
	static void screenshotFullPage() {
		WebDriver driver = DriverFactory.getWebDriver()
		Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(fpScreenshot.getImage(),"PNG",new File("Data Files\\FullPageScreenshot.png"));
	}

	@Keyword
	static void insertImagesToExcel(String sheetName) {
		/* Create a Workbook and Worksheet */
		HSSFWorkbook wb = new HSSFWorkbook()
		def row1 = 1
		def row2 = 1
		HSSFSheet sh = wb.createSheet(sheetName)
		/* Read the input image into InputStream */
		for(final File f: dirOldSystem.listFiles()) {
			InputStream my_banner_image = new FileInputStream(f);
			/* Convert Image to byte array */
			byte[] bytes = IOUtils.toByteArray(my_banner_image)
			/* Add Picture to workbook and get a index for the picture */
			int my_picture_id = wb.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
			/* Close Input Stream */
			my_banner_image.close()
			/* Create the drawing container */
			HSSFPatriarch drawing = sh.createDrawingPatriarch()
			/* Create an anchor point */
			ClientAnchor my_anchor = new HSSFClientAnchor()
			/* Define top left corner, and we can resize picture suitable from there */
			my_anchor.setCol1(1)
			my_anchor.setRow1(row1)
			/* Invoke createPicture and pass the anchor point and ID */
			HSSFPicture  my_picture = drawing.createPicture(my_anchor, my_picture_id);
			/* Call resize method, which resizes the image */
			my_picture.resize(0.5);

			row1 += 31
			/* Write changes to the workbook */
			FileOutputStream out = new FileOutputStream(new File("Data Files\\excel_insert_image_example.xls"));
			wb.write(out)
			out.close()
		}

		for(final File f: dirNewSystem.listFiles()) {
			InputStream my_banner_image = new FileInputStream(f);
			/* Convert Image to byte array */
			byte[] bytes = IOUtils.toByteArray(my_banner_image)
			/* Add Picture to workbook and get a index for the picture */
			int my_picture_id = wb.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
			/* Close Input Stream */
			my_banner_image.close()
			/* Create the drawing container */
			HSSFPatriarch drawing = sh.createDrawingPatriarch()
			/* Create an anchor point */
			ClientAnchor my_anchor = new HSSFClientAnchor()
			/* Define top left corner, and we can resize picture suitable from there */
			my_anchor.setCol1(18)
			my_anchor.setRow1(row2)
			/* Invoke createPicture and pass the anchor point and ID */
			HSSFPicture  my_picture = drawing.createPicture(my_anchor, my_picture_id);
			/* Call resize method, which resizes the image */
			my_picture.resize(0.5);

			row2 += 31
			/* Write changes to the workbook */
			FileOutputStream out = new FileOutputStream(new File("Data Files\\excel_insert_image_example.xls"));
			wb.write(out)
			out.close()
		}

	}

	@Keyword
	static void markObjectOnImageOfOnOldSystem(String sourceImage, String to) {
		BufferedImage image = ImageIO.read(new File(sourceImage))

		Graphics2D graphics = image.createGraphics()
		
		def xpathOfElement = findTestObject(to).findXpathValue("xpath:idRelative")
		WebDriver driver = DriverFactory.getWebDriver()

		WebElement ele = driver.findElement(By.xpath(xpathOfElement))

		int x = ele.getLocation().getX()

		int y = ele.getLocation().getY()

		int width = ele.getSize().getWidth()

		int height = ele.getSize().getHeight()

		log.logInfo("Drawing rectangle at " + x + ", " + y + ", " + width + ", " + height)

		//The colour for the rectangle which is to be drawn around the element
		graphics.setColor(Color.RED)

		//Thickness of each side of the rectangle
		graphics.setStroke(new BasicStroke(3.0f))

		//To draw the rectangle around the element
		graphics.drawRect(x, y, width, height)
		
		Date d = new Date()
		def screenshotName = "Old_System_" + d.toString().replace(":", "_").replace(" ", "_")
		//Path to save the screenshot
		ImageIO.write(image, "png", new File(RunConfiguration.getProjectDir(),
				"\\Data Files\\" + screenshotName))
	}
	
	@Keyword
	static void markObjectOnImageOfOnNewSystem(String sourceImage, String to) {
		BufferedImage image = ImageIO.read(new File(sourceImage))

		Graphics2D graphics = image.createGraphics()
		
		def xpathOfElement = findTestObject(to).findXpathValue("xpath:idRelative")
		WebDriver driver = DriverFactory.getWebDriver()

		WebElement ele = driver.findElement(By.xpath(xpathOfElement))

		int x = ele.getLocation().getX()

		int y = ele.getLocation().getY()

		int width = ele.getSize().getWidth()

		int height = ele.getSize().getHeight()

		log.logInfo("Drawing rectangle at " + x + ", " + y + ", " + width + ", " + height)

		//The colour for the rectangle which is to be drawn around the element
		graphics.setColor(Color.RED)

		//Thickness of each side of the rectangle
		graphics.setStroke(new BasicStroke(3.0f))

		//To draw the rectangle around the element
		graphics.drawRect(x, y, width, height)
		
		Date d = new Date()
		def screenshotName = "New_System_" + d.toString().replace(":", "_").replace(" ", "_")
		//Path to save the screenshot
		ImageIO.write(image, "png", new File(RunConfiguration.getProjectDir(),
				"\\Data Files\\" + screenshotName))
	}

	@Keyword
	static Boolean verifyImagesAreSimilar(
			File expected,
			File actual,
			Double criteriaPercent,
			File snapshotsDir,
			FailureHandling flowControl = FailureHandling.CONTINUE_ON_FAILURE) {
		BufferedImage exp = ImageIO.read(expected)
		BufferedImage act = ImageIO.read(actual)
		ImageDifference imgDifference = ImageDifference.compareImages(exp, act, criteriaPercent)
		boolean result = imgDifference.imagesAreSimilar()
		//snapshotsDir = tmpDir
		ImageDifferenceSerializer serializer =
				new ImageDifferenceSerializer(imgDifference, snapshotsDir.toPath(),
				'verifyImagesAreSimilar(File,File)')
		if (!result || forceSnapshots) {
			serializer.serialize()
		}
		BooleanAssert.isTrue(result, "images are expected to be similar but are different," +
				" difference=${imgDifference.getRatioAsString()}%," +
				" snapshots were saved in ${snapshotsDir.toString()}",
				FailureHandling.STOP_ON_FAILURE)
	}
}
