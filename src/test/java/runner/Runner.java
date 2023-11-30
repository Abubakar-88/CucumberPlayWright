package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features= {"src/test/resources/features"},
        glue= {"steps"},
      //  tags="@carprices",
        plugin= {"html:target/cucumber-reports/cucumber-html-report.html"})

public class Runner extends AbstractTestNGCucumberTests {

}
