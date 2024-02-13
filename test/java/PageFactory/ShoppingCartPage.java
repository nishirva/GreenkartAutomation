package PageFactory;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.Generic_method;

public class ShoppingCartPage {

	// WebDriver instance
	WebDriver driver;

	// Generic_method instance for common methods
	Generic_method generic;

	// Constructor
	public ShoppingCartPage(WebDriver driver) {
		// Initialize driver and Generic_method
		this.driver = driver;
		this.generic = new Generic_method(driver);

		// Initialize page elements using PageFactory
		PageFactory.initElements(driver, this);
	}

	// Web Elements with FindBy annotations

	

	@FindBy(xpath = "//header//ul/li[3]/a")
	private WebElement remove3rdItemButton;

	@FindBy(xpath = "//button[contains(text(),'PROCEED TO CHECKOUT')]")
	private WebElement proceedToCheckoutButton;

	@FindBy(xpath = "//span[contains(text(),'Empty code ..!')]")
	private WebElement Emptycode;

	@FindBy(xpath = "//span[contains(text(),'Invalid code ..!')]")
	private WebElement Invalidcode;

	@FindBy(xpath = "//span[contains(text(),'Code applied ..!')]")
	private WebElement codeapplied;

	@FindBy(xpath = "//button[@class='promoBtn']")
	private WebElement applyPromoCodeButton;

	@FindBy(xpath = "//input[@class='promoCode']")
	private WebElement promoCodeInput;

	// Methods for interacting with the page elements

	
	
	// Remove the 3rd item from the cart
	public void remove3rdItem() {
		generic.clickElement(remove3rdItemButton);
	}

	// Proceed to the checkout page
	public void proceedToCheckout() {
		generic.clickElement(proceedToCheckoutButton);
	}

	// Apply an empty promo code and print the result
	public void applyemptyPromoCode() throws InterruptedException {
		generic.clickElement(applyPromoCodeButton);
		System.out.println(Emptycode.getText());
		Thread.sleep(2000);
	}

	// Apply an invalid promo code and print the result
	public void applyinvalidPromoCode() throws InterruptedException {
		promoCodeInput.sendKeys("123456");
		generic.clickElement(applyPromoCodeButton);
		System.out.println(Invalidcode.getText());
		Thread.sleep(2000);
	}

	// Apply a valid promo code and print the result
	public void applyvalidPromoCode() throws InterruptedException {
		promoCodeInput.clear();
		Thread.sleep(1000);
		promoCodeInput.sendKeys("rahulshettyacademy");
		generic.clickElement(applyPromoCodeButton);
		System.out.println(codeapplied.getText());
		Thread.sleep(1000);
	}

	// Methods to get lists of items on the home page and in the cart

	// Get a list of items on the home page
	public List<String> getItemsOnHomePage() {
		// List of items on the home page
		List<String> itemsOnHomePage = Arrays.asList("Broccoli", "Cauliflower", "Beetroot");
		return itemsOnHomePage;
	}

	// Get a list of items in the cart
	public List<String> getItemsInCart() {
		// List of items in the cart
		List<String> itemsInCart = Arrays.asList("Broccoli", "Cauliflower", "Beetroot");
		return itemsInCart;
	}
}
