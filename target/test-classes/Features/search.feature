Feature: Test search functionality

  @smoke
  Scenario: validate the search functionality
    Given I launched the browser
    When I enter text to be searched in search box
    Then clicks on search button
    And text must be searched

  @smoke
  Scenario: Test search page not working successfully
    Given I opened the browser
    When I enters text in search box
    Then I clicks on search button
    And text must not be searched
