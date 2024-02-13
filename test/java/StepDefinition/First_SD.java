package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic.Generic_method;
import PageFactory.ProductPage;

public class First_SD {

    private WebDriver driver;
    private ProductPage productPage;
	 Generic_method generic;

    // Step 1: User is on the GreenKart website
    @SuppressWarnings("deprecation")
	@Given("User is on the GreenKart website")
    public void userIsOnTheGreenKartWebsite() throws Exception {

        // Initialize ChromeDriver and maximize the window
        driver = new ChromeDriver();
       this. generic = new Generic_method(driver);
        driver.get(Generic_method.getProperties2());
        Generic_method.maximizeWindow();
        // Initialize Page Object
        productPage = new ProductPage(driver);
     // Set implicit wait to 10 seconds
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    // Step 2: User selects the 10th item and adds it to the cart
    @When("User selects the 10th item and adds it to the cart")
    public void userSelectsThe10thItemAndAddsItToTheCart() throws InterruptedException {
        productPage.clickAddToCartButton();
        
    }

    // Step 3: User goes to the cart
    @And("User goes to the cart")
    public void userGoesToTheCart() throws InterruptedException {
        productPage.openCart();
        
    }

    // Step 4: Validate whether the 10th item is present in the cart
    @And("Validate whether the 10th item is present in the cart")
    public void validateWhetherThe10thItemIsPresentInTheCart() {
        String expectedText = "Mushroom - 1 Kg";
        String actualText = productPage.getCartItemText();

        Assert.assertEquals("The selected item is not present in the cart", expectedText, actualText);

        System.out.println("Assertion passed successfully!");
    }

    // Step 5: User quits the browser
    @Then("User quits the browser")
    public void userQuitsTheBrowser() {
        driver.quit();
    }
}
