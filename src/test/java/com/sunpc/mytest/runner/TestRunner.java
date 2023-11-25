package com.sunpc.mytest.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        plugin = {"pretty", "html:cucumber-test-results/cucumber-report.html", "json:cucumber-test-results/cucumber-report.json", "junit:cucumber-test-results/cucumber-report.xml"},
        glue = "com.sunpc.mytest",
        tags = "not @wip")
public class TestRunner {

    @AfterClass
    public static void generateReport() {
        CucumberReporting cucumberReporting = new CucumberReporting();
        cucumberReporting.generateCucumberReport();
    }

}
