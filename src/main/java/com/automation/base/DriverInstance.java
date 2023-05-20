package com.automation.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DriverInstance {

//	protected AppiumDriver<MobileElement> driver;
	protected AndroidDriver<MobileElement> driver;

	@BeforeMethod
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
	public void name() {

	}
	@AfterMethod
	protected void tearDown() {
		driver.quit();
	}

}
