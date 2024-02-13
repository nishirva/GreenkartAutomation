Feature: Add items to the shopping cart on GreenKart website

  Scenario: Add the 10th item to the cart and proceed to checkout
    Given User is on the GreenKart website
    When User selects the 10th item and adds it to the cart
    And User goes to the cart
    And Validate whether the 10th item is present in the cart
    Then User quits the browser
