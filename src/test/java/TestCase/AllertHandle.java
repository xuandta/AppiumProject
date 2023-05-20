package TestCase;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.automation.library.MyActions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AllertHandle {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AndroidDriver<MobileElement> driver;
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "android");
		desiredCapabilities.setCapability("platformVersion", "12");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "UiAutomator2"); 
		desiredCapabilities.setCapability("appPackage", "com.example.orderapp");
		desiredCapabilities.setCapability("appActivity", "com.example.orderapp.MainActivity");

        URL remoteAddress = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(remoteAddress, desiredCapabilities);
        System.out.println("Set up thành công");
        
        MyActions MyActions = new MyActions(driver);
        MyActions.A_Accept_Allert_Android();
        
        driver.close();
	}
}
