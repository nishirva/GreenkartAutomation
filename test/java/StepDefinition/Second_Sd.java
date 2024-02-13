package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic.Generic_method;
import PageFactory.ProductPage;
import PageFactory.SearchPage;

public class Second_Sd {

    private WebDriver driver;
    private SearchPage searchPage;
    private ProductPage productPage;
    private Generic_method generic;

    // Step 1: User on GreenKart website
    @Given("User  in  GreenKart website")
    public void user_in_green_kart_website() throws Exception {
       
        // Initialize ChromeDriver and maximize the window
        driver = new ChromeDriver();
        this. generic = new Generic_method(driver);
        driver.get(Generic_method.getProperties2());
        Generic_method.maximizeWindow();

        // Initialize Page Object
        searchPage = new SearchPage(driver);
        // Reusable ProductPage instance
        productPage = new ProductPage(driver);

    }

    // Step 2: User searches for the product
    @When("User searches for the product {string}")
    public void userSearchesForTheProduct(String productName) {
        searchPage.searchForProduct(productName);
    }

    // Step 3: User increases the quantity
    @And("User increases the quantity by {int}")
    public void userIncreasesTheQuantityBy(int count) throws InterruptedException {
        increaseQuantity(driver, 3);
    }

    // Step 4: User adds the product to the cart
    @And("User adds the product to the cart")
    public void userAddsTheProductToTheCart() {
        searchPage.addToCart();
    }

    // Step 5: User goes to the cart
    @And("User goes to cart")
    public void userGoesToCart() throws InterruptedException {
        // Utilized the reusable productPage instance to open the cart
    	productPage.openCart();
        Thread.sleep(1000);
    }

    // Step 6: Validate whether selected Item is present in the cart
    @And("Validate whether selected Item is present in the cart")
    public void validate_whether_selected_item_is_present_in_the_cart() {
        // Validate the selected item in the cart
        String expectedText = "Apple - 1 Kg";
        String actualText = searchPage.getCartItemText();
        Assert.assertEquals("The selected item is not present in the cart", expectedText, actualText);

        // Validate the price calculation
        double actualPrice = Double.parseDouble(searchPage.getPriceText().replaceAll("[^\\d.]", ""));
        int quantity = 3;
        double expectedPrice = 72 * quantity;
        Assert.assertEquals("Price calculation is incorrect", expectedPrice, actualPrice, 0.01);

        System.out.println("Assertions passed successfully!");
    }

    // Step 7: User quits browser
    @Then("User quits_browser")
    public void userQuits_Browser() {
        driver.quit();
        System.out.println("Browser Quit Successfully");
    }

    // Utility method to increase quantity
    private void increaseQuantity(WebDriver driver, int count) throws InterruptedException {
        for (int i = 1; i <= 3; i++) {
            driver.findElement(By.xpath("//a[contains(text(),'+')]")).click();
            Thread.sleep(2000);
        }
    }
}
