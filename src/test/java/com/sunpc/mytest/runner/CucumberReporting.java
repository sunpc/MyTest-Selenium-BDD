package com.sunpc.mytest.runner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.presentation.PresentationMode;
import net.masterthought.cucumber.sorting.SortingMethod;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class CucumberReporting {

    public void generateCucumberReport() {
        File reportOutputDirectory = new File(".");
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("cucumber-test-results/cucumber-report.json");

        String buildNumber = "1";
        String projectName = "MyTest";
        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        configuration.setBuildNumber(buildNumber);

        configuration.addClassifications("Browser", "Edge");
        configuration.addClassifications("Branch", "master");
        configuration.setSortingMethod(SortingMethod.NATURAL);
        configuration.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);
        configuration.addPresentationModes(PresentationMode.PARALLEL_TESTING);

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }

}
