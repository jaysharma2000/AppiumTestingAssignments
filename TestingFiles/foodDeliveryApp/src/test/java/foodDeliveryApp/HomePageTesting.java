package foodDeliveryApp;

import static org.junit.Assert.*;

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


public class HomePageTesting {
	
	private AppiumDriver driver;
	
	@Before
	public void setUp() throws MalformedURLException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Xiaomi Redmi Not 8 Pro");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		capabilities.setCapability("appPackage", "com.example.fooddeliveryapp");
		capabilities.setCapability("appActivity", "com.example.fooddeliveryapp.ui.MainActivity");
		driver = new AndroidDriver(new URL("http://localhost:4723"), capabilities);
	}
	

	@Test
	public void homePageTesting() throws InterruptedException {
		System.out.println("Successfully launched HomeFragment");
		
		WebElement recyclerViewElement = driver.findElement(By.id("recyclerView"));
		if(recyclerViewElement.isDisplayed()) {
			System.out.println("Recyclerview is displayed");
		}
		
		
		WebElement restaurantImageElement = driver.findElement(By.id("ivImage"));
		WebElement restaurantNameElement = driver.findElement(By.id("tvName"));
		WebElement restaurantRatingElement = driver.findElement(By.id("tvRating"));
		WebElement restaurantDeliveryTimeElement = driver.findElement(By.id("tvDeliveryTime"));
		
		if(restaurantImageElement.isDisplayed()) {
			System.out.println("The restaurant image displayed successfully");
		}else {
			System.out.println("No restaurant image found");
		}
		
		if(restaurantNameElement.isDisplayed()) {
			System.out.println("Restaurant name found: "+ restaurantNameElement.getText());
		}else {
			System.out.println("No restaurant name found");
		}
		
		if(restaurantRatingElement.isDisplayed()) {
			System.out.println("Restaurant rating found: " + restaurantRatingElement.getText());
		}else {
			System.out.println("No rating found");
		}
		
		if(restaurantDeliveryTimeElement.isDisplayed()) {
			System.out.println("Restaurant delivery time found: " + restaurantDeliveryTimeElement.getText());
		}else {
			System.out.println("No restaurant delivery time found");
		}
		
		boolean allItemsFound = false;
		
		Set<String> allRestaurantsNames = new HashSet<>();
		
		for(int i=0; i<5; i++) {
			Thread.sleep(1000);
			
			List<WebElement> resaurantsNames = driver.findElements(By.id("tvName"));
			
			for(WebElement restaurant: resaurantsNames) {
				allRestaurantsNames.add(restaurant.getText());
			}
			
			
			System.out.println("Restaurants found so far: " + allRestaurantsNames.size());
			
			if(allRestaurantsNames.size() >= 8) {
				allItemsFound = true;
				System.out.println("All 8 items displayed successfully");
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
