import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class OnboardingScreenTest {
	
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
	
	public void swipeLeft() {
		PointerInput finger  = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
		Sequence swipe = new Sequence(finger, 0);
		
		swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), 900, 1000));
	    swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	    swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), 100, 1000));
	    swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	    driver.perform(Arrays.asList(swipe));
	}


	@Test
	public void onboardingScreenTest() throws InterruptedException {
		SplashScreenTest splashScreenTest = new SplashScreenTest(driver);
	    splashScreenTest.splashScreenTest();

		WebElement apptitleElement = driver.findElement(By.id("onboarding_text"));
		
		if(apptitleElement.isDisplayed()) {
			System.out.println("Successfully navigated to Onboarding screen after 3 sec delay");
		}else {
			System.out.println("Not able to navigate to onboarding screen");
		}
		
		WebElement viewPagerElement = driver.findElement(By.id("viewPager"));
		WebElement tabLayoutElement = driver.findElement(By.id("tabLayout"));
		
		if(viewPagerElement.isDisplayed()) {
			System.out.println("ViewPager is displayed for swipe");
			
			for(int i=1; i<=2; i++) {
				swipeLeft();
				System.out.println("Swipe done " + i + " times");
		        Thread.sleep(2000);
			}
			
		}else {
			System.out.println("No view pager found");
		}
		
		if(tabLayoutElement.isDisplayed()) {
			System.out.println("Tablayout found, shows current swipe position");
		}else {
			System.out.println("No tablayout found");
		}
		
		WebElement skipButtonElement = driver.findElement(By.id("skipButton"));
		
		if(skipButtonElement.isDisplayed()) {
			System.out.println("Skip button displayed");
		}else {
			System.out.println("skip button not found");
		}
		
		skipButtonElement.click();
		System.out.println("Clicked on skip button");
		
		
	}
}
