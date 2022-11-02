package StepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",glue={"StepDefinitions"},
monochrome=true,
plugin={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"pretty","html:target/HtmlReports/report.html"},
publish = true,
tags= "@smoke or @regression"
		)

public class TestRunner {
	
	

}
