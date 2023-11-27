@SearchBaidu
Feature: Search in Baidu.com

  Scenario: User can do a search from the Baidu home page
    Given a user visiting "https://www.baidu.com/"
    And a user typing "Hello World" in the search input in Baidu
    When presses the search button in Baidu
    Then results are displayed in Baidu