package foodDeliveryApp;

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

public class OrderSummaryTest {
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
	public void orderSummaryTest() throws InterruptedException {
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
			
			WebElement addtoCartButtonElement = driver.findElement(By.id("btnAddToCart"));
			WebElement itemsCounterElement = driver.findElement(By.id("tvCartCounter"));
			
			addtoCartButtonElement.click();
			System.out.println("Click on add to cart button");
			
			System.out.println("Count of cart items " + itemsCounterElement.getText());
			
			String cartCount = itemsCounterElement.getText();
			assertEquals("1", cartCount);
			System.out.println("MenuItem successfully added to cart ");
			
			WebElement cartIconElement = driver.findElement(By.id("fabCart"));
			
			
			itemsCounterElement.click();
			
			Thread.sleep(1000);	
			
			//order summary page test
		      
			WebElement itemImageElement = driver.findElement(By.id("tvItemImage"));
			
			if(itemImageElement.isDisplayed()) {
				System.out.println("Navigated to order summary page");
			}else {
				System.out.println("Not able to navigate to order summary page");
			}
			
			
			WebElement itemNameElement = driver.findElement(By.id("tvItemName"));
			WebElement itemPriceElement = driver.findElement(By.id("tvItemPrice"));
			WebElement itemQuantityElement = driver.findElement(By.id("tvItemQuantity"));
			WebElement itemTotalElement = driver.findElement(By.id("tvTotal"));
			WebElement placeOrderButtonElement = driver.findElement(By.id("btnPlaceOrder"));
			
			if(itemNameElement.isDisplayed()) {
				System.out.println("Item visible in cart, Name: "+ itemNameElement.getText());
			}else {
				System.out.println("No item found");
			}
			
			if(itemPriceElement.isDisplayed()) {
				System.out.println("Item price visible in cart, Price: "+ itemPriceElement.getText());
			}else {
				System.out.println("No item found");
			}
			
			if(itemQuantityElement.isDisplayed()) {
				System.out.println("Item quantity visible in cart, Name: "+ itemQuantityElement.getText());
			}else {
				System.out.println("No item found");
			}
			
			if(itemTotalElement.isDisplayed()) {
				System.out.println("Items total price visible in cart, Name: "+ itemTotalElement.getText());
			}else {
				System.out.println("No item found");
			}
			
			if(placeOrderButtonElement.isDisplayed()) {
				System.out.println("Place order button visible in cart, Name: "+ itemNameElement.getText());
			}else {
				System.out.println("No item found");
			}
			
			placeOrderButtonElement.click();
			System.out.println("Order Placed Successfully");
	}
}
