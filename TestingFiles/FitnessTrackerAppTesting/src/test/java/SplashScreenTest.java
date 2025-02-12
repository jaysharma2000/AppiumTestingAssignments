import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class SplashScreenTest {
	
	private AppiumDriver driver;
	
	public SplashScreenTest(AppiumDriver driver) {
	    this.driver = driver;
	}
	
	@Before
	public void setUp() throws MalformedURLException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Xiaomi Redmi Not 8 Pro");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		capabilities.setCapability("appPackage", "com.example.fitnesstrackerapp");
		capabilities.setCapability("appActivity", "com.example.fitnesstrackerapp.ui.MainActivity");
		driver = new AndroidDriver(new URL("http://localhost:4723"), capabilities);
	}


	@Test
	public void splashScreenTest() throws InterruptedException {
		WebElement appLogoElement = driver.findElement(By.id("splash_logo"));
		
		if(appLogoElement.isDisplayed()) {
			System.out.println("App Logo Displayed Successfully");
		}else {
			System.out.println("No app logo found");
		}
		
		Thread.sleep(3000);
		System.out.println("Wait for 3 sec splash screen");
		
		WebElement apptitleElement = driver.findElement(By.id("onboarding_text"));
		
		if(apptitleElement.isDisplayed()) {
			System.out.println("Successfully navigated to Onboarding screen after 3 sec delay");
		}else {
			System.out.println("Not able to navigate to onboarding screen");
		}
	}
}
