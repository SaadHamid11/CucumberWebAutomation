Feature: Order Featured Product

  Scenario Outline: Verify selecting a featured product for ordering



    Given  user navigates to home page
    And user is logged in the application
    Then  user verify feature section is visible
    When User select a "<productname>" from featured products
    And user click on view button
    Then product page is displayed
    And product price is displayed
    When user add quantity as <quantity>
    Then total price is multiplied by <quantity>
    When user clicks on Add to cart Button
    Then Shopping cart page is displayed
    And Quantity is displayed as <quantity>
    And total price is displayed correctly
    And product name is displayed correctly
    When user click on Checkout button
      Then Checkout confirmation page is displayed
      When user click on confirm order
      Then order process page is displayed
      And "<message>" is displayed

    Examples:
      |productname| quantity | message |
      | Skinsheen Bronzer Stick          |    2      |  YOUR ORDER HAS BEEN PROCESSED!       |

