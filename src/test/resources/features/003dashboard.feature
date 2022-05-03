Feature: Title of your feature

  Scenario Outline: Validate dashboard page
    Given user is on login page
    When user has provided invalid "<email>" with valid "<password>"
    Then user is on dashboard page

    Examples: 
      | email                | password |
      | GTERZTBZJP@gmail.com | ppLN94^& |
