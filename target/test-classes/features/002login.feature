Feature: Login Feature

  Scenario: Verify login page title
    Given user is on login page
    Then login page title should be valid

  Scenario Outline: Verify that the user is able to login with valid credentials
    Given user is on login page
    When user has provided valid "<email>" with "<password>"
    And user clicks on login button
    Then user should be able to login

    Examples: 
      | email                | password |
      | GTERZTBZJP@gmail.com | ppLN94^& |

  Scenario Outline: Verify that the user is not able to login with an invalid email and valid password
    Given user is on login page
    When user has provided invalid "<email>" with valid "<password>"
    And user clicks on login button
    Then It should show the validation message for valid email

    Examples: 
      | email                 | password |
      | GTERZTBZJPa@gmail.com | ppLN94^& |

  Scenario Outline: Verify that the user is not able to login with a valid email and invalid password
    Given user is on login page
    When user has provided valid "<email>" with invalid "<password>"
    And user clicks on login button
    Then It should show the validation message for valid password

    Examples: 
      | email                | password  |
      | GTERZTBZJP@gmail.com | ppLN94^&a |

  Scenario Outline: Verify that the user is not able to login with an invalid email and invalid password
    Given user is on login page
    When user has provided invalid "<email>" with invalid "<password>"
    And user clicks on login button
    Then It should show the validation message for valid email with valid password

    Examples: 
      | email                 | password  |
      | GTERZTBZJPa@gmail.com | ppLN94^&a |

  Scenario Outline: Verify that the user is not able to login with a blank email or password
    Given user is on login page
    When user has provided invalid "<email>" with invalid "<password>"
    And user clicks on login button
    Then It should show the validation message for email is required

    Examples: 
      | email | password |
      |       |          |
