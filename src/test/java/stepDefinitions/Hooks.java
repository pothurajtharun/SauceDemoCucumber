package stepDefinitions;

import static utils.PropertyReader.getValueByProperty;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.TestContextSetup;

public class Hooks {

  WebDriver driver;
  TestContextSetup testContextSetup;

  public Hooks(TestContextSetup testContextSetup) {
    this.testContextSetup = testContextSetup;
    driver = testContextSetup.testBase.WebDriverManager();
  }

  @Before("@HomePage")
  public void loginBeforeHomePage() {
    testContextSetup
        .pageObjectFactory
        .getLoginPage()
        .verifyLogin(getValueByProperty("sauce.username"), getValueByProperty("sauce.password"));
  }

  @After
  public void AfterScenario() {
    testContextSetup.testBase.WebDriverManager().quit();
  }

  @AfterStep
  public void AddScreenshot(Scenario scenario) throws IOException {
    if (scenario.isFailed()) {
      File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
      scenario.attach(fileContent, "image/png", "image");
    }
  }
}
