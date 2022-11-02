Feature: Validate signin functionality

  @regression
  Scenario Outline: Check signin is not working with invalid credential
    Given browser is opened
    And I am on amazon welcome page
    And I click on Hello-signin partial link
    When I enter valid <email>
    And I click on continue button
    And enters invalid <password>
    Then click on sign-in button
    And I must get an error message

    Examples: 
      | email              | password  |
      | ntwano14@gmail.com | admin1234 |

  @regression
  Scenario Outline: Check signin is successful with valid credential
    Given browser is open
    And user on amazon welcome page
    And clicks on Hello-signin hyper link
    When user enters <emailOrPhoneNumber>
    And clicks on continue button
    And enters valid <password>
    Then clicks on sign-in button
    And user is navigated to home page

    Examples: 
      | emailOrPhoneNumber | password  |
      | ntwano14@gmail.com | admin1234 |

