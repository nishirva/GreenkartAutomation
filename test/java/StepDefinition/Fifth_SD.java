package StepDefinition;

import io.cucumber.java.en.*;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic.Generic_method;
import PageFactory.FlightBookingPage;

public class Fifth_SD {

    WebDriver driver;
    FlightBookingPage flightBookingPage;


    // Setting up WebDriver and navigating to the travel website
    @Given("User is on the travel website")
    public void user_is_on_the_travel_website() throws Exception {
        
        driver = new ChromeDriver();
        flightBookingPage = new FlightBookingPage(driver); // Initialize the FlightBookingPage
        driver.get(Generic_method.getProperties2());
        Generic_method.maximizeWindow();
       
        
        driver.navigate().to("https://rahulshettyacademy.com/dropdownsPractise/");
        Generic_method.maximizeWindow();
        // Adding implicit wait
     //   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    // Entering the destination and waiting for it
    @When("User enters the destination {string}")
    public void user_enters_the_destination(String destination) {
        flightBookingPage.enterDestination(destination);
    }

    // Selecting the round trip option and waiting for it
    @When("User selects the round trip option")
    public void user_selects_the_round_trip_option() {
        flightBookingPage.selectRoundTrip();
    }

    // Selecting departure and destination cities
    @When("User selects the departure city and destination city")
    public void user_selects_the_departure_city_and_destination_city() throws InterruptedException {
    	
    	//flightBookingPage.SelectdepartureCity();
       driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Goa (GOI)')]")).click();
        // Arrival City
    	//flightBookingPage.SelectdestinationCity();
       driver.findElement(By.xpath("(//*[@id=\"ctl00_mainContent_ddl_destinationStation1_CTXT\"])[1]")).click();
       driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
    }

    // Selecting departure and return dates
    @When("User selects the departure and return date")
    public void user_selects_the_departure_and_return_date() {
        flightBookingPage.selectDepartureDate();
        flightBookingPage.selectReturnDate();
    }

    // Selecting the number of passengers
    @When("User selects the number of passengers \\({int} adult, {int} child, {int} infant)")
    public void user_selects_the_number_of_passengers_adult_child_infant(Integer adult, Integer child, Integer infant) {
        flightBookingPage.selectPassengers(adult, child, infant);
    }

    

    // Selecting the currency
    @When("User selects the currency")
    public void user_selects_the_currency() {
        flightBookingPage.selectCurrency(1);
    }

    // Selecting a specific option
    @When("User selects {string} option")
    public void user_selects_option(String option) {
        flightBookingPage.selectFriendsAndFamily();
    }

    // Clicking on the search button
    @When("User clicks on the search button")
    public void user_clicks_on_the_search_button() {
        flightBookingPage.clickSearchButton();
    }

    // Handling the alert
    @Then("User handles the alert")
    public void user_handles_the_alert() {
        try {
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert Text: " + alert.getText());
            alert.accept();
            System.out.println("Alert accepted");
        } catch (NoAlertPresentException e) {
            System.out.println("No alert present");
        }
    }

    // Quitting the browser
    @And("User quits")
    public void user_quits() {
        driver.quit();
    }
}
