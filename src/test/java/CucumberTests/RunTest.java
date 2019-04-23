package CucumberTests;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(plugin = {"progress", "html:target/cucumber-html-report"},
        features = "src/test/resources",
        tags = "@test")

public class RunTest extends AbstractTestNGCucumberTests {
}
