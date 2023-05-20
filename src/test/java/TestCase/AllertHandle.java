package TestCase;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class AllertHandle {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AppiumDriver<MobileElement> driver;
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "android");
		desiredCapabilities.setCapability("platformVersion", "12");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "UiAutomator2"); 
		desiredCapabilities.setCapability("appPackage", "com.example.orderapp");
		desiredCapabilities.setCapability("appActivity", "com.example.orderapp.MainActivity");

        URL remoteAddress = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver<MobileElement>(remoteAddress, desiredCapabilities);
        System.out.println("Set up thành công");
        
        Thread.sleep(500);
        driver.findElement(By.xpath(".//android.widget.Button[@text='Allow']")).click();
        Thread.sleep(2000);
	}
}
