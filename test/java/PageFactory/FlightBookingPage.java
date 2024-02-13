package PageFactory;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Generic.Generic_method;

public class FlightBookingPage {

    private WebDriver driver;
    private Generic_method generic;

    // Constructor
    public FlightBookingPage(WebDriver driver) {
        this.driver = driver;
        this.generic = new Generic_method(driver);
        PageFactory.initElements(driver, this);
    }

    // WebElement for destination input
    @FindBy(xpath = "//input[@id='autosuggest']")
    private WebElement destinationInput;

    // WebElement for round trip radio button
    @FindBy(xpath = "//label[contains(text(),'Round Trip')]")
    private WebElement roundTripRadioButton;

    // WebElement for departure city input
    @FindBy(id = "ctl00_mainContent_ddl_originStation1_CTXT")
    private WebElement departureCityInput;

    // WebElement for Goa airport option
    @FindBy(xpath = "//a[contains(text(),'Goa (GOI)')]")
    private WebElement goaAirportOption;

    // WebElement for destination city input
    @FindBy(xpath = "(//*[@id=\"ctl00_mainContent_ddl_destinationStation1_CTXT\"])[1]")
    private WebElement destinationCityInput;

    // WebElement for Chennai airport option
    @FindBy(xpath = "//a[@value=\"MAA\"]")
    private WebElement chennaiAirportOption;

    // WebElement for departure date
    @FindBy(xpath = "//a[contains(text(),'30')]")
    private WebElement departureDate;

    // WebElement for return date button
    @FindBy(xpath = "//*[@id=\"Div1\"]/button")
    private WebElement returnDateButton;

    // WebElement for return date
    @FindBy(xpath = "//a[contains(text(),'31')]")
    private WebElement returnDate;

    // WebElement for passengers dropdown
    @FindBy(id = "divpaxinfo")
    private WebElement passengersDropdown;

    // WebElement for increase adult passenger
    @FindBy(id = "hrefIncAdt")
    private WebElement increaseAdultPassenger;

    // WebElement for increase child passenger
    @FindBy(id = "hrefIncChd")
    private WebElement increaseChildPassenger;

    // WebElement for increase infant passenger
    @FindBy(id = "hrefIncInf")
    private WebElement increaseInfantPassenger;

    // WebElement for close passenger options button
    @FindBy(xpath = "//input[@id='btnclosepaxoption']")
    private WebElement closePassengerOptionsButton;

    // WebElement for currency dropdown
    @FindBy(id = "ctl00_mainContent_DropDownListCurrency")
    private WebElement currencyDropdown;

    // WebElement for friends and family checkbox
    @FindBy(css = "#ctl00_mainContent_chk_friendsandfamily")
    private WebElement friendsAndFamilyCheckbox;

    // WebElement for search button
    @FindBy(xpath = "//input[@name='ctl00$mainContent$btn_FindFlights']")
    private WebElement searchButton;

    // WebElement for alert box checkbox
    @FindBy(name = "alertbox")
    private WebElement alertBoxCheckbox;

   
    // Method to enter destination
    public void enterDestination(String destination) {
       generic.sendKeys(destinationInput, destination);
    }

    // Method to select round trip
    public void selectRoundTrip() {
        generic.clickElement(roundTripRadioButton);
    }

   
    public void SelectdepartureCity() {
    	generic.clickElement(departureCityInput);
    	generic.clickElement(goaAirportOption);
    }
    public void SelectdestinationCity() throws InterruptedException {
    	generic.wait();
    	generic.clickElement(chennaiAirportOption);
    }
    
    // Method to select departure date
    public void selectDepartureDate() {
        generic.clickElement(departureDate);
    }

    // Method to select return date
    public void selectReturnDate() {
        generic.clickElement(returnDateButton);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        generic.clickElement(returnDate);
    }

    // Method to select passengers
    public void selectPassengers(int adults, int children, int infants) {
        generic.clickElement(passengersDropdown);

        for (int i = 1; i <= adults; i++) {
            generic.clickElement(increaseAdultPassenger);
        }

        for (int j = 1; j <= children; j++) {
            generic.clickElement(increaseChildPassenger);
        }

        for (int k = 1; k <= infants; k++) {
            generic.clickElement(increaseInfantPassenger);
        }

        generic.clickElement(closePassengerOptionsButton);
    }

    // Method to select currency by index
    public void selectCurrency(int index) {
        Select currencySelect = new Select(currencyDropdown);
        currencySelect.selectByIndex(index);
    }

    // Method to select friends and family checkbox
    public void selectFriendsAndFamily() {
        generic.clickElement(friendsAndFamilyCheckbox);
    }

    // Method to click search button
    public void clickSearchButton() {
        generic.clickElement(searchButton);
    }

    // Method to handle alert by clicking alert box checkbox
    public void handleAlert() {
        generic.clickElement(alertBoxCheckbox);
    }
}
