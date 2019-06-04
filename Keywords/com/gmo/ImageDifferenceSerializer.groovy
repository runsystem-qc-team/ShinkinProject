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
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

import javax.imageio.ImageIO;

import internal.GlobalVariable

public class ImageDifferenceSerializer {
	ImageDifference imgDifference_
	Path outputDirectory_
	Path expected_
	Path actual_
	Path diff_

	ImageDifferenceSerializer(ImageDifference imgDifference, Path outputDirectory, String identifier) {
		imgDifference_ = imgDifference
		outputDirectory_ = outputDirectory
		expected_ = outputDirectory.resolve(identifier + ".expected.png")
		actual_   = outputDirectory.resolve(identifier + ".actual.png")
		diff_     = outputDirectory.resolve(identifier + ".diff(${imgDifference.getRatioAsString()}).png")
	}

	Path getExpected() {
		return expected_
	}

	Path getActual() {
		return actual_
	}

	Path getDiff() {
		return diff_
	}

	void serialize() {
		Files.createDirectories(outputDirectory_)
		ImageIO.write(imgDifference_.getExpectedImage(), "PNG", expected_.toFile())
		ImageIO.write(imgDifference_.getActualImage(),   "PNG", actual_.toFile())
		ImageIO.write(imgDifference_.getDiffImage(),     "PNG", diff_.toFile())
	}
}
