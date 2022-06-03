package Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/Feature.feature",
glue="glue",
plugin= {"pretty","html:target/myresults/myresults"},
monochrome=true
)
public class Runnerclass 
{
}
