package com.sunpc.mytest.pages;

import com.sunpc.mytest.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

@Component
public class SearchBaiduPage extends BasePage {

    @FindBy(how = How.CSS, using = "#kw")
    private WebElement searchInput;

    @FindBy(how = How.CSS, using = "#su")
    private WebElement searchButton;

    @FindBy(how = How.CSS, using = "#tsn_inner > div:nth-child(2) > span")
    private WebElement resultSpan;

}