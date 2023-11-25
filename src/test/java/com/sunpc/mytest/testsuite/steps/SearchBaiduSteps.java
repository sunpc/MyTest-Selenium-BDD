package com.sunpc.mytest.testsuite.steps;

import com.sunpc.mytest.testsuite.pages.SearchBaiduPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class SearchBaiduSteps {

    @Autowired
    private SearchBaiduPage searchPage;

    @Given("^a user typing \"([^\"]*)\" in the search input$")
    public void aUserTypingInTheSearchInput(String searchValue) {
        searchPage.inputSearch(searchValue);
    }

    @When("^presses the search button$")
    public void pressesTheSearchButton() {
        searchPage.pressSearchButton();
    }

    @Then("^results are displayed$")
    public void resultsAreDisplayed() {
        searchPage.assertResultsArePresent();
    }

}
