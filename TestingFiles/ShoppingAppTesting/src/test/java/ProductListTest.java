import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class ProductListTest {
	
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
	public void productListTest() throws InterruptedException {
		
		//testing login for product list
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
		
		//testing all products displayed or not
		
		WebElement recyclerViewElement = driver.findElement(By.id("recyclerView"));
		if(recyclerViewElement.isDisplayed()) {
			System.out.println("Recyclerview is displayed");
		}
		
		boolean allItemsFound = false;
		Set<String> uniqueProductNames = new HashSet<>();

		for (int i = 0; i < 5; i++) {
		    Thread.sleep(1000); 

		    List<WebElement> productNames = driver.findElements(By.id("productName"));

		    for (WebElement product : productNames) {
		        uniqueProductNames.add(product.getText());  
		    }

		    System.out.println("Products found so far: " + uniqueProductNames.size());

		    if (uniqueProductNames.size() >= 5) {
		        allItemsFound = true;
		        System.out.println("All 5 products were displayed at some point.");
		        break;
		    }

		    driver.findElement(MobileBy.AndroidUIAutomator(
		        "new UiScrollable(new UiSelector().scrollable(true)).scrollForward();"
		    ));
		}

		if (!allItemsFound) {
		    System.out.println("All items not found after scrolling.");
		}
	}
	
	
	@After
    public void tearDown() {
   	 if(driver != null) {
   		 driver.quit();
   	 }
    }
}
