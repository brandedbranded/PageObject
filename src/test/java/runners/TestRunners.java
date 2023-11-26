package runners;

import io.cucumber.junit.*;
import org.junit.runner.*;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"src/test/java/stepdefinitions"}
)
public class TestRunners {

    /*@BeforeAll
    public static void setupSelenideTimeout() {
        Configuration.timeout = 10000;
    }*/
}
