import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser("http://www.shinkin.co.jp/tib/demo/kib/FullDemo/renewal/mpn/wmpsrvb0812.html")
WebUI.maximizeWindow()
WebUI.delay(2)

def expectedURL_btn01 = CustomKeywords.'com.gmo.Utilities.getURLOnOldSystem'(findTestObject('Object Repository/renewal/mpn/Page_wmpsrvb0812html/41_body_line24_btn'))
WebUI.back()
WebUI.delay(2)
def expectedURL_btn02 = CustomKeywords.'com.gmo.Utilities.getURLOnOldSystem'(findTestObject('Object Repository/renewal/mpn/Page_wmpsrvb0812html/42_body_line25_btn'))
WebUI.delay(2)
WebUI.back()
WebUI.delay(2)
def expectedURL_btn03 = CustomKeywords.'com.gmo.Utilities.getURLOnOldSystem'(findTestObject('Object Repository/renewal/mpn/Page_wmpsrvb0812html/43_body_line26_btn'))
WebUI.delay(2)
WebUI.back()
WebUI.delay(2)
def expectedURL_btn04 = CustomKeywords.'com.gmo.Utilities.getURLOnOldSystem'(findTestObject('Object Repository/renewal/mpn/Page_wmpsrvb0812html/44_body_line27_link'))
WebUI.delay(2)
WebUI.back()
WebUI.delay(2)
def expectedURL_btn05 = CustomKeywords.'com.gmo.Utilities.getURLOnOldSystem'(findTestObject('Object Repository/renewal/mpn/Page_wmpsrvb0812html/46_body_line29_btn'))
WebUI.delay(2)

WebUI.closeBrowser()


WebUI.openBrowser("http://www.shinkin.co.jp/tib/demo/kib/FullDemo/renewal/mpn/wmpsrvb0812.html")
WebUI.maximizeWindow()
WebUI.delay(2)

CustomKeywords.'com.gmo.Utilities.verifySwitchToScreenAfterClickButton'(findTestObject('Object Repository/renewal/mpn/Page_wmpsrvb0812html/41_body_line24_btn'), '', expectedURL_btn01)
WebUI.delay(2)
WebUI.back()
WebUI.delay(2)
CustomKeywords.'com.gmo.Utilities.verifySwitchToScreenAfterClickButton'(findTestObject('Object Repository/renewal/mpn/Page_wmpsrvb0812html/42_body_line25_btn'), '', expectedURL_btn02)
WebUI.delay(2)
WebUI.back()
WebUI.delay(2)
CustomKeywords.'com.gmo.Utilities.verifySwitchToScreenAfterClickButton'(findTestObject('Object Repository/renewal/mpn/Page_wmpsrvb0812html/43_body_line26_btn'), '', expectedURL_btn03)
WebUI.delay(2)
WebUI.back()
WebUI.delay(2)
CustomKeywords.'com.gmo.Utilities.verifySwitchToScreenAfterClickButton'(findTestObject('Object Repository/renewal/mpn/Page_wmpsrvb0812html/44_body_line27_link'), '', expectedURL_btn04)
WebUI.delay(2)
WebUI.back()
WebUI.delay(2)
CustomKeywords.'com.gmo.Utilities.verifySwitchToScreenAfterClickButton'(findTestObject('Object Repository/renewal/mpn/Page_wmpsrvb0812html/46_body_line29_btn'), '', expectedURL_btn05)
WebUI.delay(2)

WebUI.closeBrowser()
