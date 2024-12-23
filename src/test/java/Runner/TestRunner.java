package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
//        dryRun = true,
        plugin = {"pretty", "html:target/cucumber-reports",
        "html:target/cucumber-report/cucumber.html",
        "html:target/cucumber-report.html",
        "json:target/cucumber.json"},
        features = "src/test/java/Feature/",
        glue = {"steps","Runner"}



)
public class TestRunner {
}
