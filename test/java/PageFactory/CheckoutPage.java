package PageFactory;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.Generic_method;

public class CheckoutPage {

	private WebDriver driver;
	Generic_method generic;

	// Constructor
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		this.generic = new Generic_method(driver);
		PageFactory.initElements(driver, this);
	}

	// WebElement to remove the 6th item
	@FindBy(xpath = "//header//ul/li[6]/a")
	private WebElement remove6thItemButton;

	// WebElement to proceed to checkout
	@FindBy(xpath = "//button[contains(text(),'PROCEED TO CHECKOUT')]")
	private WebElement proceedToCheckoutButton;

	// WebElement to place the order
	@FindBy(xpath = "//button[contains(text(),'Place Order')]")
	private WebElement placeOrderButton;

	// WebElement for delivery location dropdown
	@FindBy(xpath = "//body/div[@id='root']//select[1]")
	private WebElement deliveryLocationDropdown;

	// WebElement for agreeing to terms checkbox
	@FindBy(xpath = "//input[@class='chkAgree']")
	private WebElement agreeCheckbox;

	// WebElement to proceed to order
	@FindBy(xpath = "//button[contains(text(),'Proceed')]")
	private WebElement proceedButton;

	// WebElement for order placement message
	@FindBy(xpath = "//div[@class='wrapperThree']")
	private WebElement orderPlacementMessage;

	// Methods to interact with the cart

	// Clicks on the remove 6th item button
	public void remove6thItem() {
		generic.clickElement(remove6thItemButton);
	}

	// Clicks on the proceed to checkout button
	public void proceedToCheckout() {
		generic.clickElement(proceedToCheckoutButton);
	}

	// Clicks on the place order button
	public void placeOrder() {
		generic.clickElement(placeOrderButton);
	}

	// Methods for order placement
	// Selects the delivery location from the dropdown
	public void selectDeliveryLocation(String location) {
		generic.selectDropdownByVisibleText(deliveryLocationDropdown, location);
		driver.findElement(By.xpath("//option[contains(text(),'" + location + "')]")).click();
	}

	// Checks the agree to terms checkbox
	public void agreeToTerms() {
		generic.checkCheckbox(agreeCheckbox);
	}

	// Clicks on the proceed button to complete the order
	public void proceedToOrder() {
		generic.clickElement(proceedButton);
	}

	// Gets the order placement success message
	public String getOrderPlacementMessage() {
		return generic.getText(orderPlacementMessage);
	}

	// Methods to get items on the home page and in the cart
	// Returns a list of items on the home page
	public List<String> getItemsOnHomePage() {
		// List of items on the home page
		List<String> itemsOnHomePage = Arrays.asList("Broccoli", "Cauliflower", "Cucumber", "Beetroot", "Carrot",
				"Tomato", "Beans", "Brinjal");

		return itemsOnHomePage;
	}

	// Returns a list of items in the cart
	public List<String> getItemsInCart() {
		// List of items in the cart
		List<String> itemsInCart = Arrays.asList("Broccoli", "Cauliflower", "Cucumber", "Beetroot", "Carrot", "Tomato",
				"Beans", "Brinjal");

		return itemsInCart;
	}
}
