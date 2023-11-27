package com.sunpc.mytest.testsuite.pages;

import com.sunpc.mytest.base.BasePage;
import com.sunpc.mytest.helper.VisibilityHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SearchBingPage implements BasePage {

    @Autowired
    private VisibilityHelper visibilityHelper;

    @FindBy(how = How.CSS, using = "#sb_form_q")
    private WebElement searchInput;

    @FindBy(how = How.CSS, using = "#search_icon")
    private WebElement searchButton;

    private static final String RESULTS_LOCATOR = "#b_tween_searchResults";

    public void inputSearch(String search) {
        searchInput.sendKeys(search);
    }

    public void pressSearchButton() {
        searchButton.click();
    }

    public void assertResultsArePresent() {
        visibilityHelper.waitForPresenceOf(By.cssSelector(RESULTS_LOCATOR));
    }
}