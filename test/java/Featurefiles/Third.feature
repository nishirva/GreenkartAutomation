Feature: Add multiple items to the cart, remove an item, and proceed to checkout on GreenKart website

  Scenario: Add multiple items to the cart, remove the 3rd item, and proceed to checkout with promo code
    Given User on GreenKart website
    When User adds multiple items to the cart
    And User opens the cart
    And User remove the 3rd item from the cart
    And User proceeds to checkout
    And User applies a promo code
    Then User quits browser
