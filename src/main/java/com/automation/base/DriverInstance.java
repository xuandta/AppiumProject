package com.automation.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class DriverInstance {

	protected AndroidDriver<MobileElement> driver;

	@BeforeTest
	protected void setUp() throws MalformedURLException {
		URL remoteAddress = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(remoteAddress, AppiumCapabilities());
		System.out.println("Set up thành công");
	}

	private DesiredCapabilities AppiumCapabilities() {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "android");
		desiredCapabilities.setCapability("platformVersion", "12");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "UiAutomator2");
		desiredCapabilities.setCapability("appPackage", "com.tuhuynh.sdetproecommerce");
		desiredCapabilities.setCapability("appActivity", "host.exp.exponent.MainActivity");
		return desiredCapabilities;
	}

    @AfterMethod
    public void CaptureAndAttact(ITestResult result) throws InterruptedException {
    	if (org.testng.ITestResult.FAILURE == result.getStatus()) {
    		try {
	       		com.automation.library.CaptureAndRecord.takeScreenshot(driver, result.getName());
	       		System.out.println("Đã chụp màn hình: " + result.getName());
    		} catch (Exception e) {
    			System.out.println("Lỗi xảy ra screenshot " + e.getMessage());
    		}  
    	}
    }
	@AfterTest
	protected void tearDown() {
		driver.quit();
	}

}
