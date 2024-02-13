Feature: Book a flight on the travel website

  Scenario: Select destination, date, passengers, and search for flights
    Given User is on the travel website
    When User enters the destination "India"
    And User selects the round trip option
    And User selects the departure city and destination city
    And User selects the departure and return date
    And User selects the number of passengers (1 adult, 1 child, 1 infant)
    And User selects the currency
    And User selects "Friends and Family" option
    And User clicks on the search button
    Then User handles the alert
    And User quits
    