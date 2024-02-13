Feature: Search for a product and add it to the cart on GreenKart website

  Scenario: Search for "Apple" and add it to the cart
    Given User  in  GreenKart website
    When User searches for the product "Apple"
    And User increases the quantity by 2
    And User adds the product to the cart
    And User goes to cart
    And Validate whether selected Item is present in the cart
    Then User quits_browser
