package com.sunpc.mytest.pages;

import com.sunpc.mytest.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

@Component
public class SearchBingPage extends BasePage {

    @FindBy(how = How.CSS, using = "#sb_form_q")
    private WebElement searchInput;

    @FindBy(how = How.CSS, using = "#search_icon")
    private WebElement searchButton;

    @FindBy(how = How.CSS, using = "#b_tween_searchResults")
    private WebElement resultSpan;

}