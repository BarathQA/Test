package com.app.test.application.runnerLibrary;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumberExtentReport/report.html",
        "json:reports/cucumber.json",
        "junit:reports/cucumber.xml"},
        format = {"pretty", "html:target/cucumberHTMLReports"},
        features = {"src/test/resources/featuresFiles/AutomationPractice.feature"},
        glue = {"com.app.test.application"},


//        tags={"@functionality2"},
        monochrome = true
        )

public class commonRunner {}