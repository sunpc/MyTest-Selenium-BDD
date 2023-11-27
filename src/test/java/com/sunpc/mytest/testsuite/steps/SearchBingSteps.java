package com.sunpc.mytest.testsuite.steps;

import com.sunpc.mytest.testsuite.pages.SearchBaiduPage;
import com.sunpc.mytest.testsuite.pages.SearchBingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.MergedAnnotations;

public class SearchBingSteps {

    @Autowired
    private SearchBingPage searchPage;

    @Given("^a user typing \"([^\"]*)\" in the search input in Bing$")
    public void aUserTypingInTheSearchInput(String searchValue) {
        searchPage.inputSearch(searchValue);
    }

    @When("^presses the search button in Bing$")
    public void pressesTheSearchButton() {
        searchPage.pressSearchButton();
    }

    @Then("^results are displayed in Bing$")
    public void resultsAreDisplayed() {
        searchPage.assertResultsArePresent();
    }

}
