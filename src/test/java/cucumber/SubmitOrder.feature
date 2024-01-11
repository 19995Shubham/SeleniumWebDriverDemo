@tag 
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file



Background:

Given I landed on Ecommerce Page

  @web
  Scenario Outline: Postive Test of Submitting the order
    Given Logged in with username <name> and password <password>
    When I add product <productName> to cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is display on confirmationPage

    Examples: 
      | name                  | password    | productName |
      | stripathia8@gmail.com | Shubham@123456789 | ZARA COAT 3 |


  @mobile
  Scenario Outline: Postive Test of Submitting the order
    Given Logged in with username <name> and password <password>
    When I add product <productName> to cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is display on confirmationPage

    Examples:
      | name                  | password    | productName |
      | stripathia8@gmail.com | Shubham@123456789 | ZARA COAT 3 |