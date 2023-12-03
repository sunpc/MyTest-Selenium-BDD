package com.sunpc.mytest.helper;

import static org.openqa.selenium.support.PageFactory.initElements;

import com.sunpc.mytest.annotation.MyTestPage;
import com.sunpc.mytest.base.BasePage;
import com.sunpc.mytest.runner.Hooks;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.util.List;

public class StepHelper {

    /**
     * Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(StepHelper.class);

    @Autowired
    private Hooks hooks;

    @Autowired
    private List<BasePage> pages;

    @Autowired
    private PageHelper pageHelper;

    @Before(order = 1)
    public void logBeforeScenario(final Scenario scenario) {
        LOGGER.debug(StringUtils.rightPad("Starting scenario:", 20) + "[{}] - [{}]",
                getFeatureName(scenario),
                scenario.getName());
    }

    @Before(value = "@WebUI", order = 2)
    public void initializeDriver(final Scenario scenario) {
        final WebDriver driver = hooks.getDriver();

        // Initialize page elements
        pages.forEach(p -> {
            if (p.getClass().isAnnotationPresent(MyTestPage.class)
                    && (p.getClass().getAnnotation(MyTestPage.class).value().equals(getPageName(scenario))
                    || (p.getClass().getAnnotation(MyTestPage.class).value().isEmpty()
                    && p.getClass().getSimpleName().equals(getPageName(scenario))))) {
                initElements(driver, p);
                pageHelper.setPage(p);
            }
        });
        // --
    }

    @After(value = "@WebUI", order = 1)
    public void closeDriver(final Scenario scenario) {
        hooks.tearDown(scenario);
        hooks.closeDriver();
    }

    @After(order = Integer.MAX_VALUE)
    public void logAfterScenario(final Scenario scenario) {
        LOGGER.debug(StringUtils.rightPad("Finished scenario:", 20) + "[{}] - [{}] [{}]",
                getFeatureName(scenario),
                scenario.getName(),
                scenario.getStatus());
    }

    @Given("a user visits {string}")
    public void aUserVisiting(String baseUrl) {
        hooks.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        hooks.getDriver().navigate().to(baseUrl);
    }

    @Given("a user types {string} in the {string}")
    public void aUserTypingInInput(String searchValue, String webElement) throws NoSuchFieldException, IllegalAccessException {
        pageHelper.sendKeys(searchValue, webElement);
    }

    @When("clicks the {string} button")
    public void clickButton(String webElement) throws NoSuchFieldException, IllegalAccessException {
        pageHelper.click(webElement);
    }

    @Then("results are displayed in {string}")
    public void resultsAreDisplayed(String webElement) throws NoSuchFieldException, IllegalAccessException {
        pageHelper.assertWebElementPresent(webElement);
    }

    private String getFeatureName(Scenario scenario) {
        String featureName = scenario.getUri().toString();

        featureName = StringUtils.substringBeforeLast(featureName, ".feature");
        featureName = StringUtils.substringAfterLast(featureName, "/");

        return featureName;
    }

    private String getPageName(Scenario scenario) {
        String keyword = "Page";

        for (String tag : scenario.getSourceTagNames()) {
            if (tag.startsWith("@" + keyword + ":")) {
                return StringUtils.substringAfterLast(tag, ":");
            }
        }

        return getFeatureName(scenario);
    }

}
