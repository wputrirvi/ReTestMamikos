package runner;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:Scenario"},
        glue = {"classpath:StepDefinition"},
        tags = "@Testing",
        monochrome = true,
        plugin = {"pretty","json:target/Cucumber.json", "html:target/cucumber-reports"}
)

public class runner {
}