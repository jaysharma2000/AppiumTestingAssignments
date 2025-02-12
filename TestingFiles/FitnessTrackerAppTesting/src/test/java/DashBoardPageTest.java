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

public class DashBoardPageTest {
	
	private AppiumDriver driver;
	
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
	public void dashboardPageTest() throws InterruptedException {
		SplashScreenTest splashScreenTest = new SplashScreenTest(driver);
	    splashScreenTest.splashScreenTest();
	    
	    WebElement skipButtonElement = driver.findElement(By.id("skipButton"));
		
		if(skipButtonElement.isDisplayed()) {
			System.out.println("Skip button displayed");
		}else {
			System.out.println("skip button not found");
		}
		
		skipButtonElement.click();
		System.out.println("Clicked on skip button");
		
		WebElement stepsCountElement = driver.findElement(By.id("steps_count"));
		WebElement calories_burnedElement = driver.findElement(By.id("calories_burned"));
		WebElement syncButtonElement = driver.findElement(By.id("syncButton"));
		
		if(stepsCountElement.isDisplayed()) {
			System.out.println("Navigated to DashBoard page");
		}else {
			System.out.println("Not able to navigate");
		}
		
		if(calories_burnedElement.isDisplayed()) {
			System.out.println("Calories burned found");
		}else {
			System.out.println("Not able to navigate");
		}
		
		if(syncButtonElement.isDisplayed()) {
			System.out.println("sync device button found");
		}else {
			System.out.println("Not able to find the sync device ");
		}
		
		syncButtonElement.click();
		System.out.println("Clicked on sync data button");
	}

}
