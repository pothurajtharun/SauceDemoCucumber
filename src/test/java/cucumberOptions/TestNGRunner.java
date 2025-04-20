package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@CucumberOptions(
    features = "src/test/java/features",
    glue = "stepDefinitions",
    monochrome = true,
    tags = "@HomePage",
    plugin = {
      "html:target/cucumber.html",
      "json:target/cucumber.json",
      "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    })
public class TestNGRunner extends AbstractTestNGCucumberTests {

  private static final Logger log = LogManager.getLogger(TestNGRunner.class);

  static {
    log.info("TestNG Runner has started.");
  }
}
