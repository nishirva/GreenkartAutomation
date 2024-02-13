package Runner;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\SREEPM\\eclipse-workspace\\first\\.metadata\\Automation\\src\\test\\java\\Featurefiles\\Third.feature",
        glue = "StepDefinition",
        dryRun = false,
        monochrome=false,
        plugin = {"pretty", "json:target/Third-report.json","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)

public class Third_Runner {
	@Test
	public void dummyTestMethod() {
	    // Dummy test method to satisfy JUnit requirements
	}
}
