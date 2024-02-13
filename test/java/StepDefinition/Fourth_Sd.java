package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic.Generic_method;
import PageFactory.CheckoutPage;
import PageFactory.ProductPage;
import PageFactory.ShoppingCartPage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeoutException;

import static org.junit.Assert.assertTrue;

public class Fourth_Sd {

    private WebDriver driver;
    private CheckoutPage checkoutPage;
    ProductPage productPage;
    ShoppingCartPage shoppingCartPage;


    // Step 1: Open the GreenKart website
    @Given("In the GreenKart website")
    public void InTheGreenKartWebsite() throws Exception {
       
        
        // Initialize ChromeDriver and maximize the window
        driver = new ChromeDriver();
        checkoutPage = new CheckoutPage(driver);
        driver.get(Generic_method.getProperties2());
        Generic_method.maximizeWindow();
        // Reusable ProductPage instance
        productPage = new ProductPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
    }

    // Step 2: User adds multiple items to cart
    @When("User adds multiple items to cart")
    public void userAddsMultipleItemsToCart() throws InterruptedException {
        // Loop to click buttons for adding items to the cart
        for (int i = 1; i <= 8; i++) {
            String xpath = "//*[@id=\"root\"]/div/div[1]/div/div[" + i + "]/div[3]/button";
            driver.findElement(By.xpath(xpath)).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        // Validate items in cart and on the home page
        List<String> itemsInCart = checkoutPage.getItemsInCart();
        List<String> itemsOnHomePage = checkoutPage.getItemsOnHomePage();
        // Utility method to validate items in cart and on the home page
        Generic_method generic = new Generic_method(driver);
        generic.validateItemsInCartAndHomePage(itemsInCart, itemsOnHomePage);

    }

    // Step 3: Open the cart
    @And("opens cart")
    public void opens_cart() throws InterruptedException {
    	// Utilize the reusable productPage instance to open the cart
    	productPage.openCart();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // Step 4: User removes the 3rd and 6th items from the cart
    @And("User removes the 3rd and 6th items from the cart")
    public void userRemovesItemsFromTheCart() throws InterruptedException {
        checkoutPage.remove6thItem();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	// Utilize the reusable shoppingCartPage instance to open the cart
        shoppingCartPage.remove3rdItem();

    }

    // Step 5: User proceeds to checkout
    @And("User proceeds checkout")
    public void userProceedsCheckout() throws InterruptedException {
    	// Utilize the reusable shoppingCartPage instance to proceeds to checkout
    	shoppingCartPage.proceedToCheckout();
        Thread.sleep(2000);
    }

    // Step 6: User places the order with delivery details
    @And("User places the order with delivery details")
    public void userPlacesTheOrderWithDeliveryDetails() {
        checkoutPage.placeOrder();
        checkoutPage.selectDeliveryLocation("India");
        checkoutPage.agreeToTerms();
        checkoutPage.proceedToOrder();

         }

    // Step 7: User verifies the order placement success message
    @Then("User verifies the order placement success message")
    public void userVerifiesTheOrderPlacementSuccessMessage() throws TimeoutException, IOException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Capture a screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("C:\\Users\\SREEPM\\eclipse-workspace\\first\\.metadata\\Automation\\Screenshots\\scrn2.png"));

        // Get the success message element and print its text
        WebElement element = driver.findElement(By.xpath("//div[@class='wrapperTwo']"));
        System.out.println(element.getText());

        // Capture another screenshot
        FileUtils.copyFile(screenshot, new File("C:\\Users\\SREEPM\\eclipse-workspace\\first\\.metadata\\Automation\\Screenshots\\scrn3.png"));

        // Assert the text content
        assertTrue(element.getText().contains("Thank you, your order has been placed successfully"));
    }

    // Step 8: Quit the browser
    @Then("quits browser")
    public void quits_browser() throws InterruptedException {
        driver.quit();
    }
   }


