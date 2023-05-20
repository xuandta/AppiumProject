package TestCase;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class testshop {

	protected AppiumDriver<MobileElement> driver;

	@Test
	public void name() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "android");
		desiredCapabilities.setCapability("platformVersion", "12");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "UiAutomator2");
		desiredCapabilities.setCapability("appPackage", "com.tuhuynh.sdetproecommerce");
		desiredCapabilities.setCapability("appActivity", "host.exp.exponent.MainActivity");
		
		URL remoteAddress = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(remoteAddress, desiredCapabilities);
		
		
	
	
	
	}

}
