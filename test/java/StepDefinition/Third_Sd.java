package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import PageFactory.ProductPage;
import PageFactory.ShoppingCartPage;


import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import Generic.Generic_method;

public class Third_Sd {

    // WebDriver instance
    WebDriver driver;
    @SuppressWarnings("unused")
	private Generic_method generic;
    

    // Page Object instance for ShoppingCartPage and ProductPage
    ShoppingCartPage shoppingCartPage;
    ProductPage productPage;


    // Constructor
    public Third_Sd() throws Exception {
        // Initialize system properties
    	 driver = new ChromeDriver();
    	 this. generic = new Generic_method(driver);
         driver.get(Generic_method.getProperties2());
         Generic_method.maximizeWindow();
        

        // Initialize Page Object
        shoppingCartPage = new ShoppingCartPage(driver);
        // Reusable ProductPage instance
        productPage = new ProductPage(driver);
                   //   new Generic_method(driver);
    }

    // Step 1: Open the GreenKart website
    @Given("User on GreenKart website")
    public void userOnGreenKartWebsite() throws Exception {
        driver.get(Generic_method.getProperties2());
    }

    // Step 2: User adds multiple items to the cart
    @When("User adds multiple items to the cart")
    public void userAddsMultipleItemsToTheCart() throws InterruptedException {
        // Loop to add multiple items to the cart
        for (int i = 1; i <= 4; i++) {
            String xpath = "//*[@id=\"root\"]/div/div[1]/div/div[" + i + "]/div[3]/button";
            driver.findElement(By.xpath(xpath)).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        // Get items in the cart and on the home page
        List<String> itemsInCart = shoppingCartPage.getItemsInCart();
        List<String> itemsOnHomePage = shoppingCartPage.getItemsOnHomePage();

        // Validate items in the cart and on the home page
        Generic_method generic = new Generic_method(driver);
        generic.validateItemsInCartAndHomePage(itemsInCart, itemsOnHomePage);
    }

    
   
    // Step 3: User opens the cart
    @And("User opens the cart")
    public void userOpensTheCart() {
        // Utilize the reusable productPage instance to open the cart
    	productPage.openCart();
    }

    // Step 4: User removes the 3rd item from the cart
    @When("User remove the 3rd item from the cart")
    public void user_remove_the_3rd_item_from_the_cart() {
        shoppingCartPage.remove3rdItem();
    }

    // Step 5: User proceeds to checkout
    @And("User proceeds to checkout")
    public void userProceedsToCheckout() throws InterruptedException {
        shoppingCartPage.proceedToCheckout();
        Thread.sleep(2000);
    }

    // Step 6: User applies a promo code
    private WebElement waitForElement(By locator, Duration timeout) {
        return new FluentWait<>(driver)
                .withTimeout(timeout)
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(TimeoutException.class)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    // Step 6: User applies a promo code
    @And("User applies a promo code")
    public void userAppliesAPromoCode() throws InterruptedException, TimeoutException {
        shoppingCartPage.applyemptyPromoCode();

        // Wait for the promo code input element to be clickable
        By promoCodeInputLocator = By.xpath("//input[@class='promoCode']");
        WebElement promoCodeInput = waitForElement(promoCodeInputLocator, Duration.ofSeconds(10));

        // Enter the promo code
        promoCodeInput.sendKeys("12345678");

        // Click the promo code apply button
        driver.findElement(By.xpath("//button[@class='promoBtn']")).click();

        // Wait for the "Invalid code ..!" message to appear
        WebElement invalidCodeMessage = waitForElement(By.xpath("//span[contains(text(),'Invalid code ..!')]"), Duration.ofSeconds(10));
        System.out.println(invalidCodeMessage.getText());

        // Clear the promo code input
        promoCodeInput.clear();

        // Enter a valid promo code
        promoCodeInput.sendKeys("rahulshettyacademy");

        // Click the promo code apply button
        driver.findElement(By.xpath("//button[@class='promoBtn']")).click();

        // Wait for the "Code applied ..!" message to appear
        WebElement appliedCodeMessage = waitForElement(By.xpath("//span[contains(text(),'Code applied ..!')]"), Duration.ofSeconds(10));
        System.out.println(appliedCodeMessage.getText());
    }

    // Step 7: User quits browser
    @Then("User quits browser")
    public void userQuitsBrowser() {
        // Quit the browser
        driver.quit();
        System.out.println("Browser Quit Successfully");
    }
}
