import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.awt.BasicStroke
import java.awt.Color
import java.awt.Graphics2D
import java.awt.image.BufferedImage

import javax.imageio.ImageIO

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import kms.turing.katalon.plugins.assertj.BooleanAssert as BooleanAssert

KeywordLogger log = new KeywordLogger()

WebUI.openBrowser('http://www.shinkin.co.jp/tib/demo/kib/FullDemo/renewal/mpn/wmpsrvb0812.html')

WebUI.maximizeWindow()

WebUI.delay(2)
WebUI.takeScreenshot('Data Files\\Images\\Old System\\OS7.png')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('header/02_header_line01_text')
CustomKeywords.'com.gmo.Utilities.markObjectOnImage'('Data Files\\Images\\Old System\\OS7.png', "header/02_header_line01_text")
//CustomKeywords.'com.gmo.Utilities.markObjectOnImageUsingTestObject'('Data Files\\Images\\Old System\\OS7.png', "header/02_header_line01_text")

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('header/03_header_line01_btn_01')
CustomKeywords.'com.gmo.Utilities.markObjectOnImage'('Data Files\\Images\\Old System\\OS7.png', "header/03_header_line01_btn_01")
//CustomKeywords.'com.gmo.Utilities.markObjectOnImageUsingTestObject'('Data Files\\Images\\Old System\\OS7.png', "header/03_header_line01_btn_01")

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('header/04_header_line01_btn_02')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('renewal/mpn/Page_wmpsrvb0812html/02_body_line01_text')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('renewal/mpn/Page_wmpsrvb0812html/03_body_line02_text')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('renewal/mpn/Page_wmpsrvb0812html/04_body_line03_text_01')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('renewal/mpn/Page_wmpsrvb0812html/05_body_line03_text_02')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('renewal/mpn/Page_wmpsrvb0812html/06_body_line03_text_03')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('renewal/mpn/Page_wmpsrvb0812html/07_body_line03_text_04')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('renewal/mpn/Page_wmpsrvb0812html/08_body_line03_text_05')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('renewal/mpn/Page_wmpsrvb0812html/09_body_line04_text')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('renewal/mpn/Page_wmpsrvb0812html/10_body_line05_text')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('renewal/mpn/Page_wmpsrvb0812html/11_body_line06_text_01')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('renewal/mpn/Page_wmpsrvb0812html/12_body_line06_text_02')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('renewal/mpn/Page_wmpsrvb0812html/13_body_line07_text_01')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('renewal/mpn/Page_wmpsrvb0812html/14_body_line07_text_02')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('renewal/mpn/Page_wmpsrvb0812html/15_body_line08_text')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('renewal/mpn/Page_wmpsrvb0812html/16_body_line09_text')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('renewal/mpn/Page_wmpsrvb0812html/17_body_line10_text_01')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('renewal/mpn/Page_wmpsrvb0812html/18_body_line10_text_02')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('renewal/mpn/Page_wmpsrvb0812html/19_body_line11_text_01')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('renewal/mpn/Page_wmpsrvb0812html/20_body_line11_text_02')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('renewal/mpn/Page_wmpsrvb0812html/21_body_line12_text_01')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('renewal/mpn/Page_wmpsrvb0812html/22_body_line12_text_02')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('renewal/mpn/Page_wmpsrvb0812html/23_body_line13_text_01')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('renewal/mpn/Page_wmpsrvb0812html/24_body_line13_text_02')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('renewal/mpn/Page_wmpsrvb0812html/25_body_line14_text_01')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('renewal/mpn/Page_wmpsrvb0812html/26_body_line14_text_02')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('renewal/mpn/Page_wmpsrvb0812html/27_body_line15_text_01')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('renewal/mpn/Page_wmpsrvb0812html/28_body_line15_text_02')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('renewal/mpn/Page_wmpsrvb0812html/29_body_line16_text_01')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('renewal/mpn/Page_wmpsrvb0812html/30_body_line16_text_02')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('renewal/mpn/Page_wmpsrvb0812html/31_body_line17_text_01')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('renewal/mpn/Page_wmpsrvb0812html/32_body_line17_text_02')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('renewal/mpn/Page_wmpsrvb0812html/33_body_line18_text_01')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('renewal/mpn/Page_wmpsrvb0812html/34_body_line18_text_02')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('renewal/mpn/Page_wmpsrvb0812html/35_body_line19_text')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('renewal/mpn/Page_wmpsrvb0812html/36_body_line20_text')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('renewal/mpn/Page_wmpsrvb0812html/37_body_line21_text')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('renewal/mpn/Page_wmpsrvb0812html/38_body_line22_text')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('renewal/mpn/Page_wmpsrvb0812html/39_body_line22_textbox')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('renewal/mpn/Page_wmpsrvb0812html/41_body_line24_btn')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('renewal/mpn/Page_wmpsrvb0812html/42_body_line25_btn')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('renewal/mpn/Page_wmpsrvb0812html/43_body_line26_btn')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('renewal/mpn/Page_wmpsrvb0812html/44_body_line27_link')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnOldSystem'('renewal/mpn/Page_wmpsrvb0812html/46_body_line29_btn')

