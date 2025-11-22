package com.framework.hooks;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"com.framework.steps", "com.framework.hooks"},
    plugin = {"pretty", "json:target/cucumber-report.json"}
)
public class TestNGRunner extends AbstractTestNGCucumberTests {
    // inherits running behavior; TestNG suite controls parallelism
}
