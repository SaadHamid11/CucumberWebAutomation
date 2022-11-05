
Feature: Contact us form Feature
  Scenario Outline: Fill out Contact us form with relevant data
    Given User navigates to Contact us Page
    When user enters data from "<Name>" ,"<Email>", "<EnquiryText>"
    And submit the form
    Then user gets the message as "Your enquiry has been successfully sent to the store owner!"

    Examples:
      | Name | Email | EnquiryText |
      | TestName1 | Test1@test.com | This is sample enquiry Text1  |
      | TestName2 | Test2@test.com | This is sample enquiry Text 2 |