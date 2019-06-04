import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.nio.file.Path as Path
import java.nio.file.Paths as Paths
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

Path projectdir = Paths.get(RunConfiguration.getProjectDir())

Path datadir = projectdir.resolve('Data Files\\renewal\\mpn\\Page_wmpsrvb0812html')

Path workdir = projectdir.resolve('tmp\\renewal\\mpn\\Page_wmpsrvb0812html\\TC01')

WebUI.openBrowser('http://www.shinkin.co.jp/tib/demo/kib/FullDemo/renewal/mpn/wmpsrvb0812.html')

WebUI.maximizeWindow()

WebUI.delay(2)


WebUI.takeScreenshot('Data Files\\renewal\\mpn\\Page_wmpsrvb0812html\\OS7_wmpsrvb0812_01.png')

File img1 = datadir.resolve('OS7_wmpsrvb0812_01.png').toFile()

WebUI.scrollToElement(findTestObject('renewal/mpn/Page_wmpsrvb0812html/21_body_line12_text_01'), 2)

WebUI.takeScreenshot('Data Files\\renewal\\mpn\\Page_wmpsrvb0812html\\OS7_wpiatnb001_02.png')

File img3 = datadir.resolve('OS7_wpiatnb001_02.png').toFile()

WebUI.scrollToElement(findTestObject('renewal/mpn/Page_wmpsrvb0812html/46_body_line29_btn'), 2)

WebUI.takeScreenshot('Data Files\\renewal\\mpn\\Page_wmpsrvb0812html\\OS7_wpiatnb001_03.png')

File img5 = datadir.resolve('OS7_wpiatnb001_02.png').toFile()

WebUI.closeBrowser()

WebUI.openBrowser('http://www.shinkin.co.jp/tib/demo/kib/FullDemo/renewal/mpn/wmpsrvb0812.html')

WebUI.maximizeWindow()

WebUI.delay(2)

WebUI.takeScreenshot('Data Files\\renewal\\mpn\\Page_wmpsrvb0812html\\OS10_wpiatnb001_01.png')

File img2 = datadir.resolve('OS10_wpiatnb001_01.png').toFile()

WebUI.scrollToElement(findTestObject('renewal/mpn/Page_wmpsrvb0812html/21_body_line12_text_01'), 2)

WebUI.takeScreenshot('Data Files\\renewal\\mpn\\Page_wmpsrvb0812html\\OS10_wpiatnb001_02.png')

File img4 = datadir.resolve('OS10_wpiatnb001_02.png').toFile()

WebUI.scrollToElement(findTestObject('renewal/mpn/Page_wmpsrvb0812html/46_body_line29_btn'), 2)

WebUI.takeScreenshot('Data Files\\renewal\\mpn\\Page_wmpsrvb0812html\\OS10_wpiatnb001_03.png')

File img6 = datadir.resolve('OS10_wpiatnb001_02.png').toFile()

CustomKeywords.'com.gmo.Utilities.verifyImagesAreSimilar'(img1, img2, 3.0, workdir.resolve('a').toFile(), FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.gmo.Utilities.verifyImagesAreSimilar'(img3, img4, 3.0, workdir.resolve('b').toFile(), FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.gmo.Utilities.verifyImagesAreSimilar'(img5, img6, 3.0, workdir.resolve('c').toFile(), FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

