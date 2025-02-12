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

public class LoginScreenTest {
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
	public void registerTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		WebElement loginTitleElement = driver.findElement(By.xpath("//android.widget.TextView[@text='Login']"));
		WebElement notRegisterText = driver.findElement(By.id("notRegisteredText"));
		WebElement registerButton = driver.findElement(By.id("registerButton"));
		
		if(loginTitleElement.isDisplayed()) {
			System.out.println("Login text Visible");
		}else {
			System.out.println("login text is not visible");
		}
		
		if(notRegisterText.isDisplayed()) {
			System.out.println("The text - Not registered yet, is visible");
		}
		
		if(registerButton.isDisplayed()) {
			System.out.println("Register button found");
			registerButton.click();
			System.out.println("Clicked on register button & navigated to register page");
		}else {
			System.out.println("no register button found");
		}
		
		Thread.sleep(2000);
		driver.navigate().back();
        System.out.println("Navigated back to login page");
		//Thread.sleep(2000);
        
        WebElement editTextEmailField = driver.findElement(By.xpath("//android.widget.EditText[@hint='enter email']"));
		WebElement editTextPasswordField = driver.findElement(By.xpath("//android.widget.EditText[@hint='enter password']"));
		WebElement loginButton = driver.findElement(By.id("loginButton"));
		
		if(editTextEmailField.isDisplayed() && editTextPasswordField.isDisplayed()) {
			System.out.println("editTextEmail and editTextPassword fields are visible");
			editTextEmailField.sendKeys("admin");
			editTextPasswordField.sendKeys("12345");
			System.out.println("Entered email and password");
		}else {
			System.out.println("The enterEmail and enterpassword fields are not visible");
		}
		
		if(loginButton.isDisplayed()) {
			loginButton.click();
			System.out.println("Clicked on Login button & navigated to productList page");
		}else {
			System.out.println("no login button found");
		}
		
	}
	
	@After
    public void tearDown() {
   	 if(driver != null) {
   		 driver.quit();
   	 }
    }

}
