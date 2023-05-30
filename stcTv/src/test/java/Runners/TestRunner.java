package Runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/main/resources/Features",
        glue = {"stepDefinition.steps"},
        plugin = {    "pretty",
                "html:target/cucumber.html",
                "json:target/cucumber.json",
        },
        tags = "@smoke"

)

public class TestRunner {
}
