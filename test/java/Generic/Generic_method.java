package Generic;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Generic_method {
	// Declare WebDriver and FluentWait instances as class variables
	private static WebDriver driver;
	private FluentWait<WebDriver> wait;

	// Constructor that takes a WebDriver instance as a parameter
	public Generic_method(WebDriver driver) {
		// Assign the provided WebDriver instance to the class variable
		Generic_method.driver = driver;
		// Initialize the FluentWait when the object is created
		initializeFluentWait();
	}

	private void initializeFluentWait() {
		// Creating a FluentWait instance for the WebDriver with a timeout of 20 seconds
		wait = new FluentWait<>(driver)
				// Specifying the maximum amount of time to wait for an element
				.withTimeout(Duration.ofSeconds(20))
				// Configuring the polling interval, indicating how often to check for the
				// presence of an element
				.pollingEvery(Duration.ofSeconds(2))
				// Ignoring NoSuchElementException during the waiting period
				.ignoring(NoSuchElementException.class)
				// Ignoring StaleElementReferenceException during the waiting period
				.ignoring(StaleElementReferenceException.class);
	}

	// Method to maximize the window
	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public WebElement waitForElementToBeClickable(By cartElementLocator, Duration timeoutInSeconds) {
		// Consider adding comments to explain the purpose of this method
		return new WebDriverWait(driver, timeoutInSeconds)
				.until(ExpectedConditions.elementToBeClickable(cartElementLocator));
	}

	public WebElement waitForElement1(By locator, Duration timeout) {

		return wait.until(driver -> {
			WebElement element = driver.findElement(locator);
			if (element != null && element.isDisplayed()) {
				return element;
			} else {
				return null;
			}
		});
	}

	// method for validating items in cart and on the home page
	// Consider adding Javadoc comments to explain the purpose of this method

	public void validateItemsInCartAndHomePage(List<String> itemsInCart, List<String> itemsOnHomePage) {
		// Check if the items in the cart and on the home page are equal
		boolean areItemsEqual = itemsOnHomePage.containsAll(itemsInCart) && itemsInCart.containsAll(itemsOnHomePage);

		// Print messages based on the equality of items
		if (areItemsEqual) {
			System.out.println("Items in the cart and on the home page are equal:");
			System.out.println("Items in the cart: " + itemsInCart);
			System.out.println("Items on the home page: " + itemsOnHomePage);
		} else {
			System.out.println("Items in the cart and on the home page are NOT equal:");
			System.out.println("Items in the cart: " + itemsInCart);
			System.out.println("Items on the home page: " + itemsOnHomePage);
		}

		// Assert that the items in the cart match items on the home page
		assertTrue("Items in the cart do not match items on the home page", areItemsEqual);
	}

	public void clickElement(WebElement element) {
		// Wait for the element to be clickable and then click it
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	public void sendKeys(WebElement element, String text) {
		// Wait for the element to be visible and then send keys (input) to it
		wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
	}

	public String getText(WebElement element) {
		// Wait for the element to be visible and return its text
		return wait.until(ExpectedConditions.visibilityOf(element)).getText();
	}

	public String getElementTextByXPath(String xpath) {
		// Find the element by XPath and return its text
		WebElement element = driver.findElement(By.xpath(xpath));
		return element.getText();
	}

	public List<String> getTextList(List<WebElement> elements) {
		// Wait for all elements to be visible and then get a list of their texts
		return wait.until(ExpectedConditions.visibilityOfAllElements(elements))
				.stream()
				.map(WebElement::getText)
				.toList();
	}

	public void applyPromoCode(WebElement promoCodeInput, WebElement applyPromoCodeButton) {
		// Apply a promo code by sending keys to the input and clicking the button
		sendKeys(promoCodeInput, "PromoCode");
		clickElement(applyPromoCodeButton);
	}

	public void selectDropdownByVisibleText(WebElement dropdownElement, String visibleText) {
		// Wait for the dropdown to be clickable, click it, and select an option by
		// visible text
		wait.until(ExpectedConditions.elementToBeClickable(dropdownElement)).click();
		driver.findElement(By.xpath("//option[contains(text(),'" + visibleText + "')]")).click();
	}

	public void checkCheckbox(WebElement checkboxElement) {
		// Check the checkbox if it is not already checked
		if (!checkboxElement.isSelected()) {
			clickElement(checkboxElement);
		}
	}

	public void uncheckCheckbox(WebElement checkboxElement) {
		// Uncheck the checkbox if it is checked
		if (checkboxElement.isSelected()) {
			clickElement(checkboxElement);
		}
	}

	public void handleAlert() {
		// Switch to an alert and accept it
		driver.switchTo().alert().accept();
	}

	public static String getProperties2() throws Exception {
		// Load properties from a file and return the value of the "url" property
		Properties prop = new Properties();
		String projectpath = System.getProperty("user.dir");
		FileInputStream fp = new FileInputStream(projectpath + "/src/test/resources/config.properties");
		prop.load(fp);
		return prop.getProperty("url");
	}

	// Method to take a screenshot
	public void takeScreenshot(String screenshotPath) {
		try {
			// Take a screenshot and save it to the specified path
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(screenshotPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
