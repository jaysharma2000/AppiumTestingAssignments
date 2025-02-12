import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class RegisterScreenTest {

	private AppiumDriver driver;
		
		@Before
		public void setUp() throws MalformedURLException{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Xiaomi Redmi Not 8 Pro");
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
			capabilities.setCapability("appPackage", "com.example.shoppingappappiumtesting");
			capabilities.setCapability("appActivity", "com.example.shoppingappappiumtesting.MainActivity");
			driver = new AndroidDriver(new URL("http://localhost:4723"), capabilities);
		}
		
		
		@Test
		public void loginTest() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			
			WebElement registerButton = driver.findElement(By.id("registerButton"));
			
			if(registerButton.isDisplayed()) {
				registerButton.click();
				System.out.println("Clicked on register button & successfully naavigated to register page");
			}else {
				System.out.println("no register button found");
			}
			
			WebElement editemail = driver.findElement(By.id("editemail"));
			WebElement editname = driver.findElement(By.id("editname"));
			WebElement registerText = driver.findElement(By.id("registerText"));
			
			if(registerText.isDisplayed()) {
				System.out.println("register text Visible");
			}else {
				System.out.println("register text is not visible");
			}
			
			if(editemail.isDisplayed() && editname.isDisplayed()) {
				System.out.println("editTextEmail and editTextPassword fields are visible");
				editemail.sendKeys("admin");
				editname.sendKeys("admin");
				System.out.println("Entered email and password");
			}else {
				System.out.println("The enterEmail and enterpassword fields are not visible");
			}
			
			WebElement registerButton2 = driver.findElement(By.id("registerButton"));
			
			if(registerButton2.isDisplayed()) {
				registerButton2.click();
				System.out.println("Clicked on register button & successfully naavigated to login page");
			}else {
				System.out.println("no register button found");
			}
			
			Thread.sleep(1000);
			
		}
		
		@After
	    public void tearDown() {
	   	 if(driver != null) {
	   		 driver.quit();
	   	 }
	    }


}
