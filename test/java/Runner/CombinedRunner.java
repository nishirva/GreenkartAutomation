package Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {
        "src\\test\\java\\Featurefiles"
    },
    glue = {"StepDefinition"},
    dryRun = false,
    monochrome = false,
    plugin = {
        "pretty",
        "html:target/Combined-report.html",
        "json:target/Combined-report.json",
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
    }
)
public class CombinedRunner {
   
}















/* {
        "C:\\Users\\SREEPM\\eclipse-workspace\\first\\.metadata\\Automation\\src\\test\\java\\Featurefiles\\First.feature",
        "C:\\Users\\SREEPM\\eclipse-workspace\\first\\.metadata\\Automation\\src\\test\\java\\Featurefiles\\Second.feature",
        "C:\\Users\\SREEPM\\eclipse-workspace\\first\\.metadata\\Automation\\src\\test\\java\\Featurefiles\\Third.feature",
        "C:\\Users\\SREEPM\\eclipse-workspace\\first\\.metadata\\Automation\\src\\test\\java\\Featurefiles\\Fourth.feature",
        "C:\\Users\\SREEPM\\eclipse-workspace\\first\\.metadata\\Automation\\src\\test\\java\\Featurefiles\\Fifth.feature"
    }, */