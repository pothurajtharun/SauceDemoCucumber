package utils;

import static utils.PropertyReader.getValueByProperty;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {

  WebDriver driver;

  public WebDriver WebDriverManager() {

    if (driver == null) {
      System.setProperty(
          "webdriver.chrome.driver",
          System.getProperty("user.dir") + "/src/test/resources/chromedriver");

      final Map<String, Object> chromePrefs = new HashMap<>();
      chromePrefs.put("credentials_enable_service", false);
      chromePrefs.put("profile.password_manager_enabled", false);
      chromePrefs.put(
          "profile.password_manager_leak_detection", false); // <======== This is the important one

      final ChromeOptions chromeOptions = new ChromeOptions();
      chromeOptions.setExperimentalOption("prefs", chromePrefs);

      driver = new ChromeDriver(chromeOptions);
      driver.manage().window().maximize();
      driver.get(getValueByProperty("baseurl"));
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    return driver;
  }
}
