Feature: Login page feature



  @skip_scenario
  Scenario: Login page title
    Given user navigates to Home Page
    When user click on Login Page Url
    Then Login page is displayed
    When user gets the title of the page
    Then page title should be "Account Login1"


    Scenario: Login with valid user account
      Given user navigates to Home Page
      When user click on Login Page Url
      Then Login page is displayed
      When user navigate to Returning Customer
      And user enters username as "testuser.1"
      And user enters password as "TestPassword1"
      And user clicks login button
      Then User sees an error message



