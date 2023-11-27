@SearchBing
Feature: Search in Bing.com

  Scenario: User can do a search from the Baidu home page
    Given a user visiting "https://www.bing.com/"
    And a user typing "Hello World" in the search input in Bing
    When presses the search button in Bing
    Then results are displayed in Bing