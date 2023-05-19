package com.automation.library;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CaptureScreenshot {
	public static void takeScreenshot(WebDriver driver, String testcaseName) {
	    try {
	        File theDir = new File("./Screenshots/");
	        String currentDateTimeString = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
	        if(!theDir.exists()) {theDir.mkdirs();}
	        				// Thực hiện chụp ảnh màn hình, lấy ra đối tượng file ảnh source.
	        TakesScreenshot screenshot = (TakesScreenshot) driver;
	        File source = screenshot.getScreenshotAs(OutputType.FILE);

					        //Tạo đối tượng file với tên đã đặt bên trên tại thư mục /ScreenShots,
					        // Sau đó thực viện cope file ảnh nguồn vào file đích đó.
	        File destiny = new File("./Screenshots/" + testcaseName+ currentDateTimeString+".jpg");
	        FileHandler.copy(source, destiny);

	    } catch (Exception ex) {
	        System.out.println("Đã xảy ra lỗi khi chụp màn hình!");
	        ex.printStackTrace();
	    }
	}

}


