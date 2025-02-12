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

public class MenuItemsTest {
	
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
	public void menuItemsPageTesting() throws InterruptedException {
		System.out.println("Successfully launched HomeFragment");
		
		
		WebElement restaurantImageElement = driver.findElement(By.id("ivImage"));
		
		if(restaurantImageElement.isDisplayed()) {
			System.out.println("The restaurant details displayed successfully");
			restaurantImageElement.click();
			System.out.println("Clicked on restaurant ");
		}else {
			System.out.println("No restaurant found");
		}
		
		
		WebElement recyclerViewElement = driver.findElement(By.id("recyclerView"));
		if(recyclerViewElement.isDisplayed()) {
			System.out.println("Recyclerview is displayed");
		}
		
		WebElement menuItemImagElement = driver.findElement(By.id("ivImage"));
		WebElement menuItemNameElement = driver.findElement(By.id("tvName"));
		WebElement menuItemPriceElement = driver.findElement(By.id("tvPrice"));
		WebElement addtoCartButtonElement = driver.findElement(By.id("btnAddToCart"));
		
		if(menuItemImagElement.isDisplayed()) {
			System.out.println("MenuItem image found");
		}else {
			System.out.println("No menuItem image found");
		}
		
		
		if(menuItemNameElement.isDisplayed()) {
			System.out.println("MenuItem Name found: "+ menuItemNameElement.getText());
		}else {
			System.out.println("No menuitem name found");
		}
		
		if(menuItemPriceElement.isDisplayed()) {
			System.out.println("Menuitem price found: " + menuItemPriceElement.getText());
		}else {
			System.out.println("No price found");
		}
		
		if(addtoCartButtonElement.isDisplayed()) {
			System.out.println("Add To cart button found");
		}else {
			System.out.println("No add to cart button found");
		}
		
		boolean allItemsFound = false;
		
		Set<String> allMenuItemNames = new HashSet<>(); 
		
		for(int i=0; i<5; i++) {
			Thread.sleep(1000);
			
			List<WebElement> menuItemsName = driver.findElements(By.id("tvName"));
			
			for(WebElement menuItem: menuItemsName) {
				allMenuItemNames.add(menuItem.getText());
			}
			
			
			System.out.println("Menuitems found so far: " + allMenuItemNames.size());
			
			if(allMenuItemNames.size() >= 5) {
				allItemsFound = true;
				System.out.println("All 5 items displayed successfully");
				break;
			}
			
			driver.findElement(MobileBy.AndroidUIAutomator(
			        "new UiScrollable(new UiSelector().scrollable(true)).scrollForward();"
			    ));
		}
		if (!allItemsFound) {
		    System.out.println("All items not found after scrolling.");
		}
		
		WebElement cartIconElement = driver.findElement(By.id("fabCart"));
		
		if(cartIconElement.isDisplayed()) {
			System.out.println("Cart Icon Displayed successfully");
		}else {
			System.out.println("No cart item icon found"); 
		}
		
		WebElement itemsCounterElement = driver.findElement(By.id("tvCartCounter"));
		
		if(itemsCounterElement.isDisplayed()) {
			System.out.println("Items Counter Displayed successfully");
		}else {
			System.out.println("No item counter found"); 
		}
		
		addtoCartButtonElement.click();
		System.out.println("Click on add to cart button");
		
		System.out.println("Count of cart items " + itemsCounterElement.getText());
		
		String cartCount = itemsCounterElement.getText();
		assertEquals("1", cartCount);
		System.out.println("MenuItem successfully added to cart ");

	}
	
	@After
    public void tearDown() {
   	 if(driver != null) {
   		 driver.quit();
   	 }
    }

}
