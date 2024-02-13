Feature: Add and remove items, proceed to checkout, and verify order placement on GreenKart website

  Scenario: Add and remove items, proceed to checkout, and verify order placement
    Given In the GreenKart website
    When User adds multiple items to cart
    And opens cart
    And User removes the 3rd and 6th items from the cart
    And User proceeds checkout
    And User places the order with delivery details
    Then User verifies the order placement success message
    And quits browser
