@WebUI @Page:SearchBaiduPage
Feature: Search in Baidu.com

  Scenario: User can do a search from the Baidu home page
    Given a user visits "https://www.baidu.com/"
    And a user types "Hello World" in the "searchInput"
    When clicks the "searchButton" button
    Then results are displayed in "resultSpan"