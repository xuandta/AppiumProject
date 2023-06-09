package com.automation.library;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CaptureAndRecord {
	public static void takeScreenshot(WebDriver driver, String testcaseName) {
		try {
			File theDir = new File("./Screenshots/");
			String currentDateTimeString = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
			if (!theDir.exists()) {theDir.mkdirs();}

			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File source = screenshot.getScreenshotAs(OutputType.FILE);
			File destiny = new File("./Screenshots/" + currentDateTimeString + "-" + testcaseName + ".jpg");
			FileHandler.copy(source, destiny);
			System.out.println("Capture ảnh thành công!");
		} catch (Exception ex) {
			System.out.println("Đã xảy ra lỗi khi chụp màn hình!");
			ex.printStackTrace();
		}
	}

}
