package Runner;
import org.junit.Test;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"C:\\Users\\SREEPM\\eclipse-workspace\\first\\.metadata\\Automation\\src\\test\\java\\Featurefiles\\Fifth.feature"},
        glue = {"StepDefinition"},
        monochrome=false,
        plugin = {"pretty", "html:target/Fifth-report.html",
        		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class Fifth_Runner {
	@Test
	public void dummyTestMethod() {
	    // Dummy test method to satisfy JUnit requirements
}
}