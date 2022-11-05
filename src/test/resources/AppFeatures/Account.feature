@Smoke
Feature: Account Page Functionalities

  Scenario: Verify tooltips available in Navigation Area
    Given: User is logged in application
    And User is on My Account page
    When user hover over all Navigation items
    Then tool tips appears for all navigation items
    And tool tips text for all navigation items should be correct
    | Edit account details |
    | Change password |
    | Manage Address Book |
    | My wish list |
    | Order history |
    | Transaction history |
    | Downloads |
    | Notifications |
    | Logoff |