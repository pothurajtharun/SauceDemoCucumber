package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

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

  @DataProvider
  @Override
  public Object[][] scenarios() {
    return super.scenarios();
  }
}
