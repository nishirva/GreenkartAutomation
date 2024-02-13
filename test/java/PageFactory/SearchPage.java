package PageFactory;

import Generic.Generic_method;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    
   @SuppressWarnings("unused")
private WebDriver driver;  // WebDriver instance
    private Generic_method generic;  // Generic_method instance for common methods

    // Constructor
    public SearchPage(WebDriver driver) {
        this.driver = driver;  // Initializing WebDriver
        this.generic = new Generic_method(driver);  // Initializing Generic_method
        PageFactory.initElements(driver, this);  // Initializing the Page Factory
    }

    // Web Elements with FindBy annotations

    @FindBy(xpath = "//input[@placeholder=\"Search for Vegetables and Fruits\"]")
    private WebElement searchInput;

    @FindBy(xpath = "//button[contains(text(),'ADD TO CART')]")
    private WebElement addToCart;

    @FindBy(xpath = "//img[@alt=\"Cart\"]")
    private WebElement goToCart;

    @FindBy(xpath = "//ul/li/div[1]/p[1]")
    private WebElement cartItemElement;

    @FindBy(xpath = "//header//ul/li/div[2]/p[2]") //header//ul/li/div[2]/p[2]
    private WebElement priceElement;

    // Methods for interacting with the page elements

    // Method to search for a product.
    
    // @param productName The name of the product to search for.
     
    public void searchForProduct(String productName) {
        searchInput.sendKeys(productName);
    }

    
    // Method to click the "ADD TO CART" button.
     
    public void addToCart() {
        generic.clickElement(addToCart);
    }

    
    // Method to click the "Go To Cart" button.
   
    public void goToCart() {
        generic.clickElement(goToCart);
    }

    
    // Method to get the text of the cart item.
     
    //@return The text of the cart item.
     
    public String getCartItemText() {
        return generic.getElementTextByXPath("//ul/li/div[1]/p[1]");
    }

    
     // Method to get the text of the price element.
     
     //@return The text of the price element.
     
    public String getPriceText() {
        return generic.getElementTextByXPath("//header//ul/li/div[2]/p[2]");
    }
}