CustomKeywords.'com.gmo.Utilities.writeFontDataOnOldSysteToExcel'()

WebUI.closeBrowser()

WebUI.openBrowser('http://www.shinkin.co.jp/tib/demo/kib/FullDemo/renewal/mpn/wmpsrvb0812.html')

WebUI.maximizeWindow()

WebUI.delay(2)

WebUI.takeScreenshot('Data Files\\Images\\New System\\OS10.png')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('header/02_header_line01_text')
	
CustomKeywords.'com.gmo.Utilities.markObjectOnImage'('Data Files\\Images\\New System\\OS10.png', "header/02_header_line01_text")

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('header/03_header_line01_btn_01')
CustomKeywords.'com.gmo.Utilities.markObjectOnImage'('Data Files\\Images\\New System\\OS10.png', "header/03_header_line01_btn_01")

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('header/04_header_line01_btn_02')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('renewal/mpn/Page_wmpsrvb0812html/02_body_line01_text')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('renewal/mpn/Page_wmpsrvb0812html/03_body_line02_text')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('renewal/mpn/Page_wmpsrvb0812html/04_body_line03_text_01')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('renewal/mpn/Page_wmpsrvb0812html/05_body_line03_text_02')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('renewal/mpn/Page_wmpsrvb0812html/06_body_line03_text_03')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('renewal/mpn/Page_wmpsrvb0812html/07_body_line03_text_04')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('renewal/mpn/Page_wmpsrvb0812html/08_body_line03_text_05')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('renewal/mpn/Page_wmpsrvb0812html/09_body_line04_text')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('renewal/mpn/Page_wmpsrvb0812html/10_body_line05_text')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('renewal/mpn/Page_wmpsrvb0812html/11_body_line06_text_01')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('renewal/mpn/Page_wmpsrvb0812html/12_body_line06_text_02')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('renewal/mpn/Page_wmpsrvb0812html/13_body_line07_text_01')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('renewal/mpn/Page_wmpsrvb0812html/14_body_line07_text_02')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('renewal/mpn/Page_wmpsrvb0812html/15_body_line08_text')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('renewal/mpn/Page_wmpsrvb0812html/16_body_line09_text')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('renewal/mpn/Page_wmpsrvb0812html/17_body_line10_text_01')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('renewal/mpn/Page_wmpsrvb0812html/18_body_line10_text_02')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('renewal/mpn/Page_wmpsrvb0812html/19_body_line11_text_01')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('renewal/mpn/Page_wmpsrvb0812html/20_body_line11_text_02')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('renewal/mpn/Page_wmpsrvb0812html/21_body_line12_text_01')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('renewal/mpn/Page_wmpsrvb0812html/22_body_line12_text_02')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('renewal/mpn/Page_wmpsrvb0812html/23_body_line13_text_01')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('renewal/mpn/Page_wmpsrvb0812html/24_body_line13_text_02')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('renewal/mpn/Page_wmpsrvb0812html/25_body_line14_text_01')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('renewal/mpn/Page_wmpsrvb0812html/26_body_line14_text_02')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('renewal/mpn/Page_wmpsrvb0812html/27_body_line15_text_01')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('renewal/mpn/Page_wmpsrvb0812html/28_body_line15_text_02')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('renewal/mpn/Page_wmpsrvb0812html/29_body_line16_text_01')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('renewal/mpn/Page_wmpsrvb0812html/30_body_line16_text_02')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('renewal/mpn/Page_wmpsrvb0812html/31_body_line17_text_01')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('renewal/mpn/Page_wmpsrvb0812html/32_body_line17_text_02')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('renewal/mpn/Page_wmpsrvb0812html/33_body_line18_text_01')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('renewal/mpn/Page_wmpsrvb0812html/34_body_line18_text_02')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('renewal/mpn/Page_wmpsrvb0812html/35_body_line19_text')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('renewal/mpn/Page_wmpsrvb0812html/36_body_line20_text')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('renewal/mpn/Page_wmpsrvb0812html/37_body_line21_text')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('renewal/mpn/Page_wmpsrvb0812html/38_body_line22_text')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('renewal/mpn/Page_wmpsrvb0812html/39_body_line22_textbox')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('renewal/mpn/Page_wmpsrvb0812html/41_body_line24_btn')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('renewal/mpn/Page_wmpsrvb0812html/42_body_line25_btn')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('renewal/mpn/Page_wmpsrvb0812html/43_body_line26_btn')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('renewal/mpn/Page_wmpsrvb0812html/44_body_line27_link')

CustomKeywords.'com.gmo.Utilities.getFontFamilyOnNewSystem'('renewal/mpn/Page_wmpsrvb0812html/46_body_line29_btn')

CustomKeywords.'com.gmo.Utilities.writeFontDataOnNewSysteToExcel'()
CustomKeywords.'com.gmo.Utilities.verifyFontOnTwoSystem'()

CustomKeywords.'com.gmo.Utilities.insertImagesToExcel'("Image")
WebUI.closeBrowser()