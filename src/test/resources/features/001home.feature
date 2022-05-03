Feature: Home Feature

  Scenario: Verify home page title
    Given user is on home page
    Then home page title should be valid

  Scenario: Verify my account link is working or not
    Given user is on home page
    When user clicks on my account link
    Then login page should be displayed