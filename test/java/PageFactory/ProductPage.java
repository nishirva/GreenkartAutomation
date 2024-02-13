package PageFactory;

import Generic.Generic_method;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	private WebDriver driver;
	private Generic_method generic;

	// Constructor
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		this.generic = new Generic_method(driver);
		PageFactory.initElements(driver, this);
	}

	// Web Elements with FindBy annotations

	@FindBy(css = "div.products div.product:nth-child(10) button")
	private WebElement addToCartButton;

	@FindBy(xpath = "//header/div[1]/div[3]/a[4]/img[1]")
	private WebElement opencart;

	@FindBy(xpath = "//div[@id='root']//ul/li/div[1]/p[1]")
	private WebElement checkTheProduct;

	// Methods for interacting with the page elements


	// Clicks the "Add to Cart" button.

	public void clickAddToCartButton() {
		generic.clickElement(addToCartButton);
	}


	// Clicks the "Open Cart" button.

	public void openCart() {
		generic.clickElement(opencart);
	}


	// Retrieves the text of the checked product in the cart.

	// @return The text of the checked product.

	public String getCartItemText() {
		WebElement checkTheProduct = driver.findElement(By.xpath("//div[@id='root']//ul/li/div[1]/p[1]"));
		return checkTheProduct.getText();
	}
}
