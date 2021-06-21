package com.andrewfoote;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(TestRunnerSerenity.class)
@CucumberOptions(
        glue = {"com.andrewfoote.stepdefinitions"},
        plugin = {"pretty:output", "html:target/cucumber"},
        features = "classpath:features"
)
public class TestRunner {
}
