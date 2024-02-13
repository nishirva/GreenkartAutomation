package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\SREEPM\\eclipse-workspace\\first\\.metadata\\Automation\\src\\test\\java\\Featurefiles\\First.feature",
        glue = "StepDefinition",
        dryRun = false,
        monochrome=false,
        plugin = {"pretty", "html:target/First-report.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}       
)
public class First_Runner {

}
