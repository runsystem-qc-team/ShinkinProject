package com.gmo

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import java.awt.*;
import java.awt.image.*
import java.awt.image.BufferedImage

import ru.yandex.qatools.ashot.AShot
import ru.yandex.qatools.ashot.Screenshot
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider
import ru.yandex.qatools.ashot.shooting.ShootingStrategies
import ru.yandex.qatools.ashot.comparison.ImageDiff
import ru.yandex.qatools.ashot.comparison.ImageDiffer

import internal.GlobalVariable

public class ImageDifference {
	BufferedImage expectedImage_
	BufferedImage actualImage_
	BufferedImage diffImage_
	Double ratio_ = 0.0        // percentage
	Double criteria_ = 1.0     // percentage

	ImageDifference()
	{
		expectedImage_ = null
		actualImage_ = null
	}

	ImageDifference(BufferedImage expected, BufferedImage actual)
	{
		expectedImage_ = expected
		actualImage_ = actual
		ImageDiff imgDiff = makeImageDiff(expectedImage_, actualImage_)
		ratio_ = calculateRatioPercent(imgDiff)
		diffImage_ = imgDiff.getMarkedImage()
	}

	ImageDiff makeImageDiff(BufferedImage expected, BufferedImage actual)
	{
		Screenshot expectedScreenshot = new Screenshot(expected)
		Screenshot actualScreenshot = new Screenshot(actual)
		ImageDiff imgDiff = new ImageDiffer().makeDiff(expectedScreenshot, actualScreenshot)
		return imgDiff
	}

	static ImageDifference compareImages(BufferedImage expectedImage, BufferedImage actualImage, Double criteriaPercent) {
		ImageDifference imgDifference =
				new ImageDifference(expectedImage, actualImage)
		imgDifference.setCriteria(criteriaPercent)
		return imgDifference
	}

	BufferedImage getExpectedImage() {
		expectedImage_
	}

	BufferedImage getActualImage() {
		actualImage_
	}

	BufferedImage getDiffImage() {
		return diffImage_
	}

	void setCriteria(Double criteria) {
		criteria_ = criteria
	}

	Double getCriteria() {
		return criteria_
	}

	/**
	 *
	 * @return e.g. 0.23% or 90.0%
	 */
	Double getRatio() {
		return ratio_
	}

	/**
	 * @return e.g. "0.23" or "90.00"
	 */
	String getRatioAsString(String fmt = '%1$.2f') {
		return String.format(fmt, this.getRatio())
	}

	/**
	 *
	 * Round up 0.0001 to 0.01
	 *
	 * @param diff
	 * @return
	 */
	private Double calculateRatioPercent(ImageDiff diff) {
		boolean hasDiff = diff.hasDiff()
		if (!hasDiff) {
			return 0.0
		}
		int diffSize = diff.getDiffSize()
		int area = diff.getMarkedImage().getWidth() * diff.getMarkedImage().getHeight()
		Double diffRatio = diff.getDiffSize() / area * 100
		BigDecimal bd = new BigDecimal(diffRatio)
		BigDecimal bdUP = bd.setScale(2, BigDecimal.ROUND_UP);  // 0.001 -> 0.01
		return bdUP.doubleValue()
	}


	/**
	 * @return true if the expected image and the actual image pair has
	 *         greater difference than the criteria = these are different enough,
	 *         otherwise false.
	 */
	Boolean imagesAreDifferent() {
		return (ratio_ > criteria_)
	}

	/**
	 * @return true if the expected image and the actual image pair has
	 *         smaller difference than the criteria = these are similar enough,
	 *         otherwise false.
	 */
	Boolean imagesAreSimilar() {
		return (ratio_ <= criteria_)
	}
}
